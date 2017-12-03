package com.regexgame.server;

import com.regexgame.*;
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

public class RegexGameImpl extends RegexGameGrpc.RegexGameImplBase {
    @Override
    public void getMessage(GetMessageRequest request, StreamObserver<GetMessageReply> responseObserver) {
        GetMessageReply reply = GetMessageReply.newBuilder().setMessage("Hello, " + request.getName() + "!").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getEvents(GetEventsRequest request, StreamObserver<GameEvent> responseObserver) {
        GameEvent event = GameEvent.newBuilder().setNumberChanged(NumberChanged.newBuilder().setValue(42)).build();
        responseObserver.onNext(event);
        responseObserver.onCompleted();
    }

    @Override
    public void makeAction(MakeActionRequest request, StreamObserver<MakeActionReply> responseObserver) {
        responseObserver.onCompleted();
    }

    @Override
    public void createMatch(CreateMatchRequest request, StreamObserver<CreateMatchReply> responseObserver) {
        // TODO(akashin): Create new match here.
    }
}
