package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseTranspose {
    private record LineWithLength(int[] line, int length) {

    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int[][] lines = new int[1][];
        int[] lengths = new int[1];
        int maxLength = 0;
        int sumOfLengths = 0;
        while (scanner.hasNextLine()) {
            final LineWithLength a = parseLine(scanner.nextLine());
            lines[sumOfLengths] = a.line();
            lengths[sumOfLengths] = a.length();
            maxLength = Math.max(maxLength, a.length());
            if (lines.length - 1 == sumOfLengths) {
                lines = Arrays.copyOf(lines, lines.length + 1);
                lengths = Arrays.copyOf(lengths, lengths.length + 1);
            }
            sumOfLengths++;
        }
        printString(maxLength, sumOfLengths, lengths, lines);
    }

    private static void printString(int maxLength, int sumOfLengths, int[] lengths, int[][] array) {
        for (int i = 0; i < maxLength; i++) {
            int k = 0;
            for (int j = 0; j < sumOfLengths; j++)
                if (i < lengths[j]) {
                    if (k != 0 && lengths[j] != 0)
                        System.out.print(" ");
                    System.out.print(array[j][i]);
                    k++;
                }
            System.out.println();
        }
    }

    private static LineWithLength parseLine(String string) {
        final Scanner scanner = new Scanner(string);
        int[] array = new int[1];
        int lastIndex = 0;
        while (scanner.hasNextInt()) {
            array[lastIndex] = scanner.nextInt();
            if (array.length - 1 == lastIndex) {
                array = Arrays.copyOf(array, array.length * 2);
            }
            lastIndex++;
        }
        return new LineWithLength(array, lastIndex);
    }
}