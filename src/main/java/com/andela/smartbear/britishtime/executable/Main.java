package com.andela.smartbear.britishtime.executable;

public class Main {
    public static void main(String[] args) {
        BritishTimeSpeaker speaker = new BritishTimeSpeaker();
        System.out.println(speaker.convertToBritishTime("00:00"));   // five o'clock
        System.out.println(speaker.convertToBritishTime("5:15"));  // quarter past five
        System.out.println(speaker.convertToBritishTime("5:45"));  // quarter to six
    }
}