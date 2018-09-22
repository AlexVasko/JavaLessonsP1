package com.javalesson.collections.map.hashmap;


import java.util.*;


public class MapLauncher {

    public static void main(String[] args) {
        Map<String, Integer> wordMap = new HashMap<>();
        System.out.println("Please enter some text");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] tokens = string.split(" ");
        for (String token : tokens) {
            String word = token.toLowerCase();
            Integer count = wordMap.get(word);
            if (count == null) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, count + 1);
            }
        }

        NavigableSet<WordWrapper> wordWrappers = convertToSet(wordMap);
        printSet(wordWrappers);

    }

    private static void printSet(NavigableSet<WordWrapper> wordWrappers) {
            for(WordWrapper wordWrapper: wordWrappers){
                System.out.println(wordWrapper);
            }
    }

    private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> wordMap) {
        wordMap.remove("a");
        wordMap.replace("the",9, 0);
        NavigableSet<WordWrapper> wordSet = new TreeSet<>();
        for (Map.Entry<String, Integer> e : wordMap.entrySet()) {
            wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
        }
        return wordSet;
    }


}
