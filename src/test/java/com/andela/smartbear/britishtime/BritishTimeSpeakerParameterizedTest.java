package com.andela.smartbear.britishtime;

import com.andela.smartbear.britishtime.factory.TimeConverterFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BritishTimeSpeakerParameterizedTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
        // o'clock
        "01:00, one o'clock",
        "11:00, eleven o'clock",
        // past minutes
        "02:05, five past two",
        "03:10, ten past three",
        "04:15, quarter past four",
        "05:20, twenty past five",
        "06:25, twenty five past six",
        // half past
        "07:30, half past seven",
        // to next hour
        "09:45, quarter to ten",
        "10:50, ten to eleven",
        "08:40, twenty to nine",
        "11:55, five to twelve",
        // edge minutes
        "06:01, one past six",
        "06:29, twenty nine past six",
        "06:31, six thirty one",
        "06:59, six fifty nine",
        "06:32, six thirty two",
         //test cases from spec file
        "1:00, one o'clock",
        "2:05, five past two",
        "3:10, ten past three",
        "4:15, quarter past four",
        "5:20, twenty past five",
        "6:25, twenty five past six",
        "6:32, six thirty two",
        "7:30, half past seven",
        "7:35, twenty five to eight",
        "8:40, twenty to nine",
        "9:45, quarter to ten",
        "10:50, ten to eleven",
        "11:55, five to twelve",
        "00:00, midnight",
        "12:00, noon",
        "04:43, four forty three",
        "04:53, four fifty three"
    })
    @DisplayName("Parameterized spoken time cases")
    void parameterizedCases(String input, String expected) {
        String[] parts = input.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        assertEquals(expected,TimeConverterFactory.getStrategy(h, m).convert(h, m));
    }

    @Test
    @DisplayName("Invalid minute/hour throws")
    void invalidMinute() {
        assertThrows(IllegalArgumentException.class, () ->  TimeConverterFactory.getStrategy(10, 60).convert(10,60));
        assertThrows(IllegalArgumentException.class, () -> TimeConverterFactory.getStrategy(10, -1).convert(10,-1));
        assertThrows(IllegalArgumentException.class, () -> TimeConverterFactory.getStrategy(25, -1).convert(25,-1));
        assertThrows(IllegalArgumentException.class, () -> TimeConverterFactory.getStrategy(-1, -1).convert(-1,-1));
    }

}
