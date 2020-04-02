package com.wordcounter;

public interface WordCount {

    boolean addWord(String word);

    Long usageCount(String word);


}
