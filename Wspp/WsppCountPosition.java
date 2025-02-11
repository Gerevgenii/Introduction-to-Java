package wspp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public final class WsppCountPosition {
    public static void main(String[] args) {
        final List<WordInLine> allWords = getWordsInFile(Path.of(args[0]));
        final Map<String, List<Position>> analysedWords = analysedWords(allWords);
        writeResult(sortedMap(analysedWords), Path.of(args[1]));
    }

    private static List<Map.Entry<String, List<Position>>> sortedMap(Map<String, List<Position>> analysedWords) {
        final List<Map.Entry<String, List<Position>>> sortedMap = new ArrayList<>(analysedWords.entrySet());
        //noinspection ComparatorMethodParameterNotUsed
        sortedMap.sort((a, b) -> {
            final List<Position> positionsA = a.getValue();
            final List<Position> positionsB = b.getValue();
            if (positionsA.size() > positionsB.size()) {
                return 1;
            } else if (positionsA.size() < positionsB.size()) {
                return -1;
            } else {
                final Position firstPositionA = positionsA.get(0);
                final Position firstPositionB = positionsB.get(0);
                if (firstPositionA.line() > firstPositionB.line()) {
                    return 1;
                } else if (firstPositionA.line() < firstPositionB.line()) {
                    return -1;
                } else {
                    if (firstPositionA.number() > firstPositionB.number()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        return sortedMap;
    }

    private static Map<String, List<Position>> analysedWords(List<WordInLine> allWords) {
        final Map<String, List<Position>> analysedWords = new HashMap<>();
        for (WordInLine wordAndValues : allWords) {
            final String string = wordAndValues.string();
            final Position position = wordAndValues.position();
            if (analysedWords.containsKey(string)) {
                analysedWords.get(string).add(position);
            } else {
                final List<Position> list = new ArrayList<>();
                list.add(position);
                analysedWords.put(string, list);
            }
        }
        return analysedWords;
    }

    private static List<WordInLine> getWordsInFile(Path input) {
        final List<WordInLine> allWords = new ArrayList<>();
        final Predicate<Character> linePredicate = character -> !System.lineSeparator().contains(String.valueOf(character));
        try (Scanner scanner = new Scanner(Files.newBufferedReader(input, StandardCharsets.UTF_8), linePredicate)) {
            String line = scanner.next();
            int lineNumber = 0;
            while (line != null) {
                lineNumber++;
                final List<String> wordsInLine = createWords(line);
                for (int i = 0; i < wordsInLine.size(); i++) {
                    allWords.add(new WordInLine(wordsInLine.get(i), new Position(lineNumber, i + 1)));
                }
                line = scanner.next();
            }
        } catch (IOException e) {
            System.out.println("Ошибка во время чтения файла" + e.getMessage());
        }
        return allWords;
    }

    private static List<String> createWords(String line) {
        StringBuilder word = new StringBuilder();
        final List<String> wordsInLine = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            final char charAt = line.charAt(i);
            if (Character.isLetter(charAt) || Character.DASH_PUNCTUATION == Character.getType(charAt) || charAt == '\'') {
                word.append(charAt);
            } else {
                final String wordString = word.toString().toLowerCase();
                if (!wordString.isEmpty()) {
                    wordsInLine.add(wordString);
                    word = new StringBuilder();
                }
            }
        }
        final String wordString = word.toString().toLowerCase();
        if (!wordString.isEmpty()) {
            wordsInLine.add(wordString);
        }
        return wordsInLine;
    }

    private static void writeResult(List<Map.Entry<String, List<Position>>> allWords, Path output) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {
            for (Map.Entry<String, List<Position>> hel : allWords) {
                final List<Position> positions = hel.getValue();
                final StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(hel.getKey()).append(' ').append(positions.size()).append(' ');
                for (int i = 0; i < positions.size(); i++) {
                    stringBuilder.append(positions.get(i));
                    if (i != positions.size() - 1) {
                        stringBuilder.append(' ');
                    }
                }
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка во время записи файла" + e.getMessage());
        }
    }
}
