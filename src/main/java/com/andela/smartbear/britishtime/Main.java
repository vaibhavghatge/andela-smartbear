package com.andela.smartbear.britishtime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create strategy
        TimeSpeaker britishSpeaker = new BritishTimeSpeaker();

        // Optional: wrap context in a converter for clarity
        BritishTimeConverter converter = new BritishTimeConverter(britishSpeaker);

        System.out.println("Enter time in HH:mm (24-hour) format (e.g. 07:30, 13:05). Type 'exit' to quit.");

        while (true) {
            System.out.print("Time: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            try {
                String spokenTime = converter.toBritishSpoken(input);
                System.out.println("British Spoken Time: " + spokenTime);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
