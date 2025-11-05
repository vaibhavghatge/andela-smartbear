package com.andela.smartbear.britishtime.strategy;

import static com.andela.smartbear.britishtime.strategy.ConversionUtils.numberToWord;

public class QuarterToStrategy implements TimeConverter {
    @Override
    public String convert(int hour, int minute) {
        return String.format("quarter to %s", numberToWord(hour + 1));
    }
}