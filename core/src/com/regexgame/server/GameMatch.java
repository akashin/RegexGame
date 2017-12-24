package com.regexgame.server;

import com.badlogic.gdx.utils.LongMap;
import com.badlogic.gdx.utils.ObjectMap;
import com.regexgame.AttackCard;
import com.regexgame.CardAttacked;
import com.regexgame.GameEvent;
import com.regexgame.GameStateUpdated;
import com.regexgame.game.Player;
import com.regexgame.game.event.Event;
import io.grpc.stub.StreamObserver;

import java.util.function.Consumer;

// Represents a single game between players.
public class GameMatch {

    enum MatchState {
        WaitingForPlayers,
        Started
    }

    private MatchState state;

    private MatchGameState matchGameState;

    private LongMap<Player> players;
    private ObjectMap<Player, StreamObserver<GameEvent>> observers;

    public GameMatch() {
        state = MatchState.WaitingForPlayers;
        players = new LongMap<>();
        observers = new ObjectMap<>();
    }

    public MatchState getState() {
        return state;
    }

    public void attackCard(long session_token, AttackCard action) throws Exception {
        if (state != MatchState.Started) {
            throw new Exception("Game has not started yet.");
        }
        Player player = players.get(session_token);

        EventObserver eventObserver = new EventObserver();
        matchGameState.attackCard(player, action, eventObserver);
        eventObserver.dumpEvents();
    }

    // Broadcasts event to all observers.
    private void broadcastEvent(GameEvent event) {
        for (StreamObserver<GameEvent> observer : observers.values()) {
            observer.onNext(event);
        }
    }

    private void sendEvent(Player player, GameEvent event) {
        if (observers.containsKey(player)) {
            observers.get(player).onNext(event);
        }
    }

    // Called when match is finished.
    public void finish() {
        for (StreamObserver<GameEvent> observer : observers.values()) {
            observer.onCompleted();
        }
    }

    public Player addPlayer(long session_token) {
        Player player;
        if (players.size == 0) {
            player = Player.First;
        } else {
            player = Player.Second;
        }
        players.put(session_token, player);
        if (players.size == 2) {
            startGame();
        }
        return player;
    }

    class EventObserver {
        public void onNext(Player player, Event event) {
            sendEvent(player, event.toProto());
        }

        protected void dumpEvents() {
        }
    };

    private void startGame() {
        state = MatchState.Started;
        matchGameState = new MatchGameState();

        EventObserver eventObserver = new EventObserver();
        matchGameState.getGameStateUpdate(Player.First, eventObserver);
        matchGameState.getGameStateUpdate(Player.Second, eventObserver);
        eventObserver.dumpEvents();
    }

    public void subscribeForEvents(long session_token, StreamObserver<GameEvent> observer) {
        Player player = players.get(session_token);
        observers.put(player, observer);

        if (state != MatchState.WaitingForPlayers) {
            EventObserver eventObserver = new EventObserver();
            matchGameState.getGameStateUpdate(player, eventObserver);
            eventObserver.dumpEvents();
        }
    }
}
