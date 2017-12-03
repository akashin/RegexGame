package com.regexgame.client.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.regexgame.client.RegexGameClient;

public class GameScreen extends BasicScreen {
    public GameScreen(RegexGameClient client) {
        super(client);
    }

    @Override
    public void show() {
        super.show();
        Table table = new Table();
        HorizontalGroup playGroup = new HorizontalGroup();
        HorizontalGroup handGroup = new HorizontalGroup();

        table.add(playGroup);
        table.row();
        table.add(handGroup);

        table.setFillParent(true);

        stage.addActor(table);


        BitmapFont bitmapFont = new BitmapFont();
        Label.LabelStyle labelStyle = new Label.LabelStyle(bitmapFont, Color.YELLOW);
        Label testLabel = new Label("HELLO GAME", labelStyle);

        playGroup.addActor(testLabel);
    }
}
