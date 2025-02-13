package com.example.enumClass;

import com.example.constClass.DisplayErrorText;

public enum ValidationResult implements DisplayErrorText {
    OK,
    Error_InvalidCharDetected,
    Error_UnexpectedTokenCount,
    Error_InvalidGrammar,
    Error_LetterSymbolDetected,
    Error_SpecialChar,
    Error_NoMinNumberChars,
    Error_NoOperationsChars,
    Error_OperationsCharsMin,
    Error_NoStringLength,
    Error_StringStartWith;

    @Override
    public String displayErrorText(ValidationResult code) {
        return DisplayErrorText.super.displayErrorText(code);
    }
}
