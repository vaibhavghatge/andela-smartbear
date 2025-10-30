package com.andela.smartbear.britishtime;

/**
 * Context that holds a TimeSpeaker strategy.
 */
public class SpeakerContext {
    private final TimeSpeaker speaker;

    public SpeakerContext(TimeSpeaker speaker) {
        this.speaker = speaker;
    }

    public String speak(int hour, int minute) {
        return speaker.speak(hour, minute);
    }
}
