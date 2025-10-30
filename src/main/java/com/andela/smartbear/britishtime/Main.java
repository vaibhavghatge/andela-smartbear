package com.andela.smartbear.britishtime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BritishTimeSpeaker speaker = new BritishTimeSpeaker();

        System.out.println("Enter time in HH:mm (24-hour) format (e.g. 07:30, 13:05). Type 'exit' to quit.");

        while (true) {
            System.out.print("Time: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                String[] parts = input.split(":");
                if (parts.length != 2) {
                    System.out.println("Invalid format. Please use HH:mm.");
                    continue;
                }

                int hour = Integer.parseInt(parts[0]);
                int minute = Integer.parseInt(parts[1]);

                String spokenTime = speaker.speak(hour, minute);
                System.out.println("Time " + spokenTime);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
