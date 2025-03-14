package com.example;

import com.example.operations.Operation;
import com.example.enumClass.Operations;
import com.example.operations.*;
import java.math.BigDecimal;
import java.util.InputMismatchException;

public class Calculator {

    public String calculate(double number1, double number2, double operation) {
        Operation o = chooseOperation((int) operation);
        return o.calculate(
                numberToBigDecimal(number1),
                numberToBigDecimal(number2)
            )
            .stripTrailingZeros()
            .toPlainString();
    }

     public double getOperation(String opSign) {
        Operations operations = new Operations();
        char op = opSign.charAt(0);
        switch (op) {
            case '+':
                return operations.ADDITION;
            case '*':
                return operations.MULTIPLICATION;
            case '/':
                return operations.DIVISION;
            case '-':
                return operations.SUBTRACTION;

            default:
                throw new RuntimeException("Некорректный формат введённых данных.");
        }
    }

    private static Operation chooseOperation(int operation) {
        switch (operation) {
            case Operations.ADDITION:
                return new Addition();
            case Operations.SUBTRACTION:
                return new Subtraction();
            case Operations.MULTIPLICATION:
                return new Multiplication();
            case Operations.DIVISION:
                return new Division();
            default:
                throw new InputMismatchException();
        }
    }

    private static BigDecimal numberToBigDecimal(double n) {
        return new BigDecimal(Double.toString(n));
    }
}
