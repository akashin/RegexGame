package com.regexgame.client.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.AtomicQueue;
import com.regexgame.GameEvent;
import com.regexgame.client.MatchConnection;
import com.regexgame.client.RegexGameClient;
import com.regexgame.client.view.CardView;
import com.regexgame.game.Card;
import com.regexgame.game.MatchState;
import com.regexgame.game.Player;
import com.regexgame.game.event.*;
import io.grpc.stub.StreamObserver;

public class GameScreen extends BasicScreen {
    private static final String CLIENT_PLAYER_PREFIX = "YOU: ";
    private static final String CURRENT_PLAYER_PREFIX = "CURRENT: ";
    private static final String HEALTH_PREFIX = "HEALTH: ";

    private HorizontalGroup enemyHandGroup;
    private HorizontalGroup enemyPlayGroup;
    private HorizontalGroup playerPlayGroup;
    private HorizontalGroup playerHandGroup;

    private Label currentPlayerLabel;
    private Label clientPlayerLabel;
    private Label enemyHealthLabel;
    private Label playerHealthLabel;

    private MatchState matchState;
    private Player clientPlayer;

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
        clientPlayer = this.matchConnection.getPlayer();
        incomingEvents = new AtomicQueue<>(incomingEventsQueueCapacity);

        this.matchConnection.getEvents(new StreamObserver<GameEvent>() {
            @Override
            public void onNext(GameEvent value) {
                try {
                    Event parsed = ProtoParser.parseEvent(value);
                    if (parsed != null) {
                        incomingEvents.put(parsed);
                    }
                } catch (Throwable t) {
                    Gdx.app.log("ERROR","Failed to process event: " + t);
                    throw t;
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

        matchState = new MatchState();

        eventHandlers = new Array<>();
        eventHandlers.add(new AttackEventHandler());
        eventHandlers.add(new GameStateUpdateEventHandler());
    }

    @Override
    public void show() {
        super.show();

        // Table with all game elements
        Table gameTable = new Table();
        gameTable.setFillParent(true);

        enemyHandGroup = new HorizontalGroup();
        enemyPlayGroup = new HorizontalGroup();
        playerPlayGroup = new HorizontalGroup();
        playerHandGroup = new HorizontalGroup();

        gameTable.add(enemyHandGroup);
        gameTable.row();
        gameTable.add(enemyPlayGroup);
        gameTable.row();
        gameTable.add(playerPlayGroup);
        gameTable.row();
        gameTable.add(playerHandGroup);
        gameTable.row();


        // Table with gui over gameTable
        Table guiTable = new Table();
        guiTable.setFillParent(true);
//        guiTable.setDebug(true);

        currentPlayerLabel = new Label(CURRENT_PLAYER_PREFIX + Player.First.toString(), game.getSkin());
        currentPlayerLabel.setAlignment(Align.center);
        clientPlayerLabel = new Label(CLIENT_PLAYER_PREFIX + "[PLAYER]", game.getSkin());
        clientPlayerLabel.setAlignment(Align.center);
        playerHealthLabel = new Label(HEALTH_PREFIX + "0", game.getSkin());
        enemyHealthLabel = new Label(HEALTH_PREFIX + "0", game.getSkin());

        guiTable.add(enemyHealthLabel);
        guiTable.add(currentPlayerLabel).expandX().fillX();
        guiTable.row();
        guiTable.add().expandY().fillY();
        guiTable.row();
        guiTable.add(playerHealthLabel);
        guiTable.add(clientPlayerLabel).expandX().fillX();
        guiTable.row();

        Stack stack = new Stack();
        stack.setFillParent(true);
        stack.add(gameTable);
        stack.add(guiTable);

        stage.addActor(stack);
    }

    private void initCards() {
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
                if (matchState.getCurrentPlayer() != clientPlayer) {
                    return;
                }

                if (matchState.isCardInPlay(clientPlayer, cardId)) {
                    CardView cardView = (CardView) event.getListenerActor();
                    cardView.setSelected(!cardView.isSelected());
                    matchState.selectCardToPlay(cardId);
                } else if (matchState.isCardInPlay(clientPlayer.getOpposite(), cardId)) {
                    for (Actor actor : playerPlayGroup.getChildren()) {
                        ((CardView) actor).setSelected(false);
                    }
                    Array<Integer> playerCards = matchState.getSelectedCards(clientPlayer);
                    Array<Integer> enemyCards = new Array<>();
                    enemyCards.add(cardId);
                    matchConnection.sendAttackAction(playerCards, enemyCards);
                    matchState.resetSelection();
                }
            }
        }

        Player enemyPlayer = clientPlayer.getOpposite();

        for (Card card : matchState.getCardsInHand(enemyPlayer)) {
            Actor cardView = new CardView(card, game.getAssetManager());
            cardView.addListener(new CardInputListener(card.getId()));
            enemyHandGroup.addActor(cardView);
        }
        for (Card card : matchState.getCardsInPlay(enemyPlayer)) {
            Actor cardView = new CardView(card, game.getAssetManager());
            cardView.addListener(new CardInputListener(card.getId()));
            enemyPlayGroup.addActor(cardView);
        }
        for (Card card : matchState.getCardsInPlay(clientPlayer)) {
            Actor cardView = new CardView(card, game.getAssetManager());
            cardView.addListener(new CardInputListener(card.getId()));
            playerPlayGroup.addActor(cardView);
        }
        for (Card card : matchState.getCardsInHand(clientPlayer)) {
            Actor cardView = new CardView(card, game.getAssetManager());
            cardView.addListener(new CardInputListener(card.getId()));
            playerHandGroup.addActor(cardView);
        }
    }

    @Override
    protected void update(float delta) {
        super.update(delta);

        Array<Event> events = getAllIncomingEvents();
        for (Event event : events) {
            EventResponse response = handleEvent(event);
            Gdx.app.log("EventResponse", response.getClass().getName());
            if (response instanceof GameStateUpdateEventResponse) {
                clientPlayer = ((GameStateUpdateEventResponse) response).clientPlayer;
                initCards();
                currentPlayerLabel.setText(CURRENT_PLAYER_PREFIX + matchState.getCurrentPlayer());
                clientPlayerLabel.setText(CLIENT_PLAYER_PREFIX + clientPlayer.toString());
                enemyHealthLabel.setText(HEALTH_PREFIX + matchState.getPlayerHealth(clientPlayer.getOpposite()));
                playerHealthLabel.setText(HEALTH_PREFIX + matchState.getPlayerHealth(clientPlayer));
            } else if (response instanceof AttackEventResponse) {
                matchState.changePlayer();
                currentPlayerLabel.setText(CURRENT_PLAYER_PREFIX + matchState.getCurrentPlayer());
                enemyHealthLabel.setText(HEALTH_PREFIX + matchState.getPlayerHealth(clientPlayer.getOpposite()));
                playerHealthLabel.setText(HEALTH_PREFIX + matchState.getPlayerHealth(clientPlayer));
            }
        }
    }

    private EventResponse handleEvent(Event event) {
        for (EventHandler eventHandler : eventHandlers) {
            if (eventHandler.canBeHandled(matchState, event)) {
                return eventHandler.handle(matchState, event);
            }
        }
        throw new RuntimeException("Event was not handled");
    }
}
