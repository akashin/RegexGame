package com.regexgame.game.event;

import com.regexgame.game.Player;

public class GameStateUpdateEventResponse extends EventResponse {
    public final Player player;

    public GameStateUpdateEventResponse(Player player) {
        this.player = player;
    }
}
