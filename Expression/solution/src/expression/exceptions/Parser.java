package expression.exceptions;

import expression.TripleExpression;

public class Parser {
    private final TicketParser ticket;

    public Parser(TicketParser ticket) {
        this.ticket = ticket;
    }

    public TripleExpression parse() throws TicketParserException {
        final TripleExpression tripleExpression = priority4();
        if (ticket.hasNext()) {
            throw new TicketParserException("Your text is incorrect");
        }
        return tripleExpression;
    }

    private TripleExpression priority1() throws TicketParserException {
        final Ticket objLevel1;
        objLevel1 = ticket.next();
        if (objLevel1 instanceof NumberTicket number) {
            return new Const(number.number());
        }
        if (!(objLevel1 instanceof KeyWord keyWord)) {
            throw new TicketParserException("Expected: operation or int, but actual: " + objLevel1);
        }
        if (keyWord == KeyWord.SUBTRACT) {
            return new CheckedNegate(priority1());
        }
        if (keyWord == KeyWord.X || keyWord == KeyWord.Y || keyWord == KeyWord.Z) {
            return var(keyWord.toString());
        }
        if (keyWord == KeyWord.LEFT_BRACKET) {
            final TripleExpression tripleExpression = priority4();
            if (!ticket.touchNextTicket().equals(KeyWord.RIGHT_BRACKET)) {
                throw new TicketParserException("Where closed ')'???");
            } else {
                ticket.next();
            }
            return tripleExpression;
        }
        throw new TicketParserException("Your text incorrect! Program can't parsed >>" + objLevel1 + "<<. This ticket comes after the operation, this should not be. Or you just entered incorrect data.");
    }

    private TripleExpression priority2() throws TicketParserException {
        TripleExpression tripleExpression = priority1();
        while (ticket.hasNext()) {
            final Ticket ticket1 = ticket.touchNextTicket();
            if (!(ticket1 instanceof KeyWord keyWord)) {
                break;
            }
            if (keyWord == KeyWord.MULTIPLY) {
                ticket.next();
                tripleExpression = new CheckedMultiply(tripleExpression, priority1());
                continue;
            }
            if (keyWord == KeyWord.DIVIDE) {
                ticket.next();
                tripleExpression = new CheckedDivide(tripleExpression, priority1());
            } else {
                break;
            }
        }
        return tripleExpression;
    }

    private TripleExpression priority3() throws TicketParserException {
        TripleExpression tripleExpression = priority2();
        while (ticket.hasNext()) {
            final Ticket ticket1 = ticket.touchNextTicket();
            if (!(ticket1 instanceof KeyWord keyWord)) {
                throw new TicketParserException("Expected: operation or int, but actual: " + ticket1);
            }
            if (keyWord == KeyWord.ADD) {
                ticket.next();
                tripleExpression = new CheckedAdd(tripleExpression, priority2());
                continue;
            }
            if (keyWord == KeyWord.SUBTRACT) {
                ticket.next();
                tripleExpression = new CheckedSubtract(tripleExpression, priority2());
            } else {
                break;
            }
        }
        return tripleExpression;
    }

    private TripleExpression priority3_1() throws TicketParserException {
        TripleExpression tripleExpression = priority3();
        while (ticket.hasNext()) {
            final Ticket ticket1 = ticket.touchNextTicket();
            if (!(ticket1 instanceof KeyWord keyWord)) {
                throw new TicketParserException("Expected: operation or int, but actual: " + ticket1);
            }
            if (keyWord == KeyWord.SET) {
                ticket.next();
                tripleExpression = new Set(tripleExpression, priority3());
                continue;
            }
            if (keyWord == KeyWord.CLEAR) {
                ticket.next();
                tripleExpression = new Clear(tripleExpression, priority3());
            } else {
                break;
            }
        }
        return tripleExpression;
    }

    private TripleExpression priority4() throws TicketParserException {
        return priority3_1();
//        return priority3();
    }

    private TripleExpression var(String string) {
        return new Variable(string);
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
