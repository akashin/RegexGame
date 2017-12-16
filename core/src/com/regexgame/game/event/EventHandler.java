package com.regexgame.game.event;

import com.regexgame.game.GameState;

abstract public class EventHandler {
    abstract public boolean canBeHandled(GameState gameState, Event event);

    abstract public EventResponse handle(GameState gameState, Event event);
}
