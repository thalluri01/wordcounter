package com.wordcounter.data;

import java.util.*;

public class WordsBucket {

    private static Map<String, Set<String>> words;

    public static Map<String, Set<String>> getWords() {
        return words;
    }

    public  static void addWords(String defaultWord, String word) {
        if (words == null) {
            words = new HashMap<>();
        }

        if (words.isEmpty() || words.get(defaultWord).isEmpty()) {
            words.put(defaultWord, new HashSet<>(Arrays.asList(word)));
        } else {
            words.get(defaultWord).add(word);
        }
    }

}
