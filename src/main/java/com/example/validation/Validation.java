package com.example.validation;

import com.example.enumClass.TokenType;
import com.example.enumClass.ValidationResult;

import static com.example.constClass.ClassifyToken.classifyToken;
import static com.example.constClass.Helper.ALPHABET_OF_LETTERS;
import static com.example.constClass.Helper.ALPHABET_OF_LETTERS1;
import static com.example.constClass.Helper.ALPHABET_OF_LETTERS2;
import static com.example.constClass.Helper.ALPHABET_OF_LETTERS3;
import static com.example.constClass.Helper.ALPHABET_OF_MATH_OPERATIONS;
import static com.example.constClass.Helper.ALPHABET_OF_MATH_OPERATIONS_AND_NUM;
import static com.example.constClass.Helper.ALPHABET_OF_NUM;
import static com.example.constClass.Helper.ALPHABET_OF_SPECIAL_CHARACTERS;

public class Validation extends Parser{

        public static boolean isOperationSign(char sym){
            return sym == '+' || sym == '-' || sym == '/' || sym == '*';
        }
        //проверяем наличие знака математической операции и цифр
        private boolean hasAllowedCharsOnly(String line)
        {
            for (int i = 0; i < line.length(); i++) {
                char sym = line.charAt(i);
                if (ALPHABET_OF_MATH_OPERATIONS_AND_NUM.indexOf(sym) == -1) {
                    return false;
                }
            }
           return true;
        }

        private boolean hasNotAllowedSymbolsLetter(String line){
            for (int i = 0; i < line.length(); i++) {
                char sym = line.charAt(i);
                if (ALPHABET_OF_LETTERS.indexOf(sym) == 0 || ALPHABET_OF_LETTERS1.indexOf(sym) == 0 || ALPHABET_OF_LETTERS2.indexOf(sym) == 0 || ALPHABET_OF_LETTERS3.indexOf(sym) == 0) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasNotAllowedSpecialChar(String line){
            for (int i = 0; i < line.length(); i++) {
                char sym = line.charAt(i);
                if (ALPHABET_OF_SPECIAL_CHARACTERS.indexOf(sym) == -1) {
                    return true;
                }
            }
            return false;
        }

        int numberChars = 0;
        private boolean hasNotMinNumberChars(String line){
            for (int i = 0; i < line.length(); i++) {
                char sym = line.charAt(i);
                if (ALPHABET_OF_NUM.indexOf(sym) == 0) {
                    numberChars++;}}
                if(numberChars < 3){
                    return false;}
            return true;
        }

        int operationsChars = 0;
        private boolean hasMoreThenTwoOperationsChars(String line){
            for (int i = 0; i < line.length(); i++) {
                char sym = line.charAt(i);
                if (ALPHABET_OF_MATH_OPERATIONS.indexOf(sym) == 0) {
                    operationsChars++;
                }
            }
                if (operationsChars > 2)  {
                    return false;
                }

            return true;
        }
int operationsCharsNull = 0;
    private boolean hasNotOperationsChars(String line){
        for (int i = 0; i < line.length(); i++) {
            char sym = line.charAt(i);
            if (ALPHABET_OF_MATH_OPERATIONS.indexOf(sym) == 0) {
                operationsChars++;
            }
        }
            if (operationsCharsNull == 0) {
                return false;
            }
        return true;
    }

        private boolean hasNotOperationsNext(String line){
            for (int i = 0; i < line.length(); i++) {
                for (int j = 0; j < ALPHABET_OF_MATH_OPERATIONS.length(); j++){
                    String alphabetMathOperations = String.valueOf(
                        ALPHABET_OF_MATH_OPERATIONS.charAt(j));
                    if (line.startsWith(alphabetMathOperations)) {
                        return false;
                    }
                }
            }
            return true;
        }

    public String validateVerbose(final String line)
    {
        ValidationResult vr = this.validateLine(line);
        return vr.displayErrorText(vr);
    }


    public ValidationResult validateLine(String line)
    {
        //if (!hasAllowedCharsOnly(line)){return ValidationResult.Error_NoStringLength;}
        if (!hasNotAllowedSymbolsLetter(line)) {return ValidationResult.Error_LetterSymbolDetected;}
        if (!hasNotAllowedSpecialChar(line)) {return ValidationResult.Error_SpecialChar;}
        if (hasNotOperationsChars(line)) {return ValidationResult.Error_NoOperationsChars;}
        if (!hasNotOperationsNext(line)) {return ValidationResult.Error_StringStartWith;}
        if(hasNotMinNumberChars(line)) {return ValidationResult.Error_NoStringLength;}
//        if (!hasNotOperationsChars(line)) return ValidationResult.Error_NoOperationsChars;
        //if(!hasNotOperationsNext(line)) return ValidationResult;

        String pureLine = line;

        var tokens = tokenize(pureLine);
        if(tokens.length != 3)
            return ValidationResult.Error_UnexpectedTokenCount;

        var token1Type = classifyToken(tokens[0]);
        var token2Type = classifyToken(tokens[1]);
        var token3Type = classifyToken(tokens[2]);

        if(token1Type == TokenType.Number && token2Type == TokenType.OperationSign && token3Type == TokenType.Number)
            return ValidationResult.OK;
        else
            return ValidationResult.Error_InvalidGrammar;
    }

}
