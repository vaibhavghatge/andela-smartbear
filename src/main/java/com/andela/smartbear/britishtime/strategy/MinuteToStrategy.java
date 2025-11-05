package com.andela.smartbear.britishtime.strategy;

import static com.andela.smartbear.britishtime.strategy.ConversionUtils.numberToWord;

public class MinuteToStrategy implements TimeConverter {
    @Override
    public String convert(int hour, int minute) {
        return String.format("%s to %s", numberToWord(60-minute), numberToWord(hour+1));
    }
}