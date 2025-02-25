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

class CalculateNew extends Validation {

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


    public void runTests(){

        System.out.println("=== Running test suite ====\n");

        assure( validateLine("123 + 345") == ValidationResult.OK, "1. Normal line - 123 + 345" );
        assure (validateLine("A123+334") == ValidationResult.Error_InvalidCharDetected, "2. Invalid character detection - A123+334");
        assure (validateLine("1 + ") == ValidationResult.Error_NoStringLength, "3. Wrong token count detection - 123 + ");
        assure( validateLine("123 1234  +") == ValidationResult.Error_InvalidGrammar, "4. Incorrect token seq. detection - 123 1234  +");
        assure( validateLine("/123@1234 ") == ValidationResult.Error_InvalidGrammar, "5. Incorrect token seq. detection - /123@1234 ");
        assure( validateLine("123/1234 ") == ValidationResult.OK, "6. Normal line - 123/1234 ");
        assure( validateLine("123*1234 ") == ValidationResult.OK, "7. Normal line - 123*1234 ");
        assure( validateLine("12c31234 ") == ValidationResult.Error_InvalidGrammar, "8. Incorrect token seq. detection - 12c31234 ");

        /*
        assure(true, "Always succeeded");
        assure( validAlphaTest(), "Check line having correct alphabet" );
        assure( invalidAlphaTest(), "Check line with wrong char[s]");
        */

    }



    public static void main(String[] args)
    {
        var prog = new CalculateNew();
        prog.runTests();
    }
}
