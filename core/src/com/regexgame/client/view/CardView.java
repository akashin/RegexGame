package com.regexgame.client.view;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.regexgame.game.Card;

public class CardView extends Actor {
    static final int CARD_BORDER = 10;
    static final int CARD_PADDING = 5;
    static final int CARD_WIDTH = 50;
    static final int CARD_HEIGHT = 80;

    private Card card;

    private Sprite cardSprite;

    private BitmapFont font;
    private GlyphLayout glyphLayout;

    public CardView(Card card, AssetManager assetManager) {
        this.card = card;
        setSize(CARD_WIDTH + 2 * CARD_BORDER, CARD_HEIGHT + 2 * CARD_BORDER);

        cardSprite = new Sprite(assetManager.get("empty.png", Texture.class));
        cardSprite.setSize(CARD_WIDTH, CARD_HEIGHT);
        cardSprite.setColor(Color.WHITE);

        font = assetManager.get("size15.ttf", BitmapFont.class);
        glyphLayout = new GlyphLayout(font, card.attack);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        cardSprite.setPosition(getX() + CARD_BORDER, getY());
        cardSprite.setRotation(getRotation());
        cardSprite.draw(batch, parentAlpha);

        font.draw(
                batch,
                card.attack,
                getX() + CARD_BORDER + CARD_PADDING,
                getY() + CARD_BORDER + CARD_PADDING + glyphLayout.height
        );
    }
}
