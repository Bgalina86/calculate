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
