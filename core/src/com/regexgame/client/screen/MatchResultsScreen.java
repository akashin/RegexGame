package com.regexgame.client.screen;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.regexgame.client.RegexGameClient;

public class MatchResultsScreen extends BasicScreen {
    private Label resultsLabel;

    private boolean win;

    public MatchResultsScreen(RegexGameClient game, boolean win) {
        super(game);
        this.win = win;
    }

    @Override
    public void show() {
        super.show();

        Table table = new Table();
        table.setFillParent(true);

        if (win) {
            resultsLabel = new Label("You won!", game.getSkin());
        } else {
            resultsLabel = new Label("You lost!", game.getSkin());
        }

        table.add(resultsLabel);
        stage.addActor(table);
    }


}
