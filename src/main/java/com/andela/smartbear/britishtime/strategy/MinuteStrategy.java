package com.andela.smartbear.britishtime.strategy;

import static com.andela.smartbear.britishtime.strategy.ConversionUtils.numberToWord;

public class MinuteStrategy implements TimeConverter {
    @Override
    public String convert(int hour, int minute) {
        return String.format("%s %s", numberToWord(hour), numberToWord(minute));
    }
}