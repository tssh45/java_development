package com.matida;

import java.text.NumberFormat;

public class MortgageReports {

    private final NumberFormat currency;
    private MortgageCalculate calculator;

    public MortgageReports(MortgageCalculate calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }


    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance: calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
        }


    public void printMortgage() {
        //calculator = new MortgageCalculate(principal, annualInterest, years);
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
