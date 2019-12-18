package com.matida;

public class Main {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;


    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal value: ", 1000, 1000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest: ", 0, 30);
        byte years = (byte) Console.readNumber("Years: ", 0, 30);

        new MortgageReports().printMortgage();
        MortgageReports.printPaymentSchedule();


    }

}
