package expression.exceptions;

import expression.TripleExpression;

public class CheckedMultiply extends BinaryOperation {
    public CheckedMultiply(TripleExpression leftValue, TripleExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x, double y) {
        if (x > 0 && y > 0 && x > Integer.MAX_VALUE / y ||
            x < 0 && y < 0 && x > Integer.MAX_VALUE / y ||
            x > 0 && y < 0 && y < Integer.MIN_VALUE / x ||
            x < 0 && y > 0 && x < Integer.MIN_VALUE / y) {
            throw new IllegalOperandException("Multiply result > Integer.MAX_VALUE.");
        }
        return x * y;
    }
    @Override
    public int operation(int x, int y) {
        if (x > 0 && y > 0 && x > Integer.MAX_VALUE / y ||
            x < 0 && y < 0 && x < Integer.MAX_VALUE / y ||
            x > 0 && y < 0 && y < Integer.MIN_VALUE / x ||
            x < 0 && y > 0 && x < Integer.MIN_VALUE / y) {
            throw new IllegalOperandException("Multiply result > Integer.MAX_VALUE.");
        }
        return x * y;
    }

    @Override
    public String operationsString() {
        return "*";
    }
}
