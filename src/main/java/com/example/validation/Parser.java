package com.example.validation;

import static com.example.validation.Validation.isOperationSign;

import java.util.ArrayList;

/**
 * Разбираем на лексемы
 */
public class Parser {

    public static String[] tokenize(final String org) {
        ArrayList<String> tokens = new ArrayList();

        String token = "";
        for (int i = 0; i < org.length(); i++) {
            char sym = org.charAt(i);

            if (Character.isSpaceChar(sym)) {
                if (!token.isEmpty()) {
                    tokens.add(token);
                }

                token = "";
                continue;
            }
            /**
             * Выбираем числа
             */
            if (Character.isDigit(sym)) {
                token += sym;
                continue;
            }
            /**
             * Выбираем знаки операций
             */
            if (isOperationSign(sym)) {
                if (!token.isEmpty()) {
                    tokens.add(token);
                }

                String opSign = new String();
                opSign += sym;

                tokens.add(opSign);
                token = "";
            }
        }

        if (!token.isEmpty() && token.charAt(0) != ' ') {
            tokens.add(token);
        }

        return tokens.toArray(new String[0]);
    }
}
