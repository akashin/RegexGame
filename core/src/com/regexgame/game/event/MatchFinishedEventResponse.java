package com.regexgame.game.event;

import com.regexgame.game.Player;

public class MatchFinishedEventResponse extends EventResponse {
    public final Player winner;

    public MatchFinishedEventResponse(Player winner) {
        this.winner = winner;
    }
}
