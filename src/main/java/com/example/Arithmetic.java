package com.example;
/**
 * Мини-калькулятор Написать программу, которая будет принимать на вход строку со
 * сложением/вычитанием/умножением или делением двух чисел. Покрыть всевозможные проблемы ввода и
 * выводить в итоге результат операции или текст ошибки. Обязательное условие - использование
 * связки: классы + интерфейс. Пример 1: Вход: 2+2 Выход: 4 Пример 2: Вход 2*К Выход: Введенная
 * строка некорректна (присутствуют необрабатываемые символы)
 * <p>
 * Теоретически покрывает: переменные, типы данных, приведение типов, операции, условный (мб и
 * тернарный) оператор, методы, контексты, наследование (в данном случае имплементацию),
 * взаимоотношение между классами, интерфейсы, работу с методами строковых объектов, исключения На
 * самом деле в зависимости от способа реализации может покрывать как больше аспектов, так и меньше)
 * Все зависит от выбранного способа решения.
 */

import com.example.operations.Operation;
import com.example.validation.Validation;
import java.util.Scanner;

public class Arithmetic extends Validation {

    public static void main(String[] args) {
        Arithmetic arith = new Arithmetic();
        System.out.println("123+334" + ": " + arith.validateVerbose("123+334"));
        System.out.println("12F3+334" + ": " + arith.validateVerbose("A123+334"));
        System.out.println("1+: " + arith.validateVerbose("1+"));
        System.out.println("123 1234  +" + ": " + arith.validateVerbose("123 1234  +"));
        System.out.println("123 1234" + ": " + arith.validateVerbose("123 1234"));
        System.out.println("/123@1234 " + ": " + arith.validateVerbose("/123@1234 "));
        System.out.println("123/1234 " + ": " + arith.validateVerbose("123/1234 "));
        System.out.println("123*1234 " + ": " + arith.validateVerbose("123*1234 "));
        System.out.println("123@1234 " + ": " + arith.validateVerbose("123@1234 "));
        System.out.println("/1231234 " + ": " + arith.validateVerbose("/1231234 "));
    }
}
