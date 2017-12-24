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

    public int damage(String attack) {
        int attackValue = Integer.valueOf(attack);
        int defenseValue = Integer.valueOf(defence);
        int damageDealt = Math.min(defenseValue, attackValue);
        defence = Integer.toString(defenseValue - damageDealt);
        return damageDealt;
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

    private Card() {}
}
