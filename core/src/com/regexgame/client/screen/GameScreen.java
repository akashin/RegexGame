package com.regexgame.client.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.AtomicQueue;
import com.regexgame.GameEvent;
import com.regexgame.client.MatchConnection;
import com.regexgame.client.RegexGameClient;
import com.regexgame.client.view.CardView;
import com.regexgame.game.Card;
import com.regexgame.game.GameState;
import com.regexgame.game.Player;
import com.regexgame.game.event.*;
import io.grpc.stub.StreamObserver;

import java.util.Random;

public class GameScreen extends BasicScreen {
    private HorizontalGroup enemyHandGroup;

    private HorizontalGroup enemyPlayGroup;

    private HorizontalGroup playerPlayGroup;

    private HorizontalGroup playerHandGroup;

    private GameState gameState;

    private Player player;
    private MatchConnection matchConnection;

    private final int incomingEventsQueueCapacity = 1000;
    AtomicQueue<Event> incomingEvents;

    private Array<EventHandler> eventHandlers;

    Array<Event> getAllIncomingEvents() {
        Array<Event> events = new Array<>();
        while (true) {
            Event event = incomingEvents.poll();
            if (event == null) {
                break;
            }
            events.add(event);
        }
        return events;
    }

    public GameScreen(RegexGameClient game, MatchConnection matchConnection) {
        super(game);
        this.matchConnection = matchConnection;
        player = this.matchConnection.getPlayer();
        incomingEvents = new AtomicQueue<>(incomingEventsQueueCapacity);

        this.matchConnection.getEvents(new StreamObserver<GameEvent>() {
            @Override
            public void onNext(GameEvent value) {
                Event parsed = ProtoParser.parseEvent(value);
                if (parsed != null) {
                    incomingEvents.put(parsed);
                }
            }

            @Override
            public void onError(Throwable t) {
                Gdx.app.log("ERROR", "Error received: " + t.toString());
            }

            @Override
            public void onCompleted() {
                Gdx.app.log("INFO", "Match completed.");
            }
        });

        // TODO: load GameState from server
        gameState = new GameState();
        generateRandomCards();

        eventHandlers = new Array<>();
        eventHandlers.add(new AttackEventHandler());
        eventHandlers.add(new GameStateUpdateEventHandler());
    }

    @Override
    public void show() {
        super.show();
        Table table = new Table();

        enemyHandGroup = new HorizontalGroup();
        enemyPlayGroup = new HorizontalGroup();
        playerPlayGroup = new HorizontalGroup();
        playerHandGroup = new HorizontalGroup();

        table.add(enemyHandGroup);
        table.row();
        table.add(enemyPlayGroup);
        table.row();
        table.add(playerPlayGroup);
        table.row();
        table.add(playerHandGroup);
        table.row();

        table.setFillParent(true);

        class CardInputListener extends InputListener {
            private final int cardId;

            private CardInputListener(int cardId) {
                this.cardId = cardId;
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (gameState.getCurrentPlayer() != player) {
                    return;
                }

                if (gameState.isCardInPlay(player, cardId)) {
                    CardView cardView = (CardView) event.getListenerActor();
                    cardView.setSelected(!cardView.isSelected());
                    gameState.selectCardToPlay(cardId);
                } else if (gameState.isCardInPlay(player.getOpposite(), cardId)) {
                    for (Actor actor : playerPlayGroup.getChildren()) {
                        ((CardView) actor).setSelected(false);
                    }
                    Array<Integer> playerCards = gameState.getSelectedCards(player);
                    Array<Integer> enemyCards = new Array<>();
                    enemyCards.add(cardId);
                    matchConnection.sendAttackAction(playerCards, enemyCards);
                    gameState.resetSelection();
                }
            }
        }

        for (Card card : gameState.getCardsInHand(Player.Second)) {
            Actor cardView = new CardView(card, game.getAssetManager());
            cardView.addListener(new CardInputListener(card.getId()));
            enemyHandGroup.addActor(cardView);
        }
        for (Card card : gameState.getCardsInPlay(Player.Second)) {
            Actor cardView = new CardView(card, game.getAssetManager());
            cardView.addListener(new CardInputListener(card.getId()));
            enemyPlayGroup.addActor(cardView);
        }
        for (Card card : gameState.getCardsInPlay(Player.First)) {
            Actor cardView = new CardView(card, game.getAssetManager());
            cardView.addListener(new CardInputListener(card.getId()));
            playerPlayGroup.addActor(cardView);
        }
        for (Card card : gameState.getCardsInHand(Player.First)) {
            Actor cardView = new CardView(card, game.getAssetManager());
            cardView.addListener(new CardInputListener(card.getId()));
            playerHandGroup.addActor(cardView);
        }

        stage.addActor(table);
    }

    @Override
    protected void update(float delta) {
        super.update(delta);

        Array<Event> events = getAllIncomingEvents();
        for (Event event : events) {
            EventResponse response = handleEvent(event);
            Gdx.app.log("EventResponse", response.getClass().getName());
        }
    }

    private EventResponse handleEvent(Event event) {
        for (EventHandler eventHandler : eventHandlers) {
            if (eventHandler.canBeHandled(gameState, event)) {
                return eventHandler.handle(gameState, event);
            }
        }
        throw new RuntimeException("Event was not handled");
    }

    // TODO: remove this
    private Card generateRandomCard(Random random, int id) {
        String attack = Integer.toString(random.nextInt(10) + 1);
        String defence = Integer.toString(random.nextInt(20) + 1);
        return new Card(id, attack, defence);
    }

    // TODO: remove this
    private void generateRandomCards() {
        Random random = new Random();

        int lastId = 0;

        for (int i = 0; i < 4; ++i) {
            Card card = generateRandomCard(random, lastId++);
            gameState.getCardsInHand(Player.First).add(card);
        }
        for (int i = 0; i < 3; ++i) {
            Card card = generateRandomCard(random, lastId++);
            gameState.getCardsInPlay(Player.First).add(card);
        }

        for (int i = 0; i < 4; ++i) {
            Card card = generateRandomCard(random, lastId++);
            gameState.getCardsInHand(Player.Second).add(card);
        }
        for (int i = 0; i < 3; ++i) {
            Card card = generateRandomCard(random, lastId++);
            gameState.getCardsInPlay(Player.Second).add(card);
        }
    }
}
