package com.wordcounter.translate;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TranslatorImpl implements Translator {

    static final Map<String, List<String>> synonymsMap = new HashMap<>();

    static {
        synonymsMap.put("flower", Arrays.asList("flower", "flor", "blume")) ;
    }

    public static <K, V> String getKey(Map<String, List<String>> map, String value)
    {
        for (Map.Entry<String, List<String>> entry: map.entrySet())
        {
            List<String> values = entry.getValue();
            boolean isPresent = values.stream().filter(val -> val.equalsIgnoreCase(value)).findAny().isPresent();
            if (isPresent) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String translate(String word) {
        return getKey(synonymsMap, word);
    }

}
