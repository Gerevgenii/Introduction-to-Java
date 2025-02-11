package expression.exceptions;

import expression.TripleExpression;

public class Clear extends BinaryOperation {
    public Clear(TripleExpression leftValue, TripleExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x, double y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int operation(int x, int y) {
        return x & ~(1 << y);
    }

    @Override
    public String operationsString() {
        return "clear";
    }
}
