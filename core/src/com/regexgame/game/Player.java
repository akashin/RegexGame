package com.regexgame.game;

public enum Player {
    First(1),
    Second(2);

    public final int index;

    Player(int index) {
        this.index = index;
    }

    public Player getOpposite() {
        if (this == Player.First) {
            return Second;
        } else {
            return First;
        }
    }

    static public Player getByIndex(int index) {
        if (index == First.index) {
            return First;
        } else if (index == Second.index) {
            return Second;
        } else {
            throw new IllegalArgumentException("Wrong Player index");
        }
    }
}
