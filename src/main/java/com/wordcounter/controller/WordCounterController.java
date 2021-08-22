package com.wordcounter.controller;

import com.wordcounter.processor.WordCountProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wordcounter")
public class WordCounterController {

    @Autowired
    private WordCountProcessor wordCountProcessor;

    public WordCounterController() {
    }

    @GetMapping("/{word}")
    public Integer getCountByWord(@PathVariable("word") final String word) {
        return wordCountProcessor.usageCount(word);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void addWord(@RequestBody String word) {
        wordCountProcessor.addWord(word);
    }

}
