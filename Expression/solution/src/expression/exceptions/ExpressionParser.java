package expression.exceptions;

import expression.TripleExpression;

public class ExpressionParser implements TripleParser {

    @Override
    public TripleExpression parse(String expression) throws TicketParserException {
        return new Parser(new TicketParser(new StringCharSource(expression))).parse();
    }
}
