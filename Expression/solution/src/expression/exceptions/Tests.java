package expression.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Tests {
    @Test
    public void nextChar() {
        final CharSource stringCharSource = new StringCharSource("1234");
        Assertions.assertEquals('1', stringCharSource.next());
        Assertions.assertEquals('2', stringCharSource.touch());
        Assertions.assertEquals('2', stringCharSource.next());
        Assertions.assertEquals('3', stringCharSource.next());
        Assertions.assertEquals('4', stringCharSource.next());
        assertFalse(stringCharSource.hasNext());
    }

    @Test
    public void ticketParserTest() throws TicketParserException {
        Assertions.assertThrows(
                TicketParserException.class,
                () -> new ExpressionParser().parse("(0 A+ 0)")
        );
        assertParsesTo(" 10 / 23 + 321 + (123 - 12)", 10, '/', 23, '+', 321, '+', '(', 123, '-', 12, ')');
        Assertions.assertEquals(new NumberTicket(10), new TicketParser(new StringCharSource(" 10 / 23 + 321 + (123 - 12)")).next());
        assertParsesTo(" 10/23+321+(123-12)", 10, '/', 23, '+', 321, '+', '(', 123, '-', 12, ')');
        assertParsesTo("x", 'x');
        assertParsesTo("x+2", 'x', '+', 2);
        Assertions.assertThrows(
                TicketParserException.class,
                () -> {
                    new ExpressionParser().parse("(0) + 0)");
                }
        );
    }

    @Test
    public void modification() throws TicketParserException {
        assertParsesTo("(0 clear 0)", '(', 0, "clear", 0, ')');

        assertEquals(new Clear(new Const(0), new Const(0)), new ExpressionParser().parse("(0 clear 0)"));
    }


    private static void assertParsesTo(String string, Object... expectedTickets) throws TicketParserException {
        final TicketParser ticketParser = new TicketParser(new StringCharSource(string));
        for (Object expectedTicket : expectedTickets) {
            if (ticketParser.hasNext()) {
                Assertions.assertEquals(expectedTicket instanceof Integer integer ?
                        new NumberTicket(integer) : (expectedTicket instanceof String stringa ?
                        Ticket.convertToKeyWord(stringa) : Ticket.convertToKeyWord((char) expectedTicket)), ticketParser.next());
            } else {
                throw new AssertionFailedError("Error");
            }
        }
    }
}