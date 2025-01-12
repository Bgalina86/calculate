package com.example.constClass;

import com.example.enumClass.TokenType;
import com.example.validation.Validation;

public class ClassifyToken {

    public static TokenType classifyToken(final String token)
    {

        if(token.isEmpty())
            return TokenType.InvalidToken;

        char sym = token.charAt(0);

        if(Character.isDigit(sym))
            return TokenType.Number;

        if(Validation.isOperationSign(sym))
            return TokenType.OperationSign;
        else
            return TokenType.InvalidToken;
    }
}
