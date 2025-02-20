package com.example.constClass;

import com.example.enumClass.ValidationResult;

public interface DisplayErrorText{


    default String displayErrorText(ValidationResult code) {
        switch (code) {
            case OK:
                return "Строка введена корректно согласно примеру";
            case Error_InvalidCharDetected:
                return "Строка содержит символ, не относящийся к математическим вычислениям.";
            case Error_LetterSymbolDetected:
                return "Строка содержит букву. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_SpecialChar:
                return "Строка содержит спецсимволы. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_NoMinNumberChars:
                return "Строка содержит только одно число. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_NoOperationsChars:
                return "Строка не содержит знаков операций. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_OperationsCharsMin:
                return "Строка содержит знаков операций больше чем 1. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_NoStringLength:
                return "Строка не является арифметическим примером. Количество символов в строке меньше 3. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_StringStartWith:
                return "Строка начинается на знак арифметической операции. Введите, пожалуйста, вновь выражение для вычисления";
            default:
                return "Неизвестный код ошибки. Введите, пожалуйста, вновь выражение для вычисления";
        }
    }
}
