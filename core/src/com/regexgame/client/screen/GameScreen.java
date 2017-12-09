package com.regexgame.client.screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.regexgame.client.RegexGameClient;
import com.regexgame.client.view.CardView;
import com.regexgame.game.Card;
import com.regexgame.game.GameState;

import java.util.Random;

public class GameScreen extends BasicScreen {
    private HorizontalGroup enemyHandGroup;

    private HorizontalGroup enemyPlayGroup;

    private HorizontalGroup playerPlayGroup;

    private HorizontalGroup playerHandGroup;

    private GameState gameState;

    public GameScreen(RegexGameClient client) {
        super(client);

        // TODO: load GameState from server
        gameState = new GameState();
        generateRandomCards();
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

        for (Card card : gameState.getHand(GameState.Player.Second)) {
            Actor cardView = new CardView(card, client.getAssetManager());
            enemyHandGroup.addActor(cardView);
        }
        for (Card card : gameState.getInPlay(GameState.Player.Second)) {
            Actor cardView = new CardView(card, client.getAssetManager());
            enemyPlayGroup.addActor(cardView);
        }
        for (Card card : gameState.getInPlay(GameState.Player.First)) {
            Actor cardView = new CardView(card, client.getAssetManager());
            playerPlayGroup.addActor(cardView);
        }
        for (Card card : gameState.getHand(GameState.Player.First)) {
            Actor cardView = new CardView(card, client.getAssetManager());
            playerHandGroup.addActor(cardView);
        }

        stage.addActor(table);
    }

    // TODO: remove this
    private Card generateRandomCard(Random random) {
        String attack = Integer.toString(random.nextInt(10) + 1);
        String defence = Integer.toString(random.nextInt(20) + 1);
        return new Card(attack, defence);
    }

    // TODO: remove this
    private void generateRandomCards() {
        Random random = new Random();

        for (int i = 0; i < 4; ++i) {
            Card card = generateRandomCard(random);
            gameState.getHand(GameState.Player.First).add(card);
        }
        for (int i = 0; i < 3; ++i) {
            Card card = generateRandomCard(random);
            gameState.getInPlay(GameState.Player.First).add(card);
        }

        for (int i = 0; i < 4; ++i) {
            Card card = generateRandomCard(random);
            gameState.getHand(GameState.Player.Second).add(card);
        }
        for (int i = 0; i < 3; ++i) {
            Card card = generateRandomCard(random);
            gameState.getInPlay(GameState.Player.Second).add(card);
        }
    }
}
