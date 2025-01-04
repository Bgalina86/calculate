package com.example;
/**
 * Мини-калькулятор
 * Написать программу, которая будет принимать на вход строку со сложением/вычитанием/умножением или делением двух чисел.
 * Покрыть всевозможные проблемы ввода и выводить в итоге результат операции или текст ошибки.
 * Обязательное условие - использование связки: классы + интерфейс.
 * Пример 1:
 * Вход: 2+2
 * Выход: 4
 * Пример 2:
 * Вход 2*К
 * Выход: Введенная строка некорректна (присутствуют необрабатываемые символы)
 *
 * Теоретически покрывает: переменные, типы данных, приведение типов, операции, условный (мб и тернарный) оператор, методы, контексты, наследование (в данном случае имплементацию), взаимоотношение между классами, интерфейсы, работу с методами строковых объектов, исключения
 * На самом деле в зависимости от способа реализации может покрывать как больше аспектов, так и меньше) Все зависит от выбранного способа решения.
 */

import static com.example.constClass.Alphabet.alphabet;

import com.example.enumClass.TokenType;
import com.example.enumClass.ValidationResult;
import java.util.ArrayList;

class Calculate {
    private boolean isOperationSign(char sym) {
        return sym == '+' || sym == '-' || sym == '/' || sym == '*';
    }

    private String[] tokenize(final String org) {
        ArrayList<String> tokens = new ArrayList<String>();

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

    /*
    private String supressSpaces(final String org)
    {
        String result = new String();

        for(int i = 0; i< org.length(); i++)
        {
            char sym = org.charAt(i);
            if(Character.isSpaceChar(sym))
                continue;
            else
                result += sym;
        }

        return result;
    }
*/
    private boolean hasAllowedCharsOnly(String line)
    {
        for (int i = 0; i < line.length(); i++)
        {
            char sym = line.charAt(i);
            if(alphabet.indexOf(sym) == -1)
                return false;
        }

        return true;
    }


    private TokenType classifyToken(final  String token)
    {
        if(token.isEmpty())
            return TokenType.InvalidToken;

        char sym = token.charAt(0);

        if(Character.isDigit(sym))
            return TokenType.Number;

        if(isOperationSign(sym))
            return TokenType.OperationSign;
        else
            return TokenType.InvalidToken;
    }


    public ValidationResult validateLine(String line)
    {
        if(!hasAllowedCharsOnly(line))
            return ValidationResult.InvalidCharDetected;

        String pureLine = line;

        var tokens = tokenize(pureLine);
        if(tokens.length != 3)
            return ValidationResult.UnexpectedTokenCount;

        var token1Type = classifyToken(tokens[0]);
        var token2Type = classifyToken(tokens[1]);
        var token3Type = classifyToken(tokens[2]);

        if(token1Type == TokenType.Number && token2Type == TokenType.OperationSign && token3Type == TokenType.Number)
            return ValidationResult.OK;
        else
            return ValidationResult.InvalidGrammar;
    }


    /*
        public void exec() {
            String sentence = "-123 *345";
            System.out.println("ORG = " + sentence);
            var tokens = tokenize(sentence);

            for (String token : tokens) {
                System.out.println(token);
            }
        }
    */
    private void assure(boolean rv, String hint)
    {
        if(rv)
        {
            System.out.print(hint);
            System.out.println(":\tOK!");
        }
        else
        {
            System.out.print(hint);
            System.out.println(":\tFAILED!");
        }
    }


    public void runTests()
    {
        System.out.println("=== Running test suite ====\n");

        assure( validateLine("123 + 345") == ValidationResult.OK, "Normal line" );
        assure (validateLine("A123+334") == ValidationResult.InvalidCharDetected, "Invalid character detection");
        assure (validateLine("123 + ") == ValidationResult.UnexpectedTokenCount, "Wrong token count detection");
        assure( validateLine("123 1234  +") == ValidationResult.InvalidGrammar, "Incorrect token seq. detection");
        assure( validateLine("/123  1234 ") == ValidationResult.InvalidGrammar, "Incorrect token seq. detection");

        /*
        assure(true, "Always succeeded");
        assure( validAlphaTest(), "Check line having correct alphabet" );
        assure( invalidAlphaTest(), "Check line with wrong char[s]");
        */

    }


    public static void main(String[] args)
    {
        var prog = new Calculate();
        prog.runTests();
    }
}


/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
 */