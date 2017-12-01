package com.regxkcd.server;

import com.regxkcd.GetMessageReply;
import com.regxkcd.GetMessageRequest;
import com.regxkcd.RegxkcdGrpc;
import io.grpc.stub.StreamObserver;

public class RegxkcdImpl extends RegxkcdGrpc.RegxkcdImplBase {
    @Override
    public void getMessage(GetMessageRequest request, StreamObserver<GetMessageReply> responseObserver) {
        GetMessageReply reply = GetMessageReply.newBuilder().setMessage("Hello, " + request.getName() + "!").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
