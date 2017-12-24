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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.regexgame.client.screen.GameScreen;
import com.regexgame.client.screen.MatchResultsScreen;

public class RegexGameClient extends Game {
    // Object to maintain the connection with the game server.
    NetworkSession networkSession;
    MatchConnection matchConnection;

    private AssetManager assetManager;

    private Skin skin;

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

        {
            FreeTypeFontLoaderParameter fontLoaderParameters = new FreeTypeFontLoaderParameter();
            fontLoaderParameters.fontFileName = "arial.ttf";
            fontLoaderParameters.fontParameters.size = 15;
            fontLoaderParameters.fontParameters.color = Color.WHITE;
            assetManager.load("size15w.ttf", BitmapFont.class, fontLoaderParameters);
        }

        {
            FreeTypeFontLoaderParameter fontLoaderParameters = new FreeTypeFontLoaderParameter();
            fontLoaderParameters.fontFileName = "arial.ttf";
            fontLoaderParameters.fontParameters.size = 10;
            fontLoaderParameters.fontParameters.color = Color.BLACK;
            assetManager.load("size10b.ttf", BitmapFont.class, fontLoaderParameters);
        }

        assetManager.finishLoading();

        BitmapFont font15 = assetManager.get("size15w.ttf", BitmapFont.class);
        skin = new Skin();
        Label.LabelStyle labelStyle = new Label.LabelStyle(font15, Color.WHITE);
        skin.add("default", labelStyle, Label.LabelStyle.class);
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public Skin getSkin() {
        return skin;
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
