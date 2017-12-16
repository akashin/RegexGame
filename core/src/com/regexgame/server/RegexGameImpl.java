package com.regexgame.server;

import com.badlogic.gdx.Gdx;
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
import io.grpc.Status;
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

    boolean validateMatchId(long matchId, StreamObserver<?> responseObserver) {
        if (!this.activeMatches.containsKey(matchId)) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("No match with id " + matchId + " found.")
                    .asRuntimeException());
            return false;
        }
        return true;
    }

    @Override
    public void getEvents(GetEventsRequest request, StreamObserver<GameEvent> responseObserver) {
        if (!validateMatchId(request.getMatchId(), responseObserver)) {
            return;
        }

        GameMatch match = this.activeMatches.get(request.getMatchId());
        match.subscribeForEvents(request.getSessionToken(), responseObserver);
    }

    @Override
    public void makeAction(MakeActionRequest request, StreamObserver<MakeActionReply> responseObserver) {
        if (!validateMatchId(request.getMatchId(), responseObserver)) {
            return;
        }

        GameMatch match = this.activeMatches.get(request.getMatchId());
        try {
            switch (request.getAction().getActionCase()) {
                case ATTACK_CARD: {
                    Gdx.app.log("INFO", "Attack action: " + request.getAction());
                    match.attackCard(request.getSessionToken(), request.getAction().getAttackCard());
                    break;
                }
                default: {
                    throw new Exception("Unexpected action.");
                }
            }
        } catch (Exception e) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription(e.getMessage())
                    .withCause(e) // This can be attached to the Status locally, but NOT transmitted to the client!
                    .asRuntimeException());
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
        if (!validateMatchId(request.getMatchId(), responseObserver)) {
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
            if (match.value.getState() == GameMatch.MatchState.WaitingForPlayers) {
                matchId = match.key;
                break;
            }
        }
        responseObserver.onNext(FindMatchReply.newBuilder().setMatchId(matchId).build());
        responseObserver.onCompleted();
    }
}
