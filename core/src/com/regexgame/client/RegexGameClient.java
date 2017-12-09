package com.regexgame.client;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter;
import com.regexgame.CreateMatchReply;
import com.regexgame.CreateMatchRequest;
import com.regexgame.GameAction;
import com.regexgame.GameEvent;
import com.regexgame.GetEventsRequest;
import com.regexgame.GetMessageReply;
import com.regexgame.GetMessageRequest;
import com.regexgame.IncreaseNumber;
import com.regexgame.MakeActionRequest;
import com.regexgame.RegexGameGrpc;
import com.regexgame.client.screen.GameScreen;
import com.regexgame.server.RegexGameServer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class RegexGameClient extends Game {
    // Objects to maintain the connection with the game server.
    private ManagedChannel channel;
    private RegexGameGrpc.RegexGameStub stub;
    private RegexGameGrpc.RegexGameBlockingStub blockingStub;

    private AssetManager assetManager;

    private void connectToServer(String address, int port, boolean start_local_server) {
        if (start_local_server) {
            RegexGameServer server = new RegexGameServer();
            try {
                server.start(port, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            channel = InProcessChannelBuilder.forName("regexgame_server").usePlaintext(true).build();
        } else {
            channel = OkHttpChannelBuilder.forAddress(address, port).usePlaintext(true).build();
        }
        stub = RegexGameGrpc.newStub(channel);
        blockingStub = RegexGameGrpc.newBlockingStub(channel);
    }

    @Override
    public void create() {
        loadAssets();

        connectToServer("localhost", 6001, true);

        System.err.println("Creating match");
        long start = System.currentTimeMillis();
        CreateMatchReply reply = blockingStub.createMatch(CreateMatchRequest.getDefaultInstance());
        long end = System.currentTimeMillis();
        System.err.println("Match created: " + reply.getMatchId() + " in " + (end - start) / 1000.0);

        stub.getEvents(GetEventsRequest.newBuilder().setMatchId(reply.getMatchId()).build(), new StreamObserver<com.regexgame.GameEvent>() {
            @Override
            public void onNext(GameEvent value) {
                switch (value.getEventCase()) {
                    case CARD_ATTACKED: {
                        System.err.println("Card attacked: " + value);
                        break;
                    }
                    default: {
                        System.err.println("Unrecognized event: " + value);
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error received: " + t.toString());
            }

            @Override
            public void onCompleted() {
                System.err.println("Match completed");
            }
        });

        setScreen(new GameScreen(this));
    }

    private void loadAssets() {
        assetManager = new AssetManager();
        assetManager.load("empty.png", Texture.class);

        FileHandleResolver resolver = new InternalFileHandleResolver();
        assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        FreeTypeFontLoaderParameter fontLoaderParameters = new FreeTypeFontLoaderParameter();
        fontLoaderParameters.fontFileName = "arial.ttf";
        fontLoaderParameters.fontParameters.size = 10;
        fontLoaderParameters.fontParameters.color = Color.BLACK;
        assetManager.load("size15.ttf", BitmapFont.class, fontLoaderParameters);

        assetManager.finishLoading();
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    @Override
    public void render() {
        super.render();
//        GameAction action = GameAction.newBuilder().setIncreaseNumber(IncreaseNumber.getDefaultInstance()).build();
//        blockingStub.makeAction(MakeActionRequest.newBuilder().setAction(action).build());
    }

    @Override
    public void dispose() {
        super.dispose();
        assetManager.dispose();
    }
}
