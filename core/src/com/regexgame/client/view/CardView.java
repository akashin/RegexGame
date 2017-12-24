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
    private static final int CARD_SPACING = 5;
    private static final int CARD_PADDING = 10;
    private static final int CARD_BORDER = 5;
    private static final int CARD_WIDTH = 50;
    private static final int CARD_HEIGHT = 80;

    // Data
    private Card card;

    private boolean selected;

    // Assets
    private Sprite cardSprite;

    private Sprite selectionSprite;

    private BitmapFont font;

    private GlyphLayout glyphLayout;

    public CardView(Card card, AssetManager assetManager) {
        this.card = card;
        this.selected = false;

        setSize(CARD_WIDTH + 2 * CARD_PADDING, CARD_HEIGHT + 2 * CARD_PADDING);

        cardSprite = new Sprite(assetManager.get("empty.png", Texture.class));
        cardSprite.setSize(CARD_WIDTH, CARD_HEIGHT);
        cardSprite.setColor(Color.WHITE);

        selectionSprite = new Sprite(assetManager.get("empty.png", Texture.class));
        selectionSprite.setSize(CARD_WIDTH + 2 * CARD_BORDER, CARD_HEIGHT + 2 * CARD_BORDER);
        selectionSprite.setColor(Color.RED);

        font = assetManager.get("size10b.ttf", BitmapFont.class);
        glyphLayout = new GlyphLayout(font, card.getAttack());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (selected) {
            selectionSprite.setPosition(getX() + CARD_PADDING - CARD_BORDER, getY() + CARD_PADDING - CARD_BORDER);
            selectionSprite.draw(batch, parentAlpha);
        }

        cardSprite.setPosition(getX() + CARD_PADDING, getY() + CARD_PADDING);
        cardSprite.draw(batch, parentAlpha);

        font.draw(
                batch,
                card.getAttack(),
                getX() + CARD_PADDING + CARD_SPACING,
                getY() + CARD_PADDING + CARD_SPACING + glyphLayout.height
        );
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
