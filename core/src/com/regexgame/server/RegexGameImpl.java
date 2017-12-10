package com.regexgame.server;

import com.badlogic.gdx.utils.LongMap;
import com.regexgame.CreateMatchReply;
import com.regexgame.CreateMatchRequest;
import com.regexgame.FindMatchReply;
import com.regexgame.FindMatchRequest;
import com.regexgame.GameEvent;
import com.regexgame.GetEventsRequest;
import com.regexgame.JoinMatchReply;
import com.regexgame.JoinMatchRequest;
import com.regexgame.LoginReply;
import com.regexgame.LoginRequest;
import com.regexgame.MakeActionReply;
import com.regexgame.MakeActionRequest;
import com.regexgame.RegexGameGrpc;
import com.regexgame.game.Player;
import io.grpc.stub.StreamObserver;

public class RegexGameImpl extends RegexGameGrpc.RegexGameImplBase {
    LongMap<GameMatch> activeMatches;
    long firstFreeMatchIndex = 1;
    long firstFreeSessionToken = 1;

    public RegexGameImpl() {
        this.activeMatches = new LongMap<>();
    }

    private long generateMatchIndex() {
        return firstFreeMatchIndex++;
    }

    private long generateSessionToken() {
        return firstFreeSessionToken++;
    }

    @Override
    public void login(LoginRequest request, StreamObserver<LoginReply> responseObserver) {
        responseObserver.onNext(LoginReply.newBuilder().setSessionToken(generateSessionToken()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getEvents(GetEventsRequest request, StreamObserver<GameEvent> responseObserver) {
        if (!this.activeMatches.containsKey(request.getMatchId())) {
            responseObserver.onError(new Exception("No match with id " + request.getMatchId() + " found."));
            return;
        }
        GameMatch match = this.activeMatches.get(request.getMatchId());
        match.subscribeForEvents(request.getSessionToken(), responseObserver);
    }

    @Override
    public void makeAction(MakeActionRequest request, StreamObserver<MakeActionReply> responseObserver) {
        if (!this.activeMatches.containsKey(request.getMatchId())) {
            responseObserver.onError(new Exception("No match with id " + request.getMatchId() + " found."));
            return;
        }
        GameMatch match = this.activeMatches.get(request.getMatchId());

        try {
            switch (request.getAction().getActionCase()) {
                case INCREASE_NUMBER: {
                    match.increaseValue();
                    break;
                }
                case DECREASE_NUMBER: {
                    match.decreaseValue();
                    break;
                }
                case ATTACK_CARD: {
                    match.attackCard(request.getSessionToken(), request.getAction().getAttackCard());
                    break;
                }
                default: {
                    throw new Exception("Unexpected action.");
                }
            }
        } catch (Exception e) {
            responseObserver.onError(e);
            return;
        }
        responseObserver.onNext(MakeActionReply.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void createMatch(CreateMatchRequest request, StreamObserver<CreateMatchReply> responseObserver) {
        long newMatchIndex = generateMatchIndex();
        this.activeMatches.put(newMatchIndex, new GameMatch());
        responseObserver.onNext(CreateMatchReply.newBuilder().setMatchId(newMatchIndex).build());
        responseObserver.onCompleted();
    }

    @Override
    public void joinMatch(JoinMatchRequest request, StreamObserver<JoinMatchReply> responseObserver) {
        // TODO(akashin): Move this to a separate function.
        if (!this.activeMatches.containsKey(request.getMatchId())) {
            responseObserver.onError(new Exception("No match with id " + request.getMatchId() + " found."));
            return;
        }

        Player player = this.activeMatches.get(request.getMatchId()).addPlayer(request.getSessionToken());
        responseObserver.onNext(JoinMatchReply.newBuilder().setPlayerId(player.index).build());
        responseObserver.onCompleted();
    }

    @Override
    public void findMatch(FindMatchRequest request, StreamObserver<FindMatchReply> responseObserver) {
        long matchId = 0;
        for (LongMap.Entry<GameMatch> match : activeMatches) {
            if (match.value.getMatchState() == GameMatch.MatchState.WaitingForPlayers) {
                matchId = match.key;
                break;
            }
        }
        responseObserver.onNext(FindMatchReply.newBuilder().setMatchId(matchId).build());
        responseObserver.onCompleted();
    }
}
