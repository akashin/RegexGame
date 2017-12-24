package com.regexgame.game;

public class PlayerAttributes {
    private int health;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public PlayerAttributes(int health) {
        this.health = health;
    }

    private PlayerAttributes() {
    }
}
