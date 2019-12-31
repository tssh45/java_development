package com.matida.exceptions;

public class ExceptionsDemo {
    public static void show() {
        var account = new Account();


        try {
            account.deposit(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit cannot be less than zero");
        }
        try {
            account.withdrawal(10);
        } catch (AccountException e) {
            var cause = e.getCause();
            System.out.println(cause.getMessage());
        }
    }
}
