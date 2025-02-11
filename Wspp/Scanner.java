package wspp;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.function.Predicate;

public class Scanner implements Closeable {

    private final Reader reader;

    private String nextWord;
    private StringBuilder currentSB = new StringBuilder();
    private final Predicate<Character> isTrueCharacter;

    public Scanner(Reader reader, Predicate<Character> isTrueCharacter) throws IOException {
        this.reader = reader;
        this.isTrueCharacter = isTrueCharacter;

        final String nextPart = nextPart();
        if (nextPart == null) {
            throw new IOException("Reader haven`t data");
        }
        currentSB.append(nextPart);

        nextWord = getNextWord();
    }

    private String nextPart() throws IOException {
        final CharBuffer charBuffer = CharBuffer.allocate(10);
        if (reader.read(charBuffer) == -1) {
            return null;
        }
        return charBuffer.flip().toString();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    public boolean hasNext() throws IOException {
        return nextWord != null;
    }

    public String next() throws IOException {
        final String word = nextWord;

        nextWord = getNextWord();
        return word;
    }

    public String getNextWord() throws IOException {
        final StringBuilder wordSB = new StringBuilder();
        for (int i = 0; i <= currentSB.length(); i++) {
            if (i == currentSB.length()) {
                final String nextPart = nextPart();
                if (nextPart == null) {
                    if (currentSB.isEmpty()) {
                        return null;
                    } else {
                        currentSB = new StringBuilder(
                                currentSB.substring(i)
                        );
                        final String s = wordSB.toString();
                        wordSB.setLength(0);
                        return s;
                    }
                }
                currentSB.append(nextPart);
            }
            final char chr = currentSB.charAt(i);
            if (chr == '\r') continue;
            if (isTrueCharacter.test(chr)) {
                wordSB.append(chr);
            } else {
                currentSB = new StringBuilder(
                        currentSB
                                .substring(i + 1)
                );
                final String s = wordSB.toString();
                wordSB.setLength(0);
                return s;
            }
        }

        throw new IOException("Haven't int in your input");
    }
}