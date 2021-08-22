package com.wordcounter;

import com.wordcounter.processor.WordCountProcessor;
import com.wordcounter.translate.Translator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WordCounterProcessorTest {

    @Mock
    Translator translator;

    @InjectMocks
    WordCountProcessor wordCountProcessor;

    String word1;

    String word2;

    String word3;

    @Before
    public void setUp() {
        word1 = "flower";
        word2 = "flor";
        word3 = "blume";
        when(translator.translate(any(String.class))).thenReturn(word1);
    }

    @Test
    public void addWordTestWithNonAlphaNumeric() throws Exception {
        boolean result1 = wordCountProcessor.addWord("testInvalid01£");
        assertFalse(result1);
    }

    @Test
    public void addWordTest() {
        boolean result1 = wordCountProcessor.addWord(word1);
        boolean result2 = wordCountProcessor.addWord(word2);
        assertEquals(Boolean.TRUE,result1);
        assertEquals(Boolean.TRUE,result2);
    }

    @Test
    public void usageCountTest_sameWordInMultipleLanguages() throws Exception {
        testData();
        Integer count = wordCountProcessor.usageCount(word1);
        assertEquals(1, count.intValue());
    }

    private void testData() {
        boolean result1 = wordCountProcessor.addWord(word1);
        boolean result2 = wordCountProcessor.addWord(word2);
        boolean result3 = wordCountProcessor.addWord(word3);
    }

}


