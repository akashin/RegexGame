package com.regexgame.client;

import com.badlogic.gdx.Game;
import com.regexgame.GetMessageReply;
import com.regexgame.GetMessageRequest;
import com.regexgame.RegexGameGrpc;
import com.regexgame.client.screen.GameScreen;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class RegexGameClient extends Game {
    private ManagedChannel channel;
    private RegexGameGrpc.RegexGameBlockingStub blockingStub;

    @Override
    public void create() {
        channel = ManagedChannelBuilder.forAddress("localhost", 6001).usePlaintext(true).build();
        blockingStub = RegexGameGrpc.newBlockingStub(channel);
        setScreen(new GameScreen(this));
    }

    @Override
    public void render() {
        super.render();
        System.err.println("Doing some networking shit...");
        GetMessageRequest request = GetMessageRequest.newBuilder().setName("client").build();
        GetMessageReply reply = blockingStub.getMessage(request);
        System.err.println("Done with all this networking shit!");
    }
}
