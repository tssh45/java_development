package com.matida;

import com.matida.exceptions.ExceptionsDemo;
import com.matida.generics.GenericList;
import com.matida.generics.List;
import com.matida.generics.User;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
        ExceptionsDemo.show();
        }
        catch (Throwable ex) {
            System.out.println("An unexpected error occurred");
        }

    }
}
