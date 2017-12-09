package com.regexgame.game.event;

import com.badlogic.gdx.utils.Array;
import com.regexgame.game.Player;

public class AttackEventResponse extends EventResponse {
    public final Player attacker;

    public final Array<Integer> chosenCards;

    public final int targetCard;

    public AttackEventResponse(Player attacker, Array<Integer> chosenCards, int targetCard) {
        this.attacker = attacker;
        this.chosenCards = chosenCards;
        this.targetCard = targetCard;
    }
}
