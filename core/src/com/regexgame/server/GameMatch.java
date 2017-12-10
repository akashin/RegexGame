package com.regexgame.server;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.LongMap;
import com.badlogic.gdx.utils.ObjectMap;
import com.regexgame.AttackCard;
import com.regexgame.CardAttacked;
import com.regexgame.GameEvent;
import com.regexgame.GameStateUpdated;
import com.regexgame.game.GameState;
import com.regexgame.game.Player;
import com.regexgame.game.event.AttackEvent;
import com.regexgame.game.event.AttackEventHandler;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

// Represents a single game between players.
public class GameMatch {

    enum MatchState {
        WaitingForPlayers,
        Started
    }

    private GameState gameState;
    private MatchState state;
    private Player currentPlayer;
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

    public static Array<Integer> FromList(List<Integer> array) {
        Array<Integer> result = new Array<>();
        for (int x : array) {
            result.add(x);
        }
        return result;
    }

    public void attackCard(long session_token, AttackCard action) throws Exception {
        Player player = players.get(session_token);
        if (player != currentPlayer) {
            throw new Exception("Unexpected player move.");
        }

        new AttackEventHandler().handle(gameState, new AttackEvent(
                player.getOpposite(), player, FromList(action.getAttackerCardsList()), action.getAttackedCard()
        ));

        broadcastEvent(
                GameEvent.newBuilder().setCardAttacked(
                        CardAttacked.newBuilder()
                                .setAttackerId(player.index)
                                .setDamage(1)
                                .addAllAttackerCards(action.getAttackerCardsList())
                                .setAttackedCard(action.getAttackedCard())
                ).build());
    }

    // Broadcasts event to all observers.
    private void broadcastEvent(GameEvent event) {
        for (StreamObserver<GameEvent> observer : observers.values()) {
            observer.onNext(event);
        }
    }

    private void sendEvent(Player player, GameEvent event) {
        observers.get(player).onNext(event);
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

    private void startGame() {
        state = MatchState.Started;
        gameState = new GameState();
        currentPlayer = Player.First;
    }

    public void subscribeForEvents(long session_token, StreamObserver<GameEvent> observer) {
        Player player = players.get(session_token);
        observers.put(player, observer);
        sendEvent(player, GameEvent.newBuilder().setGameStateUpdated(GameStateUpdated.getDefaultInstance()).build());
    }
}
