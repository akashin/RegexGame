package com.regexgame.game.event;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.regexgame.GameEvent;

public class ProtoParser {
    public static Event parseEvent(GameEvent gameEvent) {
        switch (gameEvent.getEventCase()) {
            case GAME_STATE_UPDATED: {
                Gdx.app.log("INFO","Received game state: " + gameEvent);
                Json json = new Json();
                return json.fromJson(GameStateUpdateEvent.class, gameEvent.getGameStateUpdated().getJsonEncoded());
            }
            case CARD_ATTACKED: {
                Gdx.app.log("INFO","Card attacked: " + gameEvent);
                Json json = new Json();
                return json.fromJson(AttackEvent.class, gameEvent.getCardAttacked().getJsonEncoded());
            }
            case MATCH_FINISHED: {
                Gdx.app.log("INFO","Match finished: " + gameEvent);
                Json json = new Json();
                return json.fromJson(MatchFinishedEvent.class, gameEvent.getMatchFinished().getJsonEncoded());
            }
            default: {
                Gdx.app.log("ERROR", "Unrecognized event: " + gameEvent);
                return null;
            }
        }
    }
}
