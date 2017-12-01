package com.regexgame.client;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.regexgame.GetMessageReply;
import com.regexgame.GetMessageRequest;
import com.regexgame.RegexGameGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class RegexGameClient extends ApplicationAdapter {
    SpriteBatch batch;
    //	Texture img;
    private BitmapFont font;

    private ManagedChannel channel;
    private RegexGameGrpc.RegexGameBlockingStub blockingStub;

    @Override
    public void create() {
        channel = ManagedChannelBuilder.forAddress("localhost", 6001).usePlaintext(true).build();
        blockingStub = RegexGameGrpc.newBlockingStub(channel);

        batch = new SpriteBatch();
        font = new BitmapFont();
//		img = new Texture("badlogic.jpg");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        GetMessageRequest request = GetMessageRequest.newBuilder().setName("client").build();
        GetMessageReply reply = blockingStub.getMessage(request);

        font.draw(batch, reply.getMessage(), 200, 200);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
//		img.dispose();
    }
}
