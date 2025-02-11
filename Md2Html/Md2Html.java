package md2html;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public final class Md2Html {

    private static BufferedWriter bufferedWriter;
    private static Map<String, Integer> stringIntegerMap;

    public static void main(String[] args) {
        try {
            final Path input = Path.of(args[0]);
            final Path output = Path.of(args[1]);
            final List<List<String>> allBlocks = allBlocks(input);
            bufferedWriter = Files.newBufferedWriter(output, StandardCharsets.UTF_8);
            print(allBlocks);
        } catch (IOException e) {
            System.out.println("Ошибка во время записи файла" + e.getMessage());
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Ошибка во время закрытии файла" + e.getMessage());
            }
        }
    }

    public static List<List<String>> allBlocks(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            final List<List<String>> allBlock = new ArrayList<>();

            String line = bufferedReader.readLine(); // Читаем линию
            List<String> currentBlock = new ArrayList<>(); // Создаём массив одного блока
            while (line != null) { // Пока файл не кончится, делаем
                /* Если та строка, которую мы прочитали не пустая, то кладём блок в массив блоков */
                if (!line.isEmpty()) {
                    currentBlock.add(line);
                } else {
                    if (!currentBlock.isEmpty()) {
                        allBlock.add(currentBlock);
                    }
                    currentBlock = new ArrayList<>();
                }
                line = bufferedReader.readLine();
            }
            if (!currentBlock.isEmpty()) {
                allBlock.add(currentBlock);
            }

            return allBlock;
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return List.of();
    }

    public static List<String> analysedBlocks(List<String> block) {
        stringIntegerMap = new HashMap<>();
        final List<String> analysedBlock = new ArrayList<>();
        for (int j = 0; j < block.size(); j++) {
            final String string = block.get(j);
            StringBuilder element = new StringBuilder();
            StringBuilder badChr = new StringBuilder();
            final Set<String> whiteList = Set.of("*", "_", "-", "`", "<", ">", "&", "+");
            for (int i = 0; i < string.length(); i++) {
                final char symbol = string.charAt(i);
                final String valueOf = String.valueOf(symbol);

                if (whiteList.contains(valueOf)) {
                    if ((i != 0) && (symbol != string.charAt(i - 1)) && (!element.isEmpty())) {

                        analysedBlock.add(element.toString());
                        stringIntegerMap.merge(element.toString(), 1, Integer::sum);
                        element = new StringBuilder();
                    }
                    element.append(symbol);
                    if (!badChr.isEmpty()) {
                        analysedBlock.add(badChr.toString());
                        badChr = new StringBuilder();
                    }
                } else if (symbol == '\\') {
                    if (i != string.length() - 1) {
                        if (!badChr.isEmpty()) {
                            analysedBlock.add(badChr.toString());
                            badChr = new StringBuilder();
                        }
                        if (!element.isEmpty()) {
                            analysedBlock.add(element.toString());
                            stringIntegerMap.merge(element.toString(), 1, Integer::sum);
                            element = new StringBuilder();
                        }
                        final char chr = string.charAt(i + 1);

                        element.append("\\").append(chr);
                        analysedBlock.add(element.toString());
                        stringIntegerMap.merge(element.toString(), 1, Integer::sum);
                        element = new StringBuilder();
                        //noinspection AssignmentToForLoopParameter
                        i++;

                    }
                } else if (!System.lineSeparator().contains(valueOf)) {
                    badChr.append(symbol);
                    if (!element.isEmpty()) {
                        analysedBlock.add(element.toString());
                        stringIntegerMap.merge(element.toString(), 1, Integer::sum);
                        element = new StringBuilder();
                    }
                }

            }
            if (!badChr.isEmpty()) {
                analysedBlock.add(badChr.toString());
            }
            if (!element.isEmpty()) {
                analysedBlock.add(element.toString());
                stringIntegerMap.merge(element.toString(), 1, Integer::sum);
            }
            if (j != block.size() - 1) {
                analysedBlock.add("\n");
            }
        }
        return analysedBlock;
    }

    public static void print(List<List<String>> allBlocks) {
        for (final List<String> block : allBlocks) {
            final String firstString = block.get(0);
            if (firstString.charAt(0) == '#') {
                int count = 0;
                for (int i = 0; i < 8; i++) {
                    final char symbol = firstString.charAt(i);
                    if (symbol == '#') {
                        count++;
                    } else if (Character.isWhitespace(symbol)) {
                        printParagraph(block, count);
                        break;
                    } else {
                        writeInFile("<p>");
                        printAnalysedBlock(analysedBlocks(block));
                        writeInFile("</p>" + "\n");
                        break;
                    }
                }
            } else {
                writeInFile("<p>");
                printAnalysedBlock(analysedBlocks(block));
                writeInFile("</p>" + "\n");
            }
        }
    }

    public static void printParagraph(List<String> analysedBlock, int count) {
        final String firstString = analysedBlock.get(0);
        analysedBlock.set(0, firstString.substring(count + 1));
        writeInFile("<h" + count + ">");
        printAnalysedBlock(analysedBlocks(analysedBlock));
        writeInFile("</h" + count + ">" + "\n");
    }

    public static void printAnalysedBlock(List<String> analysedBlock) {
        int halfA = 0, halfB = 0, halfC = 0, halfD = 0, halfE = 0, halfF = 0, halfG = 0;
        for (int i = 0; i < analysedBlock.size(); i++) {
            final String pieceString = analysedBlock.get(i);
            switch (pieceString) {
                case "\\*" -> writeInFile("*");
                case "\\_" -> writeInFile("_");
                case "\\-" -> writeInFile("-");
                case "\\'" -> writeInFile("'");
                case "\\<" -> writeInFile("<");
                case "\\>" -> writeInFile(">");
                case "\\&" -> writeInFile("&");
                case "\\+" -> writeInFile("+");
                case "*" -> {
                    final int count = counter("*");
                    if (count == 0) {
                        writeInFile(pieceString);
                    } else {
                        replace(count, halfA, "<em>", "</em>");
                        halfA++;
                    }
                }
                case "**" -> {
                    final int count = counter("**");
                    if (count == 0) {
                        writeInFile(pieceString);
                    } else {
                        replace(count, halfB, "<strong>", "</strong>");
                        halfB++;
                    }
                }
                case "++" -> {
                    final int count = counter("++");
                    if (count == 0) {
                        writeInFile(pieceString);
                    } else {
                        replace(count, halfG, "<u>", "</u>");
                        halfG++;
                    }
                }
                case "`" -> {
                    final int count = counter("`");
                    if (count == 0) {
                        writeInFile(pieceString);
                    } else {
                        replace(count, halfC, "<code>", "</code>");
                        halfC++;
                    }
                }
                case "_" -> {
                    final int count = counter("_");
                    if (count == 0) {
                        writeInFile(pieceString);
                    } else {
                        replace(count, halfD, "<em>", "</em>");
                        halfD++;
                    }
                }
                case "__" -> {
                    final int count = counter("__");
                    if (count == 0) {
                        writeInFile(pieceString);
                    } else {
                        replace(count, halfE, "<strong>", "</strong>");
                        halfE++;
                    }
                }
                case "--" -> {
                    final int count = counter("--");
                    if (count == 0) {
                        writeInFile(pieceString);
                    } else {
                        replace(count, halfF, "<s>", "</s>");
                        halfF++;
                    }
                }
                case "<" -> writeInFile("&lt;");
                case ">" -> writeInFile("&gt;");
                case "&" -> writeInFile("&amp;");
                default -> writeInFile(pieceString);
            }
        }
    }

    private static int counter(String x) {
        int count = stringIntegerMap.getOrDefault(x, 1);
        if (count % 2 != 0) {
            count--;
        }
        return count;
    }

    private static void replace(int count, int position, String startReplace, String endReplace) {
        if (position % 2 == count % 2) {
            writeInFile(startReplace);
        } else {
            writeInFile(endReplace);
        }

    }

    private static void writeInFile(String string) {
        try {
            bufferedWriter.write(string);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла" + e.getMessage());
        }
    }
}