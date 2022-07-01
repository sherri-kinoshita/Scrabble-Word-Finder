package com.sherri.kinoshita;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WordSorter {
    public Map<Character, Integer> mapGivenLetters(String input) {
        Map<Character, Integer> letterMap = new HashMap<>();
        input = input.toUpperCase();

        if (input.length() <= 7) {
            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(i);
                if (!letterMap.containsKey(letter)) {
                    letterMap.put(letter, 1);
                } else {
                    int count = letterMap.get(letter) + 1;
                    letterMap.put(letter, count);
                }
            }
        } else {
            letterMap = null;
        }
        return letterMap;
    }
}
