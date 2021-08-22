package com.wordcounter.processor;

import com.wordcounter.data.WordsBucket;
import com.wordcounter.translate.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Service
public class WordCountProcessor implements WordCount {

    @Autowired
    private Translator translator;

    public WordCountProcessor(Translator translator) {
        this.translator = translator;
    }

    /**
     * addWord
     * @param word
     * @return boolean
     */
    public boolean addWord(String word) {

        // should NOT allow addition of words with non-alphabetic characters
        if (word== null || !word.matches("[a-zA-Z]+")) {
            return Boolean.FALSE;
        }

        // call translator to fetch the default word i.e english
        String defaultWord = translator.translate(word);

        // add words to the map key with default word
        WordsBucket.addWords(defaultWord, word);
        return Boolean.TRUE;
    }

    /**
     * usageCount
     * @param word
     * @return Integer
     */
    public Integer usageCount(final String word) {

        if (WordsBucket.getWords()!=null) {
            Optional<Map.Entry<String, Set<String>>> found = WordsBucket.getWords().entrySet().stream()
                    .filter(x -> x.getValue().contains(word)).findFirst();
            if (found.isPresent()) {
                return found.get().getValue().size();
            }
        }
        return 0;

    }

}
