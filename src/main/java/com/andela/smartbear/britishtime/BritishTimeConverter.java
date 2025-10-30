package com.andela.smartbear.britishtime;

/**
 * Facade for converting HH:mm time strings using a TimeSpeaker strategy.
 */
public class BritishTimeConverter {

    private final SpeakerContext context;

    public BritishTimeConverter(TimeSpeaker speaker) {
        this.context = new SpeakerContext(speaker);
    }

    public String toBritishSpoken(String time) {
        if (time == null || !time.matches("^\\d{1,2}:\\d{2}$")) {
            throw new IllegalArgumentException("Time must be in HH:mm format");
        }
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]) % 24;
        int minute = Integer.parseInt(parts[1]);
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        return context.speak(hour, minute);
    }
}
