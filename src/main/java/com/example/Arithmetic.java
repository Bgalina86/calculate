package com.example;

import com.example.validation.Validation;
import java.util.Scanner;

public class Arithmetic extends Validation {
    private static double prevResult = 0;

    public static void main(String[] args) {
      //  Scanner sc = new Scanner(System.in);

        Arithmetic arith = new Arithmetic();
       System.out.println("123+334" + ": "+ arith.validateVerbose("123+334"));
       System.out.println("12F3+334" + ": "+  arith.validateVerbose("A123+334"));
       System.out.println("1+: "+  arith.validateVerbose("1+"));//
       System.out.println("123 1234  +" + ": "+  arith.validateVerbose("123 1234  +"));//
        System.out.println("123 1234" + ": "+  arith.validateVerbose("123 1234"));//
       System.out.println("/123@1234 " + ": "+  arith.validateVerbose("/123@1234 "));
       System.out.println("123/1234 " + ": "+  arith.validateVerbose("123/1234 "));
        System.out.println("123*1234 " + ": "+  arith.validateVerbose("123*1234 "));

//        while (true) {
//            System.out.println("Enter expression (or 'q' to exit): ");
//            String input = sc.nextLine();
//            if (input.equalsIgnoreCase("q")) {
//                break;
//            }
//            if (input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '*'
//                || input.charAt(0) == '/')
//            {
//                input = prevResult + input;
//                // }
//               // prevResult = arith.validateLine(input);
//                System.out.println("Result: " + prevResult);
//            }
//            sc.close();
//        }


    }
}
