package com.sinyo;


import com.sinyo.collections.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Zephyr"));
        customers.add(new Customer("WRashpiya"));
        customers.add(new Customer("Stockley"));
        Collections.sort(customers);
        System.out.println(customers);

    }
}
