package com.example.operations;

import java.math.BigDecimal;

public class Addition implements Operation {

    @Override
    public BigDecimal calculate(BigDecimal number1, BigDecimal number2) {
        return number1.add(number2);
    }

    @Override
    public void calculate() {

    }
}
