package org.example;

public class SumDouble {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.print(0);
            return;
        }
        Double sum = 0.0;
        for (String arg : args) {
            if (arg.isBlank())
                continue;
            StringBuilder number = new StringBuilder();
            for (int i = 0; i < arg.length(); i++) {
                final char symbol = arg.charAt(i);
                if (!Character.isWhitespace(symbol))
                    number.append(symbol);
                else {
                    if (!number.toString().isBlank())
                        sum += Double.parseDouble(number.toString());
                    number = new StringBuilder();
                }
            }
            if (!number.toString().isBlank())
                sum += Double.parseDouble(number.toString());
        }
        System.out.println(sum);
    }
}