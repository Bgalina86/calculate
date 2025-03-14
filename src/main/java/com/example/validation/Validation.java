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

public class Validation extends Parser {

    public static boolean isOperationSign(char sym) {
        return sym == '+' || sym == '-' || sym == '/' || sym == '*';
    }

    /**
     * Проверка на наличие символов - букв в строке
     *
     * @param line входящая строка для проверки
     * @return
     */
    private boolean hasSymbolsLetter(String line) {
        for (int i = 0; i < line.length(); i++) {
            char sym = line.charAt(i);
            if (ALPHABET_OF_LETTERS.indexOf(sym) >= 0 ||
                ALPHABET_OF_LETTERS1.indexOf(sym) >= 0 ||
                ALPHABET_OF_LETTERS2.indexOf(sym) >= 0 ||
                ALPHABET_OF_LETTERS3.indexOf(sym) >= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка на наличие спецсимволов в строке
     *
     * @param line входящая строка для проверки
     * @return
     */
    private boolean hasNotAllowedSpecialChar(String line) {
        for (int i = 0; i < ALPHABET_OF_SPECIAL_CHARACTERS.length(); i++) {
            if (line.indexOf(ALPHABET_OF_SPECIAL_CHARACTERS.charAt(i)) != -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка количества знаков в строке
     *
     * @param line входящая строка для проверки
     * @return
     */
    private boolean hasMinNumberChars(String line) {
        if (line.length() < 3) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Проверка на наличие знака операции в строке
     *
     * @param line входящая строка для проверки
     * @return
     */
    private boolean hasOperationsChars(String line) {
        for (int i = 0; i < ALPHABET_OF_MATH_OPERATIONS.length(); i++) {
            if (line.indexOf(ALPHABET_OF_MATH_OPERATIONS.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверяем что строка не начинается на знак операции
     *
     * @param line входящая строка для проверки
     * @return
     */
    private boolean hasOperationsNext(String line) {
        for (int i = 0; i < line.length(); i++) {
            for (int j = 0; j < ALPHABET_OF_MATH_OPERATIONS.length(); j++) {
                String alphabetMathOperations = String.valueOf(
                    ALPHABET_OF_MATH_OPERATIONS.charAt(j));
                if (line.startsWith(alphabetMathOperations)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Детализируем вывод сообщения на основании проверок
     *
     * @param line входящая строка для проверки
     * @return
     */
    public String validateVerbose(final String line) {
        ValidationResult vr = validateLine(line);
        return vr.getErrorText();
    }

    /**
     * Основной класс проверки валидности вводимой строки
     *
     * @param line входящая строка для проверки
     * @return
     */
    public ValidationResult validateLine(String line) {
        if (!hasSymbolsLetter(line)) {
            return ValidationResult.Error_LetterSymbolDetected;
        }
        if (!hasNotAllowedSpecialChar(line)) {
            return ValidationResult.Error_SpecialChar;
        }
        if (!hasOperationsChars(line)) {
            return ValidationResult.Error_NoOperationsChars;
        }
        if (!hasOperationsNext(line)) {
            return ValidationResult.Error_StringStartWith;
        }
        if (!hasMinNumberChars(line)) {
            return ValidationResult.Error_NoMinNumberChars;
        }
        if (!hasOperationsChars(line)) {
            return ValidationResult.Error_NoOperationsChars;
        }

        /**
         * Разбираем лексемы на составные части.
         * Числовые и знак операции.
         * Проверяем валидность такого разделения
         */
        String pureLine = line;

        String[] tokens = tokenize(pureLine);
        TokenType token1Type = classifyToken(tokens[0]);
        TokenType token2Type = classifyToken(tokens[1]);
        TokenType token3Type = classifyToken(tokens[2]);

        if (token1Type == TokenType.Number && token2Type == TokenType.OperationSign
            && token3Type == TokenType.Number) {
            return ValidationResult.OK;
        } else {
            return ValidationResult.Error_InvalidGrammar;
        }
    }
}
