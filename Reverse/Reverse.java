package org.example;

import java.util.Arrays;
import java.util.Scanner;

record LineWithLength(int[] line, int length) {

}

public class Reverse {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int[][] lines = new int[1][];
        int[] lengths = new int[1];
        int sumOfLengths = 0;
        while (scanner.hasNextLine()) {
            final LineWithLength a = parseLine(scanner.nextLine());
            lines[sumOfLengths] = a.line();
            lengths[sumOfLengths] = a.length();
            if (lines.length - 1 == sumOfLengths) {
                lines = Arrays.copyOf(lines, lines.length + 1);
                lengths = Arrays.copyOf(lengths, lengths.length + 1);
            }
            sumOfLengths++;
        }
        printString(sumOfLengths, lengths, lines);
    }

    private static void printString(int allArrLen, int[] lengths, int[][] allArr) {
        for (int i = allArrLen - 1; i >= 0; i--) {
            for (int j = lengths[i] - 1; j >= 0; j--) {
                if (j != lengths[i] - 1)
                    System.out.print(' ');
                System.out.print(allArr[i][j]);
            }
            System.out.println();
        }
    }

    private static LineWithLength parseLine(String string) {
        final Scanner scanner = new Scanner(string);
        int[] line = new int[1];
        int lastIndex = 0;
        while (scanner.hasNextInt()) {
            line[lastIndex] = scanner.nextInt();
            if (line.length - 1 == lastIndex)
                line = Arrays.copyOf(line, line.length * 2);
            lastIndex++;
        }
        return new LineWithLength(line, lastIndex);
    }
}