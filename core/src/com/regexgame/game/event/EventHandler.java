package com.regexgame.game.event;

import com.regexgame.game.GameState;

abstract public class EventHandler<EventClass> {
    abstract public EventResponse handle(GameState gameState, EventClass event);
}
