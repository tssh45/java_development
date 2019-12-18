package com.matida;

import java.text.NumberFormat;

public class Main {


    public static void main(String[] args) {
        Employee employee = new Employee(53_000,8);
        Employee.printNumberOfEmployees();
        int wage = employee.calculateWage();
        System.out.println(NumberFormat.getCurrencyInstance().format(wage));


        }


    }

