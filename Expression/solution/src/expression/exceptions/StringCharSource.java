package expression.exceptions;

import java.util.NoSuchElementException;

public class StringCharSource implements CharSource {
    private final String source;
    private int pos = -1;
    public StringCharSource(String string) {
        this.source = string;
    }

    @Override
    public char next() {
        requireHasNext();
        pos++;
        return source.charAt(pos);
    }

    private void requireHasNext() {
        if (!hasNext()) {
            throw new NoSuchElementException("Would you like call hasNext(), because this line haven't new char. " +
                                             "If you don't understand, try to stop programming java and learn Python instead.");
        }
    }

    @Override
    public char touch() {
        requireHasNext();
        return source.charAt(pos + 1);
    }

    @Override
    public boolean hasNext() {
        return pos + 1 < source.length();
    }
}
