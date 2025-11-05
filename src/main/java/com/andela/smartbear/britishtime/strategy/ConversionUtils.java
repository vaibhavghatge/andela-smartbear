package com.andela.smartbear.britishtime.strategy;

import java.util.Map;
import java.util.TreeMap;

public class ConversionUtils {
    private static final Map<Integer, String> NUM_WORDS = createNumWords();
    private static Map<Integer, String> createNumWords() {
        Map<Integer, String> m = new TreeMap<>();
        m.put(0, "zero");
        m.put(1, "one");
        m.put(2, "two");
        m.put(3, "three");
        m.put(4, "four");
        m.put(5, "five");
        m.put(6, "six");
        m.put(7, "seven");
        m.put(8, "eight");
        m.put(9, "nine");
        m.put(10, "ten");
        m.put(11, "eleven");
        m.put(12, "twelve");
        m.put(13, "thirteen");
        m.put(14, "fourteen");
        m.put(15, "quarter");
        m.put(16, "sixteen");
        m.put(17, "seventeen");
        m.put(18, "eighteen");
        m.put(19, "nineteen");
        m.put(20, "twenty");
        m.put(21, "twenty one");
        m.put(22, "twenty two");
        m.put(23, "twenty three");
        m.put(24, "twenty four");
        m.put(25, "twenty five");
        m.put(26, "twenty six");
        m.put(27, "twenty seven");
        m.put(28, "twenty eight");
        m.put(29, "twenty nine");
        m.put(30, "half");
        return m;
    }

    public static String numberToWord(int n) {
        if (NUM_WORDS.containsKey(n)) {
            return NUM_WORDS.get(n);
        }
        return switch (n / 10) {
            case 3 -> "thirty" + (n == 30 ? "" : " " + NUM_WORDS.get(n - 30));
            case 4 -> "forty" + (n == 40 ? "" : " " + NUM_WORDS.get(n - 40));
            case 5 -> "fifty" + (n == 50 ? "" : " " + NUM_WORDS.get(n - 50));
            default -> String.valueOf(n); // fallback for unexpected numbers
        };
    }
}
