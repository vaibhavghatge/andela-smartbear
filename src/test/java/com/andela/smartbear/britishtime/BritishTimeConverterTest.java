package com.andela.smartbear.britishtime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BritishTimeConverterTest {

    private final BritishTimeConverter converter = new BritishTimeConverter(new BritishTimeSpeaker());

    @Test
    public void testMidnightAndNoon() {
        assertEquals("midnight", converter.toBritishSpoken("00:00"));
        assertEquals("noon", converter.toBritishSpoken("12:00"));
    }

    @Test
    public void testOClock() {
        assertEquals("one o'clock", converter.toBritishSpoken("01:00"));
        assertEquals("eleven o'clock", converter.toBritishSpoken("11:00"));
    }

    @Test
    public void testCommonTimes() {
        assertEquals("half past seven", converter.toBritishSpoken("07:30"));
        assertEquals("quarter past four", converter.toBritishSpoken("04:15"));
        assertEquals("quarter to ten", converter.toBritishSpoken("09:45"));
        assertEquals("twenty five past six", converter.toBritishSpoken("06:25"));
        assertEquals("ten to eleven", converter.toBritishSpoken("10:50"));
        assertEquals("twenty to eleven", converter.toBritishSpoken("10:40"));
        assertEquals("twenty five to eleven", converter.toBritishSpoken("10:35"));
        assertEquals("ten to eleven", converter.toBritishSpoken("10:50"));
        assertEquals("five to eleven", converter.toBritishSpoken("10:55"));
    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> converter.toBritishSpoken("2400"));
        assertThrows(IllegalArgumentException.class, () -> converter.toBritishSpoken("12:60"));
        assertThrows(IllegalArgumentException.class, () -> converter.toBritishSpoken(null));
        assertThrows(IllegalArgumentException.class, () -> converter.toBritishSpoken("32:50"));
    }
}
