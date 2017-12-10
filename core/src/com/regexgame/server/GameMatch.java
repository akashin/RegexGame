package com.regexgame.server;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.LongMap;
import com.regexgame.AttackCard;
import com.regexgame.CardAttacked;
import com.regexgame.GameEvent;
import com.regexgame.game.Player;
import io.grpc.stub.StreamObserver;

// Represents a single game between players.
public class GameMatch {

    enum MatchState {
        WaitingForPlayers,
        Started
    }

    private MatchState state;
    private Player currentPlayer;
    private LongMap<Player> players;
    private Array<StreamObserver<GameEvent>> observers;

    public GameMatch() {
        state = MatchState.WaitingForPlayers;
        players = new LongMap<>();
        observers = new Array<>();
        currentPlayer = Player.First;
    }

    public MatchState getState() {
        return state;
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
                                .setAttackerId(player.index)
                                .setDamage(1)
                                .addAllAttackerCards(action.getAttackerCardsList())
                                .setAttackedCard(action.getAttackedCard())
                ).build());
    }

    // Broadcasts event to all observers.
    private void broadcastEvent(GameEvent event) {
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

    public Player addPlayer(long session_token) {
        Player player;
        if (players.size == 0) {
            player = Player.First;
        } else {
            player = Player.Second;
        }
        players.put(session_token, player);
        if (players.size == 2) {
            state = MatchState.Started;
        }
        return player;
    }

    public void subscribeForEvents(long session_token, StreamObserver<GameEvent> observer) {
        observers.add(observer);
    }
}
