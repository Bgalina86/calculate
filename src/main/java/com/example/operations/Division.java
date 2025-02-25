package com.example.operations;

import java.math.BigDecimal;

public class Division implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.divide(number2);
    }
}
