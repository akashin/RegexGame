package com.regexgame.game.event;

import com.regexgame.game.Player;

public class GameStateUpdateEventResponse extends EventResponse {
    public final Player clientPlayer;

    public GameStateUpdateEventResponse(Player clientPlayer) {
        this.clientPlayer = clientPlayer;
    }
}
