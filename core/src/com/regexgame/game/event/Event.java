package com.regexgame.game.event;

import com.regexgame.GameEvent;
import com.regexgame.game.Player;

abstract public class Event {
    private Player owner;

    public Event(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public GameEvent toProto() { throw new UnsupportedOperationException(); }

    protected Event() {}
}
