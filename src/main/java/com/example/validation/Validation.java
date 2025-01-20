package com.example.validation;

import com.example.constClass.ClassifyToken;
import com.example.enumClass.TokenType;
import com.example.enumClass.ValidationResult;

import static com.example.constClass.Helper.ALPHABET_OF_LETTERS;
import static com.example.constClass.Helper.ALPHABET_OF_MATH_OPERATIONS;
import static com.example.constClass.Helper.ALPHABET_OF_MATH_OPERATIONS_AND_NUM;
import static com.example.constClass.Helper.ALPHABET_OF_NUM;
import static com.example.constClass.Helper.ALPHABET_OF_SPECIAL_CHARACTERS;

public class Validation extends Parser{
    public static boolean isOperationSign(char sym) {
        return sym == '+' || sym == '-' || sym == '/' || sym == '*';
    }
    //проверяем наличие знака математической операции и цифр
    private boolean hasAllowedCharsOnly(String line)
    {
        for (int i = 0; i < line.length(); i++){
            char sym = line.charAt(i);
            if(ALPHABET_OF_MATH_OPERATIONS_AND_NUM.indexOf(sym) == -1) {
                return false;
            }
        }
        return true;
    }

    private boolean hasNotAllowedSymbolsLetter(String  line){
        for (int i = 0; i < line.length(); i++){
            char sym = line.charAt(i);
            if(ALPHABET_OF_LETTERS.indexOf(sym) == -1) {
                return false;
            }
        }
        return true;
    }
    private boolean hasNotAllowedSpecialChar(String  line){
        for (int i = 0; i < line.length(); i++){
            char sym = line.charAt(i);
           if (ALPHABET_OF_SPECIAL_CHARACTERS.indexOf(sym) ==-1) {
                return false;
            }
        }
        return true;
    }

    int numberChars = 0;
    private boolean hasNotMinNumberChars(String line){
        for (int i = 0; i < line.length(); i++){
            char sym = line.charAt(i);
            if (ALPHABET_OF_NUM.indexOf(sym) == 0) {
                numberChars++;
            }
            if (numberChars < 2){
                return false;
            }
        }
        return true;
    }

    int operationsChars = 0;
    private boolean hasNotOperationsChars(String line){
        for (int i = 0; i < line.length(); i++){
            char sym = line.charAt(i);
            if (ALPHABET_OF_MATH_OPERATIONS.indexOf(sym) == 0) {
                operationsChars++;
            }
            if ((operationsChars > 2) || (operationsChars == 0)) {
                return false;
            }
        }
        return true;
    }

    //Error_StringStartWith
    // проверка регулярным выражением

    public ValidationResult validateLine(String line)
    {
        if(!hasAllowedCharsOnly(line)) {
            return ValidationResult.Error_InvalidCharDetected;
        } else if (hasNotAllowedSymbolsLetter(line)) {
            return ValidationResult.Error_LetterSymbolDetected;
        } else if (hasNotAllowedSpecialChar(line)) {
            return ValidationResult.Error_SpecialChar;
        }

        String pureLine = line;

        var tokens = tokenize(pureLine);
        if(tokens.length != 3) {
            return ValidationResult.Error_NoStringLength;
        }
        var token1Type = ClassifyToken.classifyToken(tokens[0]);
        var token2Type = ClassifyToken.classifyToken(tokens[1]);
        var token3Type = ClassifyToken.classifyToken(tokens[2]);

        if(token1Type == TokenType.Number && token2Type == TokenType.OperationSign && token3Type == TokenType.Number) {
            return ValidationResult.OK;
        } else {
            return ValidationResult.Error_InvalidGrammar;
        }
    }
}
