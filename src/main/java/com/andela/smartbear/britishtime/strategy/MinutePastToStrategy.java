package com.andela.smartbear.britishtime.strategy;

import static com.andela.smartbear.britishtime.strategy.ConversionUtils.numberToWord;

public class MinutePastToStrategy implements TimeConverter {
    @Override
    public String convert(int hour, int minute) {
        return String.format("%s past %s", numberToWord(minute), numberToWord(hour));
    }
}
