package com.regexgame.server;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.google.common.collect.Iterables;
import com.regexgame.AttackCard;
import com.regexgame.common.Utils;
import com.regexgame.game.Card;
import com.regexgame.game.Cards;
import com.regexgame.game.Player;
import com.regexgame.game.event.AttackEvent;
import com.regexgame.game.event.Event;
import com.regexgame.game.event.GameStateUpdateEvent;

import java.util.Random;
import java.util.function.Consumer;

public class MatchGameState {
    private Player currentPlayer;

    private ObjectMap<Player, Cards> cardsInHand;
    private ObjectMap<Player, Cards> cardsInPlay;

    MatchGameState() {
        currentPlayer = Player.First;

        cardsInHand = new ObjectMap<>();
        cardsInPlay = new ObjectMap<>();

        for (Player player : Player.values()) {
            cardsInHand.put(player, new Cards());
            cardsInPlay.put(player, new Cards());
        }
        generateRandomCards();
    }

    public ObjectMap<Player, Event> attackCard(Player player, AttackCard action) throws Exception {
        if (player != currentPlayer) {
            throw new Exception("Unexpected player move.");
        }

        ObjectMap<Player, Event> events = new ObjectMap<>();


        Event event = new AttackEvent(player.getOpposite(), player, Utils.toArray(action.getAttackerCardsList()),
                action.getAttackedCard(), 1);

        events.put(Player.First, event);
        events.put(Player.Second, event);
        return events;
    }

    // TODO(akashin): Maybe replace this with joinGame action.
    public ObjectMap<Player, Event> getGameStateUpdate(Player player) {
        ObjectMap<Player, Event> events = new ObjectMap<>();

        Event event = new GameStateUpdateEvent(
                player, currentPlayer,
                cardsInHand.get(Player.First),
                cardsInPlay.get(Player.First),
                cardsInHand.get(Player.Second),
                cardsInPlay.get(Player.Second));

        events.put(player, event);
        return events;
    }

    // TODO: remove this
    private void generateRandomCards() {
        Random random = new Random();

        int lastId = 0;
        for (Player player : Player.values()) {
            for (int i = 0; i < 4; ++i) {
                Card card = generateRandomCard(random, lastId++);
                cardsInHand.get(player).add(card);
            }
            for (int i = 0; i < 3; ++i) {
                Card card = generateRandomCard(random, lastId++);
                cardsInPlay.get(player).add(card);
            }
        }
    }

    // TODO: remove this
    private static Card generateRandomCard(Random random, int id) {
        String attack = Integer.toString(random.nextInt(10) + 1);
        String defence = Integer.toString(random.nextInt(20) + 1);
        return new Card(id, attack, defence);
    }
}
