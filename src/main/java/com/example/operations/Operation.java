package com.example.operations;

import java.math.BigDecimal;

public interface Operation {

    BigDecimal calculate(BigDecimal number1, BigDecimal number2);

    void calculate();
}
