package com.regexgame.game;

import com.badlogic.gdx.utils.Array;

public class GameState {
    public enum Player {
        First,
        Second,
    }
    private Player currentPlayer;

    private Array<Card> firstPlayerHand;
    private Array<Card> firstPlayerInPlay;

    private Array<Card> secondPlayerHand;
    private Array<Card> secondPlayerInPlay;

    /**
     * Create empty GameState which should be updated from server
     */
    public GameState() {
        this.currentPlayer = Player.First;

        this.firstPlayerHand = new Array<>();
        this.firstPlayerInPlay = new Array<>();

        this.secondPlayerHand = new Array<>();
        this.secondPlayerInPlay = new Array<>();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Array<Card> getHand(Player player) {
        if (player == Player.First) {
            return firstPlayerHand;
        } else {
            return secondPlayerHand;
        }
    }

    public Array<Card> getInPlay(Player player) {
        if (player == Player.First) {
            return firstPlayerInPlay;
        } else {
            return secondPlayerInPlay;
        }
    }

    public Player getOppositePlayer(Player player) {
        if (player == Player.First) {
            return Player.Second;
        } else {
            return Player.First;
        }
    }

    public void selectCardInPlay(int index) {
        Array<Card> inPlay = getInPlay(currentPlayer);
        inPlay.get(index).select();
    }

    public void selectCardToAttack(int index) {
        for (Card card : getInPlay(currentPlayer)) {
            card.resetSelection();
        }
        Array<Card> inPlay = getInPlay(getOppositePlayer(currentPlayer));
        Card cardToAttack = inPlay.get(index);
    }
}
