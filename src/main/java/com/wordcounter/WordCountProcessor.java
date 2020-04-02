package com.wordcounter;

import com.wordcounter.data.WordsBucket;
import com.wordcounter.translate.Translator;
import com.wordcounter.translate.TranslatorImpl;


public class WordCountProcessor implements  WordCount {

    private Translator translator;

    public WordCountProcessor(Translator translator) {
        this.translator = translator;
    }

    /**
     * allows to add words
     * @param word
     * @return boolean
     */
    public boolean addWord(String word) {

        //should NOT allow addition of words with non-alphabetic characters
        if (word== null || !word.matches("[a-zA-Z]+")) {
            return Boolean.FALSE;
        }

        // call tranlator to fetch the default word i.e english
        String defaultWord = translator.translate(word);

        // add words to the map key with default word
        WordsBucket.addWords(defaultWord, word);
        return Boolean.TRUE;
    }


    /**
     *
     * @param word
     * @return long
     */
    public Long usageCount(final String word) {

        return WordsBucket.getWords().entrySet().stream()
                .filter(x -> x.getValue().contains(word))
                .map(y->y.getValue())
                .count();

    }

}
