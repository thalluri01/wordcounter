package com.wordcounter.processor;

public interface WordCount {

    boolean addWord(String word);

    Integer usageCount(String word);

}
