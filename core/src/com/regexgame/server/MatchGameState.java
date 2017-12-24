package com.regexgame.server;

import com.badlogic.gdx.utils.ObjectMap;
import com.regexgame.AttackCard;
import com.regexgame.common.Utils;
import com.regexgame.game.*;
import com.regexgame.game.event.AttackEvent;
import com.regexgame.game.event.Event;
import com.regexgame.game.event.GameStateUpdateEvent;
import com.regexgame.game.event.MatchFinishedEvent;

import java.util.Iterator;
import java.util.Random;

public class MatchGameState {
    private static final int kStartingHealth = 10;
    private static final int kCardsInDeck = 20;
    private Player currentPlayer;

    private ObjectMap<Player, PlayerAttributes> playerAttributes;
    private ObjectMap<Player, Deck> playerDecks;
    private ObjectMap<Player, Cards> cardsInHand;
    private ObjectMap<Player, Cards> cardsInPlay;

    MatchGameState() {
        currentPlayer = Player.First;

        playerAttributes = new ObjectMap<>();
        playerDecks = new ObjectMap<>();
        cardsInHand = new ObjectMap<>();
        cardsInPlay = new ObjectMap<>();

        int cardStartId = 0;
        for (Player player : Player.values()) {
            playerAttributes.put(player, new PlayerAttributes(kStartingHealth));
            playerDecks.put(player, new Deck(Deck.generateRandomCards(kCardsInDeck, cardStartId)));
            cardStartId += kCardsInDeck;

            cardsInHand.put(player, new Cards());
            for (int i = 0; i < 4; ++i) {
                cardsInHand.get(player).add(playerDecks.get(player).dealCard());
            }

            cardsInPlay.put(player, new Cards());
            for (int i = 0; i < 3; ++i) {
                cardsInPlay.get(player).add(playerDecks.get(player).dealCard());
            }
        }
    }

    public void attackCard(Player player, AttackCard action, GameMatch.EventObserver observer) throws Exception {
        if (player != currentPlayer) {
            throw new Exception("Unexpected player move.");
        }

        Card attackedCard = getCardWithId(cardsInPlay.get(player.getOpposite()), action.getAttackedCard());
        if (attackedCard == null) {
            throw new Exception("Attacked card with id " + action.getAttackedCard() + " not found.");
        }

        StringBuilder attackBuilder = new StringBuilder();
        for (int id : action.getAttackerCardsList()) {
            Card attackerCard = getCardWithId(cardsInPlay.get(player), id);
            if (attackerCard == null) {
                throw new Exception("Attacker card with id " + id + " not found.");
            }
            attackBuilder.append(attackerCard.getAttack());
        }
        String attackString = attackBuilder.toString();
        int damage = attackString.length();

        // Apply effects of the action.
        PlayerAttributes attributes = playerAttributes.get(player.getOpposite());
        attributes.setHealth(attributes.getHealth() - damage);
        currentPlayer = currentPlayer.getOpposite();

        {
            Event event = new AttackEvent(
                    player,
                    Utils.toArray(action.getAttackerCardsList()),
                    action.getAttackedCard(),
                    damage
            );

            observer.onNext(Player.First, event);
            observer.onNext(Player.Second, event);
        }

        if (attributes.getHealth() <= 0) {
            Event event = new MatchFinishedEvent(player);
            observer.onNext(Player.First, event);
            observer.onNext(Player.Second, event);
        }
    }

    static Card getCardWithId(Cards cards, int id) {
        Iterator<Card> it = cards.select(card -> card.getId() == id).iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    // TODO(akashin): Maybe replace this with joinGame action.
    public void getGameStateUpdate(Player player, GameMatch.EventObserver observer) {
        Event event = new GameStateUpdateEvent(
                player, currentPlayer,
                playerAttributes.get(Player.First),
                cardsInHand.get(Player.First),
                cardsInPlay.get(Player.First),
                playerAttributes.get(Player.Second),
                cardsInHand.get(Player.Second),
                cardsInPlay.get(Player.Second));

        observer.onNext(player, event);
    }
}
