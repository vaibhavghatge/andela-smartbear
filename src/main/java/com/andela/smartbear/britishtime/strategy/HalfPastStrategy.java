package com.andela.smartbear.britishtime.strategy;

import static com.andela.smartbear.britishtime.strategy.ConversionUtils.numberToWord;

public class HalfPastStrategy implements TimeConverter {
    @Override
    public String convert(int hour, int minute) {
        return String.format("half past %s", numberToWord(hour));
    }
}