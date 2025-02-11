package expression.parser;

import expression.*;

public class Parser {
    private final TicketParser ticket;

    public Parser(TicketParser ticket) {
        this.ticket = ticket;
    }

    public MathExpression parse() {
        return priority4();
    }

    private MathExpression priority1() {
        final Ticket objLevel1 = ticket.next();
        if (objLevel1 instanceof NumberTicket number) {
            return new Const(number.number());
        }
        if (!(objLevel1 instanceof KeyWord keyWord)) {
            throw new IllegalStateException("Expected: operation or int, but actual: " + objLevel1);
        }
        if (keyWord == KeyWord.SUBTRACT) {
            return new UnaryMinus(priority1());
        }
        if (keyWord == KeyWord.X || keyWord == KeyWord.Y || keyWord == KeyWord.Z) {
            return var(keyWord.toString());
        }
        if (keyWord == KeyWord.LEFT_BRACKET) {
            final MathExpression mathExpression = priority4();
            if (!ticket.touchNextTicket().equals(KeyWord.RIGHT_BRACKET)) {
                throw new IllegalArgumentException("Where closed ')'???");
            } else {
                ticket.next();
            }
            return mathExpression;
        }
        throw new IllegalArgumentException("Your text incorrect!");
    }

    private MathExpression priority2() {
        MathExpression mathExpression = priority1();
        while (ticket.hasNext()) {
            final Ticket ticket1 = ticket.touchNextTicket();
            if (!(ticket1 instanceof KeyWord keyWord)) {
                break;
            }
            if (keyWord == KeyWord.MULTIPLY) {
                ticket.next();
                mathExpression = new Multiply(mathExpression, priority1());
                continue;
            }
            if (keyWord == KeyWord.DIVIDE) {
                ticket.next();
                mathExpression = new Divide(mathExpression, priority1());
            } else {
                break;
            }
        }
        return mathExpression;
    }

    private MathExpression priority3() {
        MathExpression mathExpression = priority2();
        while (ticket.hasNext()) {
            final Ticket ticket1 = ticket.touchNextTicket();
            if (!(ticket1 instanceof KeyWord keyWord)) {
                throw new IllegalStateException("Expected: operation or int, but actual: " + ticket1);
            }
            if (keyWord == KeyWord.ADD) {
                ticket.next();
                mathExpression = new Add(mathExpression, priority2());
                continue;
            }
            if (keyWord == KeyWord.SUBTRACT) {
                ticket.next();
                mathExpression = new Subtract(mathExpression, priority2());
            } else {
                break;
            }
        }
        return mathExpression;
    }

    private MathExpression priority3_1() {
        MathExpression mathExpression = priority3();
        while (ticket.hasNext()) {
            final Ticket ticket1 = ticket.touchNextTicket();
            if (!(ticket1 instanceof KeyWord keyWord)) {
                throw new IllegalStateException("Expected: operation or int, but actual: " + ticket1);
            }
            if (keyWord == KeyWord.SET) {
                ticket.next();
                mathExpression = new Set(mathExpression, priority3());
                continue;
            }
            if (keyWord == KeyWord.CLEAR) {
                ticket.next();
                mathExpression = new Clear(mathExpression, priority3());
            } else {
                break;
            }
        }
        return mathExpression;
    }

    private MathExpression priority4() {
        return priority3_1();
    }

    private MathExpression var(String string) {
        return new Variable(string);
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
