package com.javalesson.collections.collectionsClass;

import java.util.Arrays;
import java.util.List;

public class Card implements Comparable<Card> {


    public enum Suit {SPADES, HEARTS, CLUBS, DIMONDS}

    public enum Face {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King}

    private final Suit suit;

    private final Face face;

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public Suit getSuit() {
        return suit;
    }

    public Face getFace() {
        return face;
    }

    @Override
    public int compareTo(Card card) {
        Face[] values = Face.values();
        List<Face> faces = Arrays.asList(values);

        if (faces.indexOf(this.face) < faces.indexOf(card.getFace())) {
            return -1;
        } else if (faces.indexOf(this.face) > faces.indexOf(card.getFace())) {
            return +1;
        } else if (faces.indexOf(this.face) == faces.indexOf(card.getFace())) {
            return String.valueOf(suit).compareTo(String.valueOf(card.getSuit()));
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return face == card.face;
    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (face != null ? face.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
}
