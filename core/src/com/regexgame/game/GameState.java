package com.regexgame.game;

import com.badlogic.gdx.utils.Array;

public class GameState {
    private Player currentPlayer;

    private Cards firstPlayerCardsInHand;
    private Cards firstPlayerCardsInPlay;

    private Cards secondPlayerCardsInHand;
    private Cards secondPlayerCardsInPlay;

    /**
     * Create empty GameState which should be updated from server
     */
    public GameState() {
        this.currentPlayer = Player.First;

        this.firstPlayerCardsInHand = new Cards();
        this.firstPlayerCardsInPlay = new Cards();

        this.secondPlayerCardsInHand = new Cards();
        this.secondPlayerCardsInPlay = new Cards();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Cards getCardsInHand(Player player) {
        if (player == Player.First) {
            return firstPlayerCardsInHand;
        } else {
            return secondPlayerCardsInHand;
        }
    }

    public Cards getCardsInPlay(Player player) {
        if (player == Player.First) {
            return firstPlayerCardsInPlay;
        } else {
            return secondPlayerCardsInPlay;
        }
    }

    public Card getCardInHand(Player player, int id) {
        Cards cardsInHand = getCardsInHand(player);
        for (Card card : cardsInHand) {
            if (card.getId() == id) {
                return card;
            }
        }
        throw new RuntimeException("There is no card with id = " + id + " in hand of " + player + " player");
    }

    public Card getCardInPlay(Player player, int id) {
        Cards cardsInPlay = getCardsInPlay(player);
        for (Card card : cardsInPlay) {
            if (card.getId() == id) {
                return card;
            }
        }
        throw new RuntimeException("There is no card with id = " + id + " in play of " + player + " player");
    }

    public Player getOppositePlayer(Player player) {
        if (player == Player.First) {
            return Player.Second;
        } else {
            return Player.First;
        }
    }
}
