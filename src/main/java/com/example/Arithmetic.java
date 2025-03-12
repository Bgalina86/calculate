package com.example;
/**
 * ����-����������� �������� ���������, ������� ����� ��������� �� ���� ������ ��
 * ���������/����������/���������� ��� �������� ���� �����. ������� ������������ �������� ����� �
 * �������� � ����� ��������� �������� ��� ����� ������. ������������ ������� - �������������
 * ������: ������ + ���������. ������ 1: ����: 2+2 �����: 4 ������ 2: ���� 2*� �����: ���������
 * ������ ����������� (������������ ���������������� �������)
 * <p>
 * ������������ ���������: ����������, ���� ������, ���������� �����, ��������, �������� (�� �
 * ���������) ��������, ������, ���������, ������������ (� ������ ������ �������������),
 * ��������������� ����� ��������, ����������, ������ � �������� ��������� ��������, ���������� ��
 * ����� ���� � ����������� �� ������� ���������� ����� ��������� ��� ������ ��������, ��� � ������)
 * ��� ������� �� ���������� ������� �������.
 */

import com.example.operations.Operation;
import com.example.validation.Validation;
import java.util.Scanner;

public class Arithmetic extends Validation {

    public static void main(String[] args) {
        System.out.println(
            "Введите строку по шаблону: Ч О Ч, где Ч - число, а О - знак операции(+,-,/,*). Если вы хотите выйти из программы введите y.");
        Scanner scanner = new Scanner(System.in);
        String enter = "";
        while (true) {
            enter = scanner.nextLine();
            if (enter.equals("y")) {
                System.out.println("Программа завершена.");
                break;
                /**
                 * Проверяем корректность введенной строки. Вычисляем ее значение
                 */
               // if (validateString(enter)) {

               // }
            }
        }

    }
static Calculator parseOperation(String expression){
    Operation operation = null;
    String[] numbers = expression.split("[\\+\\-\\/*]");
    Calculator calculator = new Calculator();
        return calculator;
}

    public void validateStringTest(String[] args) {
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
