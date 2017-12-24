package com.regexgame.game.event;

import com.badlogic.gdx.utils.Json;
import com.regexgame.GameEvent;
import com.regexgame.MatchFinished;
import com.regexgame.game.Player;

public class MatchFinishedEvent extends Event {
    private Player winner;

    public MatchFinishedEvent(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

    public GameEvent toProto() {
        Json json = new Json();
        return GameEvent.newBuilder()
                .setMatchFinished(MatchFinished.newBuilder()
                        .setJsonEncoded(json.toJson(this)))
                .build();
    }

    private MatchFinishedEvent() {
    }
}
