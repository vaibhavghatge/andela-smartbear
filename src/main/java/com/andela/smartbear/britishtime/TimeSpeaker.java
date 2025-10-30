package com.andela.smartbear.britishtime;

/**
 * Strategy interface for converting hour/minute into spoken time.
 */
public interface TimeSpeaker {
    /**
     * Convert hour (0-23) and minute (0-59) into spoken time string.
     * @param hour 0-23
     * @param minute 0-59
     * @return spoken representation
     */
    String speak(int hour, int minute);
}
