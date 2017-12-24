package com.regexgame.game.event;

import com.regexgame.game.MatchState;

public class MatchFinishedEventHandler extends EventHandler {
    @Override
    public boolean canBeHandled(MatchState matchState, Event event) {
        return event instanceof MatchFinishedEvent;
    }

    @Override
    public EventResponse handle(MatchState matchState, Event event) {
        MatchFinishedEvent matchFinishedEvent = (MatchFinishedEvent) event;
        return new MatchFinishedEventResponse(matchFinishedEvent.getWinner());
    }
}
