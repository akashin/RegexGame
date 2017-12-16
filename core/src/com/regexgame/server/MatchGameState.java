package com.regexgame.server;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.regexgame.AttackCard;
import com.regexgame.game.Cards;
import com.regexgame.game.Player;
import com.regexgame.game.event.AttackEvent;
import com.regexgame.game.event.Event;

import java.util.function.Consumer;

public class MatchGameState {
    private Player currentPlayer;

    private Cards firstPlayerCardsInHand;
    private Cards firstPlayerCardsInPlay;
    private Array<Integer> firstPlayerSelectedCards;

    private Cards secondPlayerCardsInHand;
    private Cards secondPlayerCardsInPlay;
    private Array<Integer> secondPlayerSelectedCards;

    public <T> Array<T> toArray(Iterable<T> list) {
        Array<T> result = new Array<>();
        list.forEach(new Consumer<T>() {
            @Override
            public void accept(T t) {
                result.add(t);
            }
        });
        return result;
    }

    public ObjectMap<Player, Event> attackCard(Player player, AttackCard action) throws Exception {
        if (player != currentPlayer) {
            throw new Exception("Unexpected player move.");
        }

        ObjectMap<Player, Event> events = new ObjectMap<>();

        Event event = new AttackEvent(player.getOpposite(), player, toArray(action.getAttackerCardsList()),
                action.getAttackedCard());

        events.put(Player.First, event);
        events.put(Player.Second, event);

        return events;
    }
}
