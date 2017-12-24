package com.regexgame.game.event;

import com.regexgame.game.MatchState;
import com.regexgame.game.Player;

public class GameStateUpdateEventHandler extends EventHandler {
    @Override
    public boolean canBeHandled(MatchState matchState, Event event) {
        return event instanceof GameStateUpdateEvent;
    }

    @Override
    public EventResponse handle(MatchState matchState, Event event) {
        GameStateUpdateEvent gameStateUpdateEvent = (GameStateUpdateEvent) event;

        matchState.setCardsInHand(Player.First, gameStateUpdateEvent.getFirstPlayerCardsInHand());
        matchState.setCardsInHand(Player.Second, gameStateUpdateEvent.getSecondPlayerCardsInHand());

        matchState.setCardsInPlay(Player.First, gameStateUpdateEvent.getFirstPlayerCardsInPlay());
        matchState.setCardsInPlay(Player.Second, gameStateUpdateEvent.getSecondPlayerCardsInPlay());

        matchState.setPlayerAttributes(Player.First, gameStateUpdateEvent.getFirstPlayerAttributes());
        matchState.setPlayerAttributes(Player.Second, gameStateUpdateEvent.getSecondPlayerAttributes());

        return new GameStateUpdateEventResponse(gameStateUpdateEvent.getClientPlayer());
    }
}
