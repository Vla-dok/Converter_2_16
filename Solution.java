package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
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





