package com.regexgame.game.event;

import com.regexgame.game.Card;
import com.regexgame.game.MatchState;
import com.regexgame.game.Player;

public class AttackEventHandler extends EventHandler {
    @Override
    public boolean canBeHandled(MatchState matchState, Event event) {
        return event instanceof AttackEvent;
    }

    @Override
    public EventResponse handle(MatchState matchState, Event event) {
        AttackEvent attackEvent = (AttackEvent) event;

        Player targetPlayer = attackEvent.getAttacker().getOpposite();
        Card attackedCard = matchState.getCardInPlay(targetPlayer, attackEvent.getTargetCard());

        int damageDealt = 0;
        for (int id : attackEvent.getChosenCards()) {
            Card card = matchState.getCardInPlay(attackEvent.getAttacker(), id);
            damageDealt += attackedCard.damage(card.getAttack());
        }
        matchState.damagePlayer(targetPlayer, damageDealt);

        return new AttackEventResponse(
                attackEvent.getAttacker(),
                attackEvent.getChosenCards(),
                attackEvent.getTargetCard(),
                damageDealt
        );
    }
}
