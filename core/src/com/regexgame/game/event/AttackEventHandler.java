package com.regexgame.game.event;

import com.regexgame.game.Card;
import com.regexgame.game.GameState;
import com.regexgame.game.Player;

public class AttackEventHandler extends EventHandler<AttackEvent> {
    @Override
    public EventResponse handle(GameState gameState, AttackEvent event) {
        Player targetPlayer = gameState.getOppositePlayer(event.getAttacker());
        Card attackedCard = gameState.getCardInPlay(targetPlayer, event.getTargetCard());

        for (int id : event.getChosenCards()) {
            Card card = gameState.getCardInPlay(event.getAttacker(), id);
            attackedCard.damage(card.getAttack());
        }

        return new AttackEventResponse(event.getAttacker(), event.getChosenCards(), event.getTargetCard());
    }
}
