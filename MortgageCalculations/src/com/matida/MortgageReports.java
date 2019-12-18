package com.matida;

import java.text.NumberFormat;

public class MortgageReports {

    private MortgageCalculator calculator;

    public static void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENTS SCHEDULE: ");
        System.out.println("------------------------------");
        for (short month = 1; month <= calculator.getYears() * Main.MONTHS_IN_YEAR; month ++) {
            double balance = MortgageCalculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public void printMortgage() {
        calculator = new MortgageCalculator();
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("----------------------");
        System.out.println("Monthly payments: " + mortgageFormatted);
        System.out.println();
    }

    public short getYears() {
        return years;
    }
}
