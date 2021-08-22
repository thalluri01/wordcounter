package com.wordcounter.application;

import com.wordcounter.processor.WordCount;
import com.wordcounter.processor.WordCountProcessor;
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

        Integer wrdCount = wordCount.usageCount("hello");

        System.out.println("hello added " + wrdCount + " times.");
    }

}
