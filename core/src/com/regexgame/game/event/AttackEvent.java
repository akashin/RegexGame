package com.regexgame.game.event;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.regexgame.CardAttacked;
import com.regexgame.GameEvent;
import com.regexgame.game.Player;

public class AttackEvent extends Event {
    private Player attacker;

    private Array<Integer> chosenCards;

    private int targetCard;

    public AttackEvent(Player owner, Player attacker, Array<Integer> chosenCards, int targetCard) {
        super(owner);
        this.attacker = attacker;
        this.chosenCards = chosenCards;
        this.targetCard = targetCard;
    }

    public Player getAttacker() {
        return attacker;
    }

    public Array<Integer> getChosenCards() {
        return chosenCards;
    }

    public int getTargetCard() {
        return targetCard;
    }

    public GameEvent toProto() {
        Json json = new Json();
        return GameEvent.newBuilder()
                .setCardAttacked(CardAttacked.newBuilder()
                        .setJsonEncoded(json.toJson(this)))
                .build();
    }
}
