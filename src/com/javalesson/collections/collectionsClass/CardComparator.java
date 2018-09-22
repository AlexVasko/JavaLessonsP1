package com.javalesson.collections.collectionsClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {
    List<Card.Face> faces = Arrays.asList(Card.Face.values());


    @Override
    public int compare(Card card1, Card card2) {
        if (faces.indexOf(card1.getFace()) < faces.indexOf(card2.getFace())) {
            return 1;
        } else if (faces.indexOf(card1.getFace()) > faces.indexOf(card2.getFace())) {
            return -1;
        } else if (faces.indexOf(card1.getFace()) == faces.indexOf(card2.getFace())) {
            return String.valueOf(card1.getSuit()).compareTo(String.valueOf(card2.getSuit()));
        }
        return 0;
    }
}
