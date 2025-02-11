package expression.parser;

import java.util.NoSuchElementException;

import static expression.parser.Ticket.convertToKeyWord;

public class TicketParser {
    private final CharSource source;
    private Ticket nextTicket;
    private Ticket oldTicket;

    public TicketParser(CharSource source) {
        this.source = source;
        this.nextTicket = nextTicket();
    }

    public Ticket touchNextTicket() {
        return nextTicket;
    }

    public boolean hasNext() {
        return nextTicket != null;
    }

    public Ticket next() {
        oldTicket = nextTicket;
        if (hasNext()) {
            try {
                nextTicket = nextTicket();
            } catch (NoSuchElementException e) {
                nextTicket = null;
            }
        } else {
            throw new NoSuchElementException("Would you like call hasNext(), because this line haven't new char. " +
                                             "If you don't understand, try to stop programming java and learn Python instead.");
        }
        return oldTicket;
    }

    private Ticket nextTicket() {
        while (source.hasNext()) {
            final char chr = source.next();
            if (Character.isWhitespace(chr)) {
                continue;
            }
            if (chr == '(' || chr == '*' || chr == '/' || chr == ')' || chr == 'x' || chr == 'y' || chr == 'z') {
                return convertToKeyWord(chr);
            }
            if (chr == 's' || chr == 'c') {
                return parseSetOrClear(chr);
            }
            if (chr == '+' || chr == '-') {
                if (isDigit() && (
                        oldTicket == null || !(
                                oldTicket.equals(KeyWord.X) || oldTicket.equals(KeyWord.Y) ||
                                oldTicket.equals(KeyWord.Z) || oldTicket.equals(KeyWord.RIGHT_BRACKET) ||
                                oldTicket instanceof NumberTicket
                        ))) {
                    return new NumberTicket(parseInteger(chr));
                }
                return convertToKeyWord(chr);
            }
            if (Character.isDigit(chr)) {
                return new NumberTicket(parseInteger(chr));
            }
        }
        throw new NoSuchElementException("Your text haven't any tickets");
    }

    private KeyWord parseSetOrClear(char chr) {
        if (chr == 'c') {
            if (source.touch() == 'l') {
                source.next();
                if (source.touch() == 'e') {
                    source.next();
                    if (source.touch() == 'a') {
                        source.next();
                        if (source.touch() == 'r') {
                            source.next();
                            return KeyWord.CLEAR;
                        }
                    }
                }
            }
        } else if (chr == 's') {
            if (source.touch() == 'e') {
                source.next();
                if (source.touch() == 't') {
                    source.next();
                    return KeyWord.SET;
                }
            }
        }
        throw new IllegalStateException("Your clear is not clear, maybe you write 'clea' or 'cl' or 'c'...");
    }

    private int parseInteger(char chr) {
        final StringBuilder stringBuilder = new StringBuilder().append(chr);
        while (source.hasNext() && isDigit()) {
            stringBuilder.append(source.next());
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    private boolean isDigit() {
        return Character.isDigit(source.touch());
    }
}
