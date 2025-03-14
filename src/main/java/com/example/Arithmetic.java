package com.example;
/**
 Мини-калькулятор
 Написать программу, которая будет принимать на вход строку со сложением/вычитанием/умножением или делением двух чисел.
 Покрыть всевозможные проблемы ввода и выводить в итоге результат операции или текст ошибки.
 Обязательное условие - использование связки: классы + интерфейс.
 Пример 1:
 Вход: 2+2
 Выход: 4
 Пример 2:
 Вход 2*К
 Выход: Введенная строка некорректна (присутствуют необрабатываемые символы)

 Теоретически покрывает: переменные, типы данных, приведение типов, операции, условный (мб и тернарный) оператор, методы, контексты, наследование (в данном случае имплементацию), взаимоотношение между классами, интерфейсы, работу с методами строковых объектов, исключения
 На самом деле в зависимости от способа реализации может покрывать как больше аспектов, так и меньше) Все зависит от выбранного способа решения.
 */

import com.example.enumClass.ValidationResult;
import com.example.validation.Parser;
import com.example.validation.Validation;

import java.util.Scanner;

public class Arithmetic extends Validation {

    public static void main(String[] args) {
        String example = "";

        System.out.println(
            "Введите строку по шаблону: Ч О Ч, где Ч - число, а О - знак операции(+,-,/,*). Если вы хотите выйти из программы введите y.");
        Scanner scanner = new Scanner(System.in);

        Validation validation = new Validation();

        while (true) {
            example = scanner.nextLine();
            ValidationResult result = validation.validateLine(example);
            if (example.equals("y")) {
                System.out.println("Программа завершена.");
                break;
            }
            if (result == ValidationResult.OK) {
                String[] tokens = Parser.tokenize(example);
                Calculator calculator = new Calculator();

                double arg1 = Double.parseDouble(tokens[0]);
                double arg2 = Double.parseDouble(tokens[2]);

                int opCode = calculator.getOperation(tokens[1]);

                String rv = calculator.calculate(arg1, arg2, opCode);
                System.out.println(example + " = " + rv);
            } else {

                System.err.println(result.getErrorText());
            }
        }
    }
}