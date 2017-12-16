package com.regexgame.game.event;

import com.regexgame.game.Card;
import com.regexgame.game.GameState;
import com.regexgame.game.Player;

public class AttackEventHandler extends EventHandler {
    @Override
    public boolean canBeHandled(GameState gameState, Event event) {
        return event instanceof AttackEvent;
    }

    @Override
    public EventResponse handle(GameState gameState, Event event) {
        AttackEvent attackEvent = (AttackEvent) event;

        Player targetPlayer = attackEvent.getAttacker().getOpposite();
        Card attackedCard = gameState.getCardInPlay(targetPlayer, attackEvent.getTargetCard());

        int damageDealt = 0;
        for (int id : attackEvent.getChosenCards()) {
            Card card = gameState.getCardInPlay(attackEvent.getAttacker(), id);
            damageDealt += attackedCard.damage(card.getAttack());
        }

        return new AttackEventResponse(
                attackEvent.getAttacker(),
                attackEvent.getChosenCards(),
                attackEvent.getTargetCard(),
                damageDealt
        );
    }
}
