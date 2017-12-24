package com.regexgame.game.event;

import com.regexgame.game.GameState;

public class MatchFinishedEventHandler extends EventHandler {
    @Override
    public boolean canBeHandled(GameState gameState, Event event) {
        return event instanceof MatchFinishedEvent;
    }

    @Override
    public EventResponse handle(GameState gameState, Event event) {
        return new MatchFinishedEventResponse();
    }
}
