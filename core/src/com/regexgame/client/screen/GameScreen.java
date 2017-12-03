package com.regexgame.client.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.regexgame.client.RegexGameClient;
import com.regexgame.client.view.CardView;
import com.regexgame.game.Card;

public class GameScreen extends BasicScreen {
    private HorizontalGroup enemyHandGroup;

    private HorizontalGroup enemyPlayGroup;

    private HorizontalGroup playerPlayGroup;

    private HorizontalGroup playerHandGroup;


    public GameScreen(RegexGameClient client) {
        super(client);
    }

    @Override
    public void show() {
        super.show();
        Table table = new Table();

        enemyHandGroup = new HorizontalGroup();;
        enemyPlayGroup = new HorizontalGroup();;
        playerPlayGroup = new HorizontalGroup();;
        playerHandGroup = new HorizontalGroup();;

        table.add(enemyHandGroup);
        table.row();
        table.add(enemyPlayGroup);
        table.row();
        table.add(playerPlayGroup);
        table.row();
        table.add(playerHandGroup);
        table.row();

        table.setFillParent(true);

        initCards();

        stage.addActor(table);
    }

    private void initCards() {
        for (int i = 0; i < 4; ++i) {
            Card card = new Card();
            card.title = Integer.toString(i);
            Actor cardView = new CardView(card, client.getAssetManager());
            enemyHandGroup.addActor(cardView);
        }

        for (int i = 0; i < 3; ++i) {
            Card card = new Card();
            card.title = Integer.toString(i);
            Actor cardView = new CardView(card, client.getAssetManager());
            enemyPlayGroup.addActor(cardView);
        }

        for (int i = 0; i < 3; ++i) {
            Card card = new Card();
            card.title = Integer.toString(i);
            Actor cardView = new CardView(card, client.getAssetManager());
            playerPlayGroup.addActor(cardView);
        }

        for (int i = 0; i < 4; ++i) {
            Card card = new Card();
            card.title = Integer.toString(i);
            Actor cardView = new CardView(card, client.getAssetManager());
            playerHandGroup.addActor(cardView);
        }
    }
}
