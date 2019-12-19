package com.matida;

import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        var control = new UIControl(true);
        var textBox = new TextBox();
        show(textBox);
    }

    public static void show(UIControl control) {
        if (control instanceof TextBox) {
            var textBox = (TextBox) control;  
            textBox.setText("Hello part2");   
        }
            System.out.println(control);
        }

    }

