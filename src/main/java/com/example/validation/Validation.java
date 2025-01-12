package com.example.validation;

import com.example.constClass.ClassifyToken;
import com.example.enumClass.TokenType;
import com.example.enumClass.ValidationResult;

import static com.example.constClass.AlphabetOfMathOperationsAndNumbers.ALPHABET_OF_MATH_OPERATIONS_AND_NUM;
public class Validation extends Parser{
    public static boolean isOperationSign(char sym) {
        return sym == '+' || sym == '-' || sym == '/' || sym == '*';
    }
    //проверяем наличие знака математической операции
    private boolean hasAllowedCharsOnly(String line)
    {
        for (int i = 0; i < line.length(); i++)
        {
            char sym = line.charAt(i);
            if(ALPHABET_OF_MATH_OPERATIONS_AND_NUM.indexOf(sym) == -1)
                return false;
        }
        return true;
    }

    public ValidationResult validateLine(String line)
    {
        if(!hasAllowedCharsOnly(line))
            return ValidationResult.InvalidCharDetected;

        String pureLine = line;

        var tokens = tokenize(pureLine);
        if(tokens.length != 3)
            return ValidationResult.UnexpectedTokenCount;

        var token1Type = ClassifyToken.classifyToken(tokens[0]);
        var token2Type = ClassifyToken.classifyToken(tokens[1]);
        var token3Type = ClassifyToken.classifyToken(tokens[2]);

        if(token1Type == TokenType.Number && token2Type == TokenType.OperationSign && token3Type == TokenType.Number)
            return ValidationResult.OK;
        else
            return ValidationResult.InvalidGrammar;
    }
}
