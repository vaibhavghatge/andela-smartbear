package com.andela.smartbear.britishtime.executable;

import com.andela.smartbear.britishtime.factory.TimeConverterFactory;
import com.andela.smartbear.britishtime.strategy.TimeConverter;

public class BritishTimeSpeaker {

    public String convertToBritishTime(String time) {
        if (time == null || !time.matches("^\\d{1,2}:\\d{2}$")) {
            throw new IllegalArgumentException("Time must be in HH:mm format");
        }
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        TimeConverter strategy = TimeConverterFactory.getStrategy(hour, minute);
        return strategy.convert(hour, minute);
    }
}