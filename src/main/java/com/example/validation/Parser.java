package com.example.validation;

import static com.example.validation.Validation.isOperationSign;

import java.util.ArrayList;

public class Parser
{
      public static String[] tokenize(final String org) {
        ArrayList<String> tokens = new ArrayList();

        String token = "";
        for (int i = 0; i < org.length(); i++) {
            char sym = org.charAt(i);

            if (Character.isSpaceChar(sym))
            {
                if(!token.isEmpty() )
                    tokens.add(token);

                token = "";
                continue; // Ignores space
            }

            if (Character.isDigit(sym)) {
                token += sym;
                continue;
            }

            if (isOperationSign(sym))
            {
                if(!token.isEmpty())
                    tokens.add(token);

                String opSign = new String();
                opSign += sym;

                tokens.add(opSign);
                token = "";
            }
        }

        if(!token.isEmpty() && token.charAt(0) != ' ')
            tokens.add(token);

        return tokens.toArray(new String[0]);
    }
}
