package com.example.constClass;

public interface Helper {
    public static final String ALPHABET_OF_LETTERS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNMЁЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮёйцукенгшщзхъфывапролджэячсмитьбю";
    public static final String ALPHABET_OF_MATH_OPERATIONS_AND_NUM = "0123456789+-/*";
    public static final String ALPHABET_OF_SPECIAL_CHARACTERS = "~`!@#$%^&\"№;:?<>,.";
    public static final String ALPHABET_OF_NUM = "0123456789";
    public static final String ALPHABET_OF_MATH_OPERATIONS = "+-/*";

    static boolean ALPHABET_OF_LETTERS() {
        return true;
    }

    static boolean ALPHABET_OF_SPECIAL_CHARACTERS() {
        return true;
    }
}
