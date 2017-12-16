package com.regexgame.client;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
import com.regexgame.client.screen.GameScreen;

public class RegexGameClient extends Game {
    // Object to maintain the connection with the game server.
    NetworkSession networkSession;
    MatchConnection matchConnection;

    private AssetManager assetManager;

    @Override
    public void create() {
        loadAssets();

        networkSession = new NetworkSession("localhost", 6001, false);

        long matchId = networkSession.findMatch();
        if (matchId == 0) {
            matchId = networkSession.createMatch();
        }
        assert matchId != 0;
        matchConnection = networkSession.joinMatch(matchId);
        Gdx.app.log("INFO", "Connected to match " + matchId + " as player " + matchConnection.getPlayer());

        setScreen(new GameScreen(this, matchConnection));
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
    }

    @Override
    public void dispose() {
        super.dispose();
        assetManager.dispose();
    }
}
