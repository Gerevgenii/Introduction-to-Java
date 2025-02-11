package wspp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;


public final class Wspp {
    public static void main(String[] args) {
        final Map<String, IntList> wordsMap = new LinkedHashMap<>();
        final Predicate<Character> linePredicate = character -> !System.lineSeparator().contains(String.valueOf(character));
        try (Scanner scanner = new Scanner(Files.newBufferedReader(Path.of(args[0]), StandardCharsets.UTF_8), linePredicate)) {
            String line = scanner.next();
            StringBuilder word = new StringBuilder();
            int count = 0;
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    final char charAt = line.charAt(i);
                    if (Character.isLetter(charAt) || Character.DASH_PUNCTUATION == Character.getType(charAt) || charAt == '\'') {
                        word.append(charAt);
                    } else {
                        final String wordString = word.toString().toLowerCase();
                        if (!wordString.isEmpty()) {
                            count++;
                            final IntList indexes;
                            if (wordsMap.containsKey(wordString)) {
                                indexes = wordsMap.get(wordString);
                            } else {
                                indexes = new IntList(new int[1]);
                            }
                            indexes.add(count);
                            wordsMap.put(wordString, indexes);
                            word = new StringBuilder();
                        }
                    }
                }
                final String wordString = word.toString().toLowerCase();
                if (!wordString.isEmpty()) {
                    count++;
                    final IntList indexes;
                    if (wordsMap.containsKey(wordString)) {
                        indexes = wordsMap.get(wordString);
                    } else {
                        indexes = new IntList(new int[1]);
                    }
                    indexes.add(count);
                    wordsMap.put(wordString, indexes);
                    word = new StringBuilder();
                }
                line = scanner.next();
            }
        } catch (IOException e) {
            System.out.println("Ошибка во время чтения файла");
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(args[1]), StandardCharsets.UTF_8)) {
            for (var entry: wordsMap.entrySet()) {
                final String word = entry.getKey();
                final IntList indexes = entry.getValue();
//                System.out.println(word + ' ' + indexes.size() + ' ' + indexes);
                bufferedWriter.write(word + ' ' + indexes.size() + ' ' + indexes);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка во время записи файла");
        }
    }
}