package org.example;

import static java.lang.Character.isDigit;

public class Sum {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.print(0);
            return;
        }
        int sum = 0;
        for (String arg : args) {
            if (arg.isBlank())
                continue;
            String number = ""; //Намеренно не использую StringBuilder
            for (int i = 0; i < arg.length(); i++) {
                final char symbol = arg.charAt(i);
                //noinspection ImplicitNumericConversion
                if (isDigit(symbol) || symbol == '+' || symbol == '-') {
                    //noinspection StringConcatenationInLoop
                    number += symbol;
                } else {
                    if (!number.isBlank())
                        sum += Integer.parseInt(number);
                    number = "";
                }
            }
            if (!number.isBlank())
                sum += Integer.parseInt(number);
        }
        System.out.println(sum);
    }
}