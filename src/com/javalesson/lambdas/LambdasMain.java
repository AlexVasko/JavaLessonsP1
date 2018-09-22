package com.javalesson.lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class LambdasMain {


    public static void main(String[] args) {
        String[] colours = {"green", "brown", "black", "blue", "pink", "grey"};

        Player player1 = new Player("Alex", 100);
        Player player2 = new Player("Igor", 80);
        Player player3 = new Player("Viktor", 80);
        Player player4 = new Player("John", 91);

        Player[] players = {player1, player2, player3, player4};

        Arrays.sort(players, (p1, p2) -> {
                    if ((p2.score - p1.score) != 0) {
                        return p2.score - p1.score;
                    } else {
                        return p1.name.compareTo(p2.name);
                    }
                }
        );

        System.out.println(Arrays.toString(players));

        Arrays.sort(colours, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                System.out.println("Hello world");
                return s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 2);
            }
        });

        System.out.println(Arrays.toString(colours));

        Arrays.sort(colours, (s1, s2) ->
                s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 2)
        );

        Thread thread = new Thread(() -> {
            System.out.println("Hello world");
        });
    }

    private static class Player {

        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

}
