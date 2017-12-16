package com.regexgame.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.regexgame.*;
import com.regexgame.AttackCard;
import com.regexgame.GameAction;
import com.regexgame.GetEventsRequest;
import com.regexgame.MakeActionRequest;
import com.regexgame.game.Player;
import io.grpc.stub.StreamObserver;

public class MatchConnection {
    private NetworkSession networkSession;
    private long matchId;
    private Player player;

    public MatchConnection(NetworkSession networkSession, long matchId, Player player) {
        this.networkSession = networkSession;
        this.matchId = matchId;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void getEvents(StreamObserver<com.regexgame.GameEvent> observer) {
        networkSession.getStub().getEvents(GetEventsRequest.newBuilder()
                .setSessionToken(networkSession.getSessionToken())
                .setMatchId(matchId).build(), observer);
    }

    public void sendAttackAction(Array<Integer> playerCards, Array<Integer> enemyCards) {
        Gdx.app.log("DEBUG", "Attack: " + playerCards + " -> " + enemyCards);
        GameAction action = GameAction.newBuilder()
                .setAttackCard(
                        AttackCard.newBuilder()
                                .addAllAttackerCards(playerCards)
                                .setAttackedCard(enemyCards.get(0)))
                .build();

        networkSession.getBlockingStub().makeAction(MakeActionRequest.newBuilder()
                .setSessionToken(networkSession.getSessionToken())
                .setMatchId(matchId)
                .setAction(action).build());
    }
}
