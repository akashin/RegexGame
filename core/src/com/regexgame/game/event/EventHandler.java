package com.regexgame.game.event;

import com.regexgame.game.MatchState;

abstract public class EventHandler {
    abstract public boolean canBeHandled(MatchState matchState, Event event);

    abstract public EventResponse handle(MatchState matchState, Event event);
}
