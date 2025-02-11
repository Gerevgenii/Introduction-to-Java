package expression.parser;

import expression.Clear;
import expression.Const;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void ticketParserTest() {
        Assertions.assertEquals(new NumberTicket(10), new TicketParser(new StringCharSource(" 10 / 23 + 321 + (123 - 12)")).next());
        assertParsesTo(" 10 / 23 + 321 + (123 - 12)", 10, '/', 23, '+', 321, '+', '(', 123, '-', 12, ')');
        assertParsesTo(" 10/23+321+(123-12)", 10, '/', 23, '+', 321, '+', '(', 123, '-', 12, ')');
        assertParsesTo("x", 'x');
        assertParsesTo("x+2", 'x', '+', 2);
    }

    @Test
    public void modification() {
        assertParsesTo("(0 clear 0)", '(' , 0, "clear", 0, ')');

        assertEquals(new Clear(new Const(0), new Const(0)), new ExpressionParser().parse("(0 clear 0)"));
    }


    private static void assertParsesTo(String string, Object... expectedTickets) {
        final TicketParser ticketParser = new TicketParser(new StringCharSource(string));
        for (Object expectedTicket : expectedTickets) {
            Assertions.assertEquals(expectedTicket instanceof Integer integer ? new NumberTicket(integer) : (expectedTicket instanceof String stringa ? Ticket.convertToKeyWord(stringa) : Ticket.convertToKeyWord((char) expectedTicket)), ticketParser.next());
        }
    }
}