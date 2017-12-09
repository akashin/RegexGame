package com.regexgame.game.event;

import com.regexgame.game.Player;

abstract public class Event {
    private Player owner;

    public Event(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
