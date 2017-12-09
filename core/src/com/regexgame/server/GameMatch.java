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

    enum MatchState {
        WaitingForPlayers,
        Started
    }

    private MatchState matchState;
    private int currentValue;
    private Player currentPlayer;
    private HashMap<Long, Player> players;
    private ArrayList<StreamObserver<GameEvent>> observers;

    public GameMatch() {
        matchState = MatchState.WaitingForPlayers;
        players = new HashMap<>();
        observers = new ArrayList<StreamObserver<GameEvent>>();
        currentPlayer = Player.First;
    }

    public MatchState getMatchState() {
        return matchState;
    }

    public void attackCard(long session_token, AttackCard action) throws Exception {
        Player player = players.get(session_token);
        if (player != currentPlayer) {
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
        setValue(currentValue + 1);
    }

    public void decreaseValue() {
        setValue(currentValue - 1);
    }

    // Broadcasts event to all observers.
    private void broadcastEvent(GameEvent event) {
        for (StreamObserver<GameEvent> observer : observers) {
            observer.onNext(event);
        }
    }

    private void setValue(int new_value) {
        currentValue = new_value;
        broadcastEvent(GameEvent.newBuilder().setNumberChanged(NumberChanged.newBuilder().setValue(new_value)).build());
    }

    // Called when match is finished.
    public void finish() {
        for (StreamObserver<GameEvent> observer : observers) {
            observer.onCompleted();
        }
    }

    public void addPlayer(long session_token) {
        Player player;
        if (players.size() == 0) {
            player = Player.First;
        } else {
            player = Player.Second;
        }
        players.put(session_token, player);
        if (players.size() == 2) {
            matchState = MatchState.Started;
        }
    }

    public void subscribeForEvents(long session_token, StreamObserver<GameEvent> observer) {
        observers.add(observer);
    }
}
