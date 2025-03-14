package com.example.enumClass;

public enum ValidationResult {
    OK("Верное выражение"),
    Error_InvalidGrammar(
        "Строка не соответствует записи для вычислений. Нет знака операции между числами."),
    Error_LetterSymbolDetected(
        "Строка содержит букву. Введите, пожалуйста, вновь выражение для вычисления"),
    Error_SpecialChar(
        "Строка содержит спецсимволы. Введите, пожалуйста, вновь выражение для вычисления"),
    Error_NoMinNumberChars(
        "Строка содержит только одно число. Введите, пожалуйста, вновь выражение для вычисления"),
    Error_NoOperationsChars(
        "Строка не содержит знаков операций. Введите, пожалуйста, вновь выражение для вычисления"),
    Error_StringStartWith(
        "Строка начинается на знак арифметической операции. Введите, пожалуйста, вновь выражение для вычисления");

    String errorText;

    public String getErrorText() {
        return errorText;
    }

    ValidationResult(String errorText) {
        this.errorText = errorText;
    }
}
