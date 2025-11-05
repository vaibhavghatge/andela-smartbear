package com.andela.smartbear.britishtime.strategy;

public class NoonStrategy implements TimeConverter {
    @Override
    public String convert(int hour, int minute) {
        return "noon";
    }
}