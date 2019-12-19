package com.matida;

import java.util.Scanner;

public class Console {

    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, int min, int max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value > min && value <= max)
                break;
            System.out.println("Please enter a number between " + min + " and " + max);
        }
        return value;
    }
}