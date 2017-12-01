package com.regexgame.server;

import com.regexgame.GetMessageReply;
import com.regexgame.GetMessageRequest;
import com.regexgame.RegexGameGrpc;
import io.grpc.stub.StreamObserver;

public class RegexGameImpl extends RegexGameGrpc.RegexGameImplBase {
    @Override
    public void getMessage(GetMessageRequest request, StreamObserver<GetMessageReply> responseObserver) {
        GetMessageReply reply = GetMessageReply.newBuilder().setMessage("Hello, " + request.getName() + "!").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
