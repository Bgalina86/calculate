package com.example;

import com.example.validation.Validation;
import java.util.Scanner;

public class Arithmetic extends Validation {
    private static double prevResult = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Arithmetic arith = new Arithmetic();
        arith.validateLine("sdfsdfsadf");

        while (true) {
            System.out.println("Enter expression (or 'q' to exit): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            if (input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '*'
                || input.charAt(0) == '/')
            {
                input = prevResult + input;
                // }
               // prevResult = arith.validateLine(input);
                System.out.println("Result: " + prevResult);
            }
            sc.close();
        }


    }
}
