package com.regexgame.game;

public class Card {
    public enum State {
        Open,
        Selected,
        Hidden
    }

    public State state;

    public String attack = "1";

    public String defence = "1";

    public Card(String attack, String defence) {
        this.state = State.Open;
        this.attack = attack;
        this.defence = defence;
    }

    public void select() {
        if (state == State.Open) {
            state = State.Selected;
        } else if (state == State.Selected) {
            state = State.Open;
        }
    }

    public void resetSelection() {
        if (state == State.Selected) {
            state = State.Open;
        }
    }
}
