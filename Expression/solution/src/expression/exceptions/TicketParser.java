package expression.exceptions;

import static expression.exceptions.Ticket.convertToKeyWord;

public class TicketParser {
    private final CharSource source;
    private char oldChr;
    private char chr;
    private Ticket nextTicket;
    private Ticket oldTicket;

    public TicketParser(CharSource source) throws TicketParserException {
        this.source = source;
        this.nextTicket = nextTicket();
        chr = 0;
        oldChr = 0;
    }

    public Ticket touchNextTicket() throws TicketParserException {
        if (nextTicket != null) {
            return nextTicket;
        } else {
            throw new TicketParserException("Program hasn't next ticket.");
        }
    }

    public boolean hasNext() {
        return nextTicket != null;
    }

    public Ticket next() throws TicketParserException {
        oldTicket = nextTicket;
        if (hasNext()) {
            nextTicket = nextTicket();
        } else {
            throw new TicketParserException("Would you like call hasNext(), because this line haven't new char. " +
                                            "If you don't understand, try to stop programming java and learn Python instead.");
        }
        return oldTicket;
    }

    private Ticket nextTicket() throws TicketParserException {
        while (source.hasNext()) {
            oldChr = chr;
            chr = source.next();

            if (Character.isWhitespace(chr)) {
                continue;
            }
            if (chr == '(' || chr == '*' || chr == '/' || chr == ')' || chr == 'x' || chr == 'y' || chr == 'z') {
                return convertToKeyWord(chr);
            }
            if (chr == 's' || chr == 'c') {
                if (oldTicket instanceof NumberTicket) {
                    if (oldChr == ' ') {
                        return parseSetOrClear(chr);
                    } else {
                        throw new TicketParserException("Your set hasn't ' '");
                    }
                }
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
            throw new TicketParserException("Your ticket is illegal. Because we don't support your character. " + chr);
        }
        return null;
    }

    private KeyWord parseSetOrClear(char chr) throws TicketParserException {
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
        throw new TicketParserException("Your clear is not clear, maybe you write 'clea' or 'cl' or 'c'...");
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
