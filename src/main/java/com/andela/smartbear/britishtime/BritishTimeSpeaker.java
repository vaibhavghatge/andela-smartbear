package com.andela.smartbear.britishtime;

import java.util.Map;
import java.util.TreeMap;

/**
 * British implementation of TimeSpeaker. Supports common British spoken forms.
 */
public class BritishTimeSpeaker implements TimeSpeaker {

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

    /**
     * Rules implemented:
     * - 00:00 -> midnight
     * - 12:00 -> noon
     * - minute == 0 -> "H o'clock"
     * - minute == 15 -> "quarter past H"
     * - minute == 30 -> "half past H"
     * - minute == 45 -> "quarter to nextH"
     * - minute < 30 -> "M past H"
     * - minute > 30 -> "N to nextH" where N = 60 - minute where N mod 5 not equal to 0
     */
    @Override
    public String speak(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }

        int h = hour % 24;

        // Special cases
        if (h == 0 && minute == 0) return "midnight";
        if (h == 12 && minute == 0) return "noon";

        int displayHour = h % 12;
        if (displayHour == 0) displayHour = 12;

        // O'clock
        if (minute == 0) {
            return numberToWord(displayHour) + " o'clock";
        }

        // Quarter and half
        if (minute == 15) return "quarter past " + numberToWord(displayHour);
        if (minute == 30) return "half past " + numberToWord(displayHour);
        if (minute == 45) {
            int nextHour = (displayHour % 12) + 1;
            return "quarter to " + numberToWord(nextHour);
        }

        // <30 -> past
        if (minute < 30) {
            return NUM_WORDS.get(minute) + " past " + numberToWord(displayHour);
        }

        if(minute%5==0){
            int minutesTo = 60 - minute;
            int nextHour = (displayHour % 12) + 1;
            return NUM_WORDS.get(minutesTo) + " to " + numberToWord(nextHour);
        }
        // digital form for non mod 5
        return numberToWord(displayHour) + " " + numberToWord(minute);
    }

    private String numberToWord(int n) {
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
