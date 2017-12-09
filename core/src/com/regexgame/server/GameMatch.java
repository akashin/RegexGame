package com.regexgame.server;

import com.regexgame.*;
import com.regexgame.AttackCard;
import com.regexgame.CardAttacked;
import com.regexgame.CardAttackedOrBuilder;
import com.regexgame.GameEvent;
import com.regexgame.NumberChanged;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

// Represents a single game between players.
public class GameMatch {
    private int current_value;
    private int current_player_id;
    private ArrayList<StreamObserver<GameEvent>> observers;

    public GameMatch() {
        observers = new ArrayList<StreamObserver<GameEvent>>();
        // TODO(akashin): Make this an enum.
        current_player_id = 1;
    }

    public void attackCard(int player_id, AttackCard action) throws Exception {
        if (player_id != current_player_id) {
            throw new Exception("Unexpected player move.");
        }

        // TODO(akashin): Implement logic.

        broadcastEvent(
                GameEvent.newBuilder().setCardAttacked(
                        CardAttacked.newBuilder()
                                .setPlayerId(player_id)
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


    public void subscribeForEvents(int player_id, StreamObserver<GameEvent> observer) {
        observers.add(observer);
    }
}
