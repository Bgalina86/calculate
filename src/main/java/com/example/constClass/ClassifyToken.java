package com.example.constClass;

import static com.example.validation.Validation.isOperationSign;

import com.example.enumClass.TokenType;
import com.example.validation.Validation;

public interface ClassifyToken {

    static TokenType classifyToken(final String token) {
        if (token.isEmpty()) {
            return TokenType.InvalidToken;
        }

        char sym = token.charAt(0);
        if (Character.isDigit(sym)) {
            return TokenType.Number;
        }
        if (isOperationSign(sym)) {
            return TokenType.OperationSign;
        } else {
            return TokenType.InvalidToken;
        }
    }
}
