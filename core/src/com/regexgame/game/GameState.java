package com.regexgame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.regexgame.game.event.Event;
import com.regexgame.game.event.EventHandler;
import com.regexgame.game.event.EventResponse;

public class GameState {
    private Player currentPlayer;

    private Cards firstPlayerCardsInHand;
    private Cards firstPlayerCardsInPlay;
    private Array<Integer> firstPlayerSelectedCards;

    private Cards secondPlayerCardsInHand;
    private Cards secondPlayerCardsInPlay;
    private Array<Integer> secondPlayerSelectedCards;

    private Array<EventHandler> eventHandlers;

    /**
     * Create empty GameState which should be updated from server
     */
    public GameState() {
        currentPlayer = Player.First;

        firstPlayerCardsInHand = new Cards();
        firstPlayerCardsInPlay = new Cards();
        firstPlayerSelectedCards = new Array<>();

        secondPlayerCardsInHand = new Cards();
        secondPlayerCardsInPlay = new Cards();
        secondPlayerSelectedCards = new Array<>();

        eventHandlers = new Array<>();
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

    public void setCardsInHand(Player player, Cards cards) {
        if (player == Player.First) {
            firstPlayerCardsInHand = cards;
        } else {
            secondPlayerCardsInHand = cards;
        }
    }

    public Cards getCardsInPlay(Player player) {
        if (player == Player.First) {
            return firstPlayerCardsInPlay;
        } else {
            return secondPlayerCardsInPlay;
        }
    }

    public void setCardsInPlay(Player player, Cards cards) {
        if (player == Player.First) {
            firstPlayerCardsInPlay = cards;
        } else {
            secondPlayerCardsInPlay = cards;
        }
    }

    public int getCardInPlayIndex(Player player, int id) {
        Cards cardsInPlay = getCardsInPlay(player);
        for (int i = 0; i < cardsInPlay.size; ++i) {
            if (cardsInPlay.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean isCardInPlay(Player player, int id) {
        return getCardInPlayIndex(player, id) != -1;
    }

    public int getCardInHandIndex(Player player, int id) {
        Cards cardsInHand = getCardsInHand(player);
        for (int i = 0; i < cardsInHand.size; ++i) {
            if (cardsInHand.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean isCardInHand(Player player, int id) {
        return getCardInHandIndex(player, id) != -1;
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

    public Array<Integer> getSelectedCards(Player player) {
        if (player == Player.First) {
            return firstPlayerSelectedCards;
        } else {
            return secondPlayerSelectedCards;
        }
    }

    public void selectCardToPlay(int id) {
        Array<Integer> selectedCards = getSelectedCards(currentPlayer);
        int index = selectedCards.indexOf(id, true);
        if (index == -1) {
            selectedCards.add(id);
        } else {
            selectedCards.removeIndex(index);
        }
        Gdx.app.log("GameState", "Selected cards of " + currentPlayer + " player: " + selectedCards);
    }

    public void resetSelection() {
        getSelectedCards(currentPlayer).clear();
    }

    public void addEventHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }

    public EventResponse processEvent(Event event) {
        for (EventHandler eventHandler : eventHandlers) {
            if (eventHandler.canBeHandled(this, event)) {
                return eventHandler.handle(this, event);
            }
        }
        throw new RuntimeException("Event was not handled");
    }
}
