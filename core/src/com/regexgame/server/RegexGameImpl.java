package com.regexgame.server;

import com.regexgame.CreateMatchReply;
import com.regexgame.CreateMatchRequest;
import com.regexgame.GameEvent;
import com.regexgame.GetEventsRequest;
import com.regexgame.GetMessageReply;
import com.regexgame.GetMessageRequest;
import com.regexgame.MakeActionReply;
import com.regexgame.MakeActionRequest;
import com.regexgame.NumberChanged;
import com.regexgame.RegexGameGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;

public class RegexGameImpl extends RegexGameGrpc.RegexGameImplBase {
    HashMap<Long, GameMatch> active_matches;
    long first_free_match_index = 0;

    public RegexGameImpl() {
        this.active_matches = new HashMap<Long, GameMatch>();
    }

    private long generate_match_index() {
        return first_free_match_index++;
    }

    @Override
    public void getMessage(GetMessageRequest request, StreamObserver<GetMessageReply> responseObserver) {
        GetMessageReply reply = GetMessageReply.newBuilder().setMessage("Hello, " + request.getName() + "!").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getEvents(GetEventsRequest request, StreamObserver<GameEvent> responseObserver) {
        if (!this.active_matches.containsKey(request.getMatchId())) {
            responseObserver.onError(new Exception("No match with id " + request.getMatchId() + " found."));
            return;
        }
        GameMatch match = this.active_matches.get(request.getMatchId());
        match.subscribeForEvents(responseObserver);
    }

    @Override
    public void makeAction(MakeActionRequest request, StreamObserver<MakeActionReply> responseObserver) {
        if (!this.active_matches.containsKey(request.getMatchId())) {
            responseObserver.onError(new Exception("No match with id " + request.getMatchId() + " found."));
            return;
        }
        GameMatch match = this.active_matches.get(request.getMatchId());

        switch (request.getAction().getActionCase()) {
            case INCREASE_NUMBER: { match.increaseValue(); break; }
            case DECREASE_NUMBER: { match.decreaseValue(); break; }
            case ATTACK_CARD: { match.attackCard(request.getPlayerId(), request.getAction().getAttackCard()); break; }
            default: { responseObserver.onError(new Exception("Unexpected action.")); return; }
        }
        responseObserver.onNext(MakeActionReply.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void createMatch(CreateMatchRequest request, StreamObserver<CreateMatchReply> responseObserver) {
        long new_match_index = generate_match_index();
        this.active_matches.put(new_match_index, new GameMatch());
        responseObserver.onNext(CreateMatchReply.newBuilder().setMatchId(new_match_index).build());
        responseObserver.onCompleted();
    }
}
