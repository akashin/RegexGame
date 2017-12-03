package com.regexgame.server;

import com.regexgame.GameEvent;
import com.regexgame.NumberChanged;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

// Represents a single game between players.
public class GameMatch {
    private int current_value;
    private ArrayList<StreamObserver<GameEvent>> observers;

    public GameMatch() {
        observers = new ArrayList<StreamObserver<GameEvent>>();
    }

    public void increaseValue() {
        setValue(current_value + 1);
    }

    public void decreaseValue() {
        setValue(current_value - 1);
    }

    private void setValue(int new_value) {
        current_value = new_value;
        GameEvent event = GameEvent.newBuilder().setNumberChanged(NumberChanged.newBuilder().setValue(new_value)).build();
        for (StreamObserver<GameEvent> observer : observers) {
            observer.onNext(event);
        }
    }

    // Called when match is finished.
    public void finish() {
        for (StreamObserver<GameEvent> observer : observers) {
            observer.onCompleted();
        }
    }


    public void subscribeForEvents(StreamObserver<GameEvent> observer) {
        observers.add(observer);
    }
}
