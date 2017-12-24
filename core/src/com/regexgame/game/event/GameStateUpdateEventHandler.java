package com.regexgame.game.event;

import com.regexgame.game.GameState;
import com.regexgame.game.Player;

public class GameStateUpdateEventHandler extends EventHandler {
    @Override
    public boolean canBeHandled(GameState gameState, Event event) {
        return event instanceof GameStateUpdateEvent;
    }

    @Override
    public EventResponse handle(GameState gameState, Event event) {
        GameStateUpdateEvent gameStateUpdateEvent = (GameStateUpdateEvent) event;

        gameState.setCardsInHand(Player.First, gameStateUpdateEvent.getFirstPlayerCardsInHand());
        gameState.setCardsInHand(Player.Second, gameStateUpdateEvent.getSecondPlayerCardsInHand());

        gameState.setCardsInPlay(Player.First, gameStateUpdateEvent.getFirstPlayerCardsInPlay());
        gameState.setCardsInPlay(Player.Second, gameStateUpdateEvent.getSecondPlayerCardsInPlay());

        return new GameStateUpdateEventResponse(gameStateUpdateEvent.getClientPlayer());
    }
}
