package com.regexgame.game.event;

import com.badlogic.gdx.utils.Json;
import com.regexgame.GameEvent;
import com.regexgame.GameStateUpdated;
import com.regexgame.game.Cards;
import com.regexgame.game.Player;
import com.regexgame.game.PlayerAttributes;

public class GameStateUpdateEvent extends Event {
    private Player clientPlayer;

    private Player currentPlayer;

    private PlayerAttributes firstPlayerAttributes;

    private Cards firstPlayerCardsInHand;

    private Cards firstPlayerCardsInPlay;

    private PlayerAttributes secondPlayerAttributes;

    private Cards secondPlayerCardsInHand;

    private Cards secondPlayerCardsInPlay;

    public GameStateUpdateEvent(
            Player clientPlayer,
            Player currentPlayer,
            PlayerAttributes firstPlayerAttributes,
            Cards firstPlayerCardsInHand,
            Cards firstPlayerCardsInPlay,
            PlayerAttributes secondPlayerAttributes,
            Cards secondPlayerCardsInHand,
            Cards secondPlayerCardsInPlay
    ) {
        this.clientPlayer = clientPlayer;
        this.currentPlayer = currentPlayer;
        this.firstPlayerAttributes = firstPlayerAttributes;
        this.firstPlayerCardsInHand = firstPlayerCardsInHand;
        this.firstPlayerCardsInPlay = firstPlayerCardsInPlay;
        this.secondPlayerAttributes = secondPlayerAttributes;
        this.secondPlayerCardsInHand = secondPlayerCardsInHand;
        this.secondPlayerCardsInPlay = secondPlayerCardsInPlay;
    }

    public Player getClientPlayer() {
        return clientPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public PlayerAttributes getFirstPlayerAttributes() {
        return firstPlayerAttributes;
    }

    public PlayerAttributes getSecondPlayerAttributes() {
        return secondPlayerAttributes;
    }

    public Cards getFirstPlayerCardsInHand() {
        return firstPlayerCardsInHand;
    }

    public Cards getFirstPlayerCardsInPlay() {
        return firstPlayerCardsInPlay;
    }

    public Cards getSecondPlayerCardsInHand() {
        return secondPlayerCardsInHand;
    }

    public Cards getSecondPlayerCardsInPlay() {
        return secondPlayerCardsInPlay;
    }

    public GameEvent toProto() {
        Json json = new Json();
        return GameEvent.newBuilder()
                .setGameStateUpdated(GameStateUpdated.newBuilder()
                        .setJsonEncoded(json.toJson(this)))
                .build();
    }

    private GameStateUpdateEvent() {}
}
