package com.matida;

public class Main {


    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal value: ", 1000, 1000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest: ", 0, 30);
        byte years = (byte) Console.readNumber("Years: ", 0, 30);

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterest, years);
        MortgageReports report = new MortgageReports(calculator);

        report.printMortgage();
        report.printPaymentSchedule();


    }

}
