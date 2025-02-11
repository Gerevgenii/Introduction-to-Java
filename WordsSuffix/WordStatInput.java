package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;


public class WordStatInput {
    public static void main(String[] args) {
        ArrayList<String> allWords = new ArrayList<>();
        int[] countWords = new int[1];
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of(args[0]), StandardCharsets.UTF_8)) {
            String line = bufferedReader.readLine();
            StringBuilder word = new StringBuilder();
            int count = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++)
                    if (Character.isLetter(line.charAt(i)) || Character.DASH_PUNCTUATION == Character.getType(line.charAt(i)) || line.charAt(i) == '\'') {
                        word.append(line.charAt(i));
                    } else {
                        String wordString = word.toString().toLowerCase();
                        if (!wordString.isBlank()) {
                            if (allWords.contains(wordString)) {
                                countWords[allWords.indexOf(wordString)]++;
                            } else {
                                if (countWords.length == count) {
                                    countWords = Arrays.copyOf(countWords, countWords.length * 2);
                                }
                                allWords.add(wordString);
                                countWords[count] = 1;
                                count++;
                            }
                            word = new StringBuilder();
                        }
                    }
                String wordString = word.toString().toLowerCase();
                if (!wordString.isBlank()) {
                    if (allWords.contains(wordString)) {
                        countWords[allWords.indexOf(wordString)]++;
                    } else {
                        if (countWords.length == count)
                            countWords = Arrays.copyOf(countWords, countWords.length * 2);
                        allWords.add(wordString);
                        countWords[count] = 1;
                        count++;
                    }
                    word = new StringBuilder();
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка во время чтения файла");
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(args[1]), StandardCharsets.UTF_8)) {
            for (int i = 0; i < allWords.size(); i++) {
                bufferedWriter.write(allWords.get(i) + ' ' + countWords[i]);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка во время записи файла");
        }
    }
}
