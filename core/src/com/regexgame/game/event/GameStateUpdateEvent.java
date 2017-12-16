package com.regexgame.game.event;

import com.regexgame.game.Cards;
import com.regexgame.game.Player;

public class GameStateUpdateEvent extends Event {
    private Player currentPlayer;

    private Cards firstPlayerCardsInHand;

    private Cards firstPlayerCardsInPlay;

    private Cards secondPlayerCardsInHand;

    private Cards secondPlayerCardsInPlay;

    public GameStateUpdateEvent(
            Player owner,
            Player currentPlayer,
            Cards firstPlayerCardsInHand,
            Cards firstPlayerCardsInPlay,
            Cards secondPlayerCardsInHand,
            Cards secondPlayerCardsInPlay
    ) {
        super(owner);
        this.currentPlayer = currentPlayer;
        this.firstPlayerCardsInHand = firstPlayerCardsInHand;
        this.firstPlayerCardsInPlay = firstPlayerCardsInPlay;
        this.secondPlayerCardsInHand = secondPlayerCardsInHand;
        this.secondPlayerCardsInPlay = secondPlayerCardsInPlay;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
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
}
