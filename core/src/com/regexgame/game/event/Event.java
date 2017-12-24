package com.regexgame.game.event;

import com.regexgame.GameEvent;

abstract public class Event {
    public GameEvent toProto() { throw new UnsupportedOperationException(); }

    protected Event() {}
}
