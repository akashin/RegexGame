package com.regexgame.game.event;

import com.badlogic.gdx.utils.Array;
import com.regexgame.game.Player;

public class AttackEventResponse extends EventResponse {
    public final Player attacker;

    public final Array<Integer> chosenCards;

    public final int targetCard;

    public final int damageDealt;

    public AttackEventResponse(
            Player attacker,
            Array<Integer> chosenCards,
            int targetCard,
            int damageDealt
    ) {
        this.attacker = attacker;
        this.chosenCards = chosenCards;
        this.targetCard = targetCard;
        this.damageDealt = damageDealt;
    }
}
