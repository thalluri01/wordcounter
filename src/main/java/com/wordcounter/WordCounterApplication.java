package com.wordcounter;

import com.wordcounter.translate.Translator;

public class WordCounterApplication {

    public static void main(String[] args) {

        WordCount wordCount = new WordCountProcessor(new Translator() {
            @Override
            public String translate(String word) {
                return "hello";
            }
        });

        boolean isWordAdded = wordCount.addWord("hello");

        System.out.println("hello" + " added " +isWordAdded);

        Long wrdCount = wordCount.usageCount("hello");

        System.out.println("hello added " + wrdCount + " times.");
    }

}
