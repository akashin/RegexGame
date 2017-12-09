package com.regexgame.game;

public class Card {
    public enum State {
        Open,
        Hidden
    }

    private int id;

    private State state;

    private String attack;

    private String defence;

    public Card(int id, String attack, String defence) {
        this.id = id;
        this.state = State.Open;
        this.attack = attack;
        this.defence = defence;
    }

    public void damage(String attack) {
        int attackValue = Integer.valueOf(attack);
        int defenseValue = Integer.valueOf(defence);
        defenseValue = Math.max(0, defenseValue - attackValue);
        defence = Integer.toString(defenseValue);
    }

    public int getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefence() {
        return defence;
    }
}
