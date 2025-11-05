package com.andela.smartbear.britishtime;

import com.andela.smartbear.britishtime.executable.BritishTimeSpeaker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BritishTimeCommonTimeTest {

    private final BritishTimeSpeaker converter = new BritishTimeSpeaker();

    @Test
    void testMidnightAndNoon() {
        assertEquals("midnight", converter.convertToBritishTime("00:00"));
        assertEquals("noon", converter.convertToBritishTime("12:00"));
    }

    @Test
    void testOClock() {
        assertEquals("one o'clock", converter.convertToBritishTime("01:00"));
        assertEquals("eleven o'clock", converter.convertToBritishTime("11:00"));
    }

    @Test
    void testCommonTimes() {
        assertEquals("half past seven", converter.convertToBritishTime("07:30"));
        assertEquals("quarter past four", converter.convertToBritishTime("04:15"));
        assertEquals("quarter to ten", converter.convertToBritishTime("09:45"));
        assertEquals("twenty five past six", converter.convertToBritishTime("06:25"));
        assertEquals("ten to eleven", converter.convertToBritishTime("10:50"));
        assertEquals("twenty to eleven", converter.convertToBritishTime("10:40"));
        assertEquals("twenty five to eleven", converter.convertToBritishTime("10:35"));
        assertEquals("ten to eleven", converter.convertToBritishTime("10:50"));
        assertEquals("five to eleven", converter.convertToBritishTime("10:55"));
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> converter.convertToBritishTime("2400"));
        assertThrows(IllegalArgumentException.class, () -> converter.convertToBritishTime("12:60"));
        assertThrows(IllegalArgumentException.class, () -> converter.convertToBritishTime(null));
        assertThrows(IllegalArgumentException.class, () -> converter.convertToBritishTime("32:50"));
    }
}
