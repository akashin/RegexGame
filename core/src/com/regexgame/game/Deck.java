package com.regexgame.game;

import java.util.Random;

public class Deck {
    private Cards cards;

    public Deck(Cards cards) {
        this.cards = cards;
    }

    public Card dealCard() {
        return cards.random();
    }

    // TODO(akashin): Get rid of startId by assigning it when card is dealt.
    public static Cards generateRandomCards(int count, int startId) {
        Random random = new Random();
        Cards cards = new Cards();
        for (int i = 0; i < count; ++i) {
            cards.add(generateRandomCard(random, startId + i));
        }
        return cards;
    }

    private static Card generateRandomCard(Random random, int id) {
        String attack = Integer.toString(random.nextInt(10) + 1);
        String defence = Integer.toString(random.nextInt(20) + 1);
        return new Card(id, attack, defence);
    }

}
