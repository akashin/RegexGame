package com.regexgame.server;

import com.regexgame.AttackCard;
import com.regexgame.CardAttacked;
import com.regexgame.GameEvent;
import com.regexgame.NumberChanged;
import com.regexgame.game.Player;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.HashMap;

// Represents a single game between players.
public class GameMatch {
    private int current_value;
    private Player current_player;
    private HashMap<Long, Player> players;
    private ArrayList<StreamObserver<GameEvent>> observers;

    public GameMatch() {
        players = new HashMap<>();
        observers = new ArrayList<StreamObserver<GameEvent>>();
        current_player = Player.First;
    }

    public void attackCard(long session_token, AttackCard action) throws Exception {
        Player player = players.get(session_token);
        if (player != current_player) {
            throw new Exception("Unexpected player move.");
        }

        // TODO(akashin): Implement logic.

        broadcastEvent(
                GameEvent.newBuilder().setCardAttacked(
                        CardAttacked.newBuilder()
                                .setPlayerId(player.index)
                                .setDamage(1)
                                .addAllAttackerCards(action.getAttackerCardsList())
                                .setAttackedCard(action.getAttackedCard())
                ).build());
    }

    public void increaseValue() {
        setValue(current_value + 1);
    }

    public void decreaseValue() {
        setValue(current_value - 1);
    }

    // Broadcasts event to all observers.
    private void broadcastEvent(GameEvent event) {
        for (StreamObserver<GameEvent> observer : observers) {
            observer.onNext(event);
        }
    }

    private void setValue(int new_value) {
        current_value = new_value;
        broadcastEvent(GameEvent.newBuilder().setNumberChanged(NumberChanged.newBuilder().setValue(new_value)).build());
    }

    // Called when match is finished.
    public void finish() {
        for (StreamObserver<GameEvent> observer : observers) {
            observer.onCompleted();
        }
    }

    public void addPlayer(long session_token, Player player) {
        players.put(session_token, player);
    }

    public void subscribeForEvents(long session_token, StreamObserver<GameEvent> observer) {
        observers.add(observer);
    }
}
