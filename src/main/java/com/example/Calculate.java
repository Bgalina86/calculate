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

import com.example.enumClass.ValidationResult;
import com.example.validation.Validation;

class Calculate extends Validation {

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
        assure (validateLine("A123+334") == ValidationResult.Error_InvalidCharDetected, "Invalid character detection");
        assure (validateLine("123 + ") == ValidationResult.Error_UnexpectedTokenCount, "Wrong token count detection");
        assure( validateLine("123 1234  +") == ValidationResult.Error_InvalidGrammar, "Incorrect token seq. detection");
        assure( validateLine("/123@1234 ") == ValidationResult.Error_InvalidGrammar, "Incorrect token seq. detection");
        assure( validateLine("123/1234 ") == ValidationResult.OK, "Normal line");
        assure( validateLine("123*1234 ") == ValidationResult.OK, "Normal line");
        assure( validateLine("12c31234 ") == ValidationResult.Error_InvalidGrammar, "Incorrect token seq. detection");
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
