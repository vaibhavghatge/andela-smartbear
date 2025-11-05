package com.andela.smartbear.britishtime.strategy;

public class MidnightStrategy implements TimeConverter {
    @Override
    public String convert(int hour, int minute) {
        return "midnight";
    }
}