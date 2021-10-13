package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
Публичный статический метод toHex(String) должен переводить строковое представление двоичного числа, полученное в качестве входящего параметра, из двоичной системы счисления в шестнадцатеричную и возвращать его строковое представление. А публичный статический метод toBinary(String) наоборот — из строкового представления шестнадцатеричного числа в строковое представление двоичного числа.

Методы работают только с не пустыми строками.
Если входящий параметр — пустая строка или null, то оба метода возвращают пустую строку.
Если входящий параметр метода toHex(String) содержит любой символ, кроме 0 или 1, то метод возвращает пустую строку.
Если входящий параметр метода toBinary(String) содержит любой символ, кроме цифр от 0 до 9 или латинскую букву от a до f (в нижнем регистре), то метод возвращает пустую строку.

Твоя задача — реализовать эти методы.

Один из алгоритмов перевода строкового представления двоичного числа в строковое представление шестнадцатеричного числа следующий:

Проверяем длину строки, полученной входящим параметром. Она должна быть кратна 4.
Если это не так, то добавляем нужное количество 0 в начало строки.
Берем каждые четыре символа (бита) и проверяем, какому символу шестнадцатеричной кодировки он соответствует.
Например:

двоичное представление — "100111010000", где "1001" — "9", "1101" — "d", "0000" — "0",
шестнадцатеричное представление — "9d0".
Один из алгоритмов перевода строкового представления шестнадцатеричного числа в строковое представление двоичного числа следующий:
Берем каждый символ и проверяем какому двоичному числу (4 бита) он соответствует.

Например:

шестнадцатеричное представление — "9d0", где "9" — "1001", "d" — "1101", "0" — "0000",
двоичное представление — "100111010000".
Метод main() не принимает участие в тестировании.


Requirements:
1. Нужно, чтобы метод toHex(String) был реализован согласно условию.
2. Нужно, чтобы метод toBinary(String) был реализован согласно условию.
3. Методы Integer.toBinaryString(int) и Long.toBinaryString(int) использовать нельзя.
4. Методы Integer.toHexString(int) и Long.toHexString(int) использовать нельзя.
5. Методы Integer.parseInt(String, int) и Long.parseLong(String, int) использовать нельзя.
6. Методы Integer.toString(int, int) и Long.toString(long, int) использовать нельзя.
7. Объект типа BigInteger использовать нельзя.
8. Объект типа BigDecimal использовать нельзя.
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        //напишите тут ваш код
        if (binaryNumber == null || binaryNumber.isEmpty() || !Pattern.matches("[0-1]+", binaryNumber))
            return "";
        while (binaryNumber.length() % 4 != 0) binaryNumber = 0 + binaryNumber;

        int decimalNumber1 = 0;
        String hexNumber1 = "";
        final String HEX = "0123456789abcdef";
        int i = 0;
        while (i < binaryNumber.length()) {
            String binaryNumber1 = binaryNumber.substring(i, i + 4);
            for (int h = 0; h < binaryNumber1.length(); h++) {
                int index = binaryNumber1.length() - 1 - h;
                int value = Character.getNumericValue(binaryNumber1.charAt(index));
                decimalNumber1 = decimalNumber1 + (int) (value * Math.pow(2, h));
            }
            hexNumber1 = hexNumber1 + HEX.charAt(decimalNumber1);
            decimalNumber1 = decimalNumber1 / 16;
            i = i + 4;
        }
        return hexNumber1;
    }


    public static String toBinary(String hexNumber) {
        //напишите тут ваш код
        if (hexNumber == null || hexNumber.isEmpty() || !Pattern.matches("[0-9a-f]+", hexNumber)) return "";
        final String HEX = "0123456789abcdef";
        int decimalNumber = 0;
        String binaryNumber = "";
        for (int i = 0; i < hexNumber.length(); i++) {
            char index =  hexNumber.charAt(i);
            decimalNumber = 16 * decimalNumber + HEX.indexOf(index);
        }
        while (decimalNumber > 0)
        {binaryNumber = (decimalNumber%2) + binaryNumber;
            decimalNumber = decimalNumber / 2;}
        return binaryNumber;
    }
}





