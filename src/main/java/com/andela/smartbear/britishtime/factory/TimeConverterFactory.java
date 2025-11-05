package com.andela.smartbear.britishtime.factory;


import com.andela.smartbear.britishtime.strategy.ExactHourStrategy;
import com.andela.smartbear.britishtime.strategy.HalfPastStrategy;
import com.andela.smartbear.britishtime.strategy.MidnightStrategy;
import com.andela.smartbear.britishtime.strategy.MinutePastToStrategy;
import com.andela.smartbear.britishtime.strategy.MinuteStrategy;
import com.andela.smartbear.britishtime.strategy.MinuteToStrategy;
import com.andela.smartbear.britishtime.strategy.NoonStrategy;
import com.andela.smartbear.britishtime.strategy.QuarterPastStrategy;
import com.andela.smartbear.britishtime.strategy.QuarterToStrategy;
import com.andela.smartbear.britishtime.strategy.TimeConverter;

public class TimeConverterFactory {

    public static TimeConverter getStrategy(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        if (hour == 0) {
            return new MidnightStrategy();
        } else if (hour == 12) {
            return new NoonStrategy();
        }
        if (minute == 0) {
            return new ExactHourStrategy();
        } else if (minute == 15) {
            return new QuarterPastStrategy();
        } else if (minute == 30) {
            return new HalfPastStrategy();
        } else if (minute == 45) {
            return new QuarterToStrategy();
        } else if (minute < 30) {
            return new MinutePastToStrategy();
        } else if (minute %5 ==0){
            return new MinuteToStrategy();
        }else {
            return new MinuteStrategy();
        }
    }
}