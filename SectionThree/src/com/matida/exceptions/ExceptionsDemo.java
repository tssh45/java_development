package com.matida.exceptions;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;






public class ExceptionsDemo {

    public static void show() {
        var account = new Account(10);

        try {
            account.deposit(-1);
            System.out.println("Deposit was successful");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: Deposit cannot be less than zero");
            Logger.getLogger("File not found");



        }
        try {
            account.withdraw(10);
            System.out.println("Withdrawal was a success");
        } catch (AccountException e) {
            var cause = e.getCause();
            System.out.println(cause.getMessage());




        }
    }
}