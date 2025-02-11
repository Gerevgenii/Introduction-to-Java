package expression.exceptions;

import expression.TripleExpression;

public class CheckedSubtract extends BinaryOperation {

    public CheckedSubtract(TripleExpression leftValue, TripleExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x, double y) {
        if (x < 0 && y > 0) {
            if (x < Integer.MIN_VALUE + y) {
                throw new IllegalOperandException("Our system can't subtract very big number.");
            }
        }
        if (x > 0 && y < 0) {
            if (x > Integer.MAX_VALUE + y) {
                throw new IllegalOperandException("Our system can't subtract very big number.");
            }
        }
        return x - y;
    }

    @Override
    public int operation(int x, int y) {
        if (x <= 0 && y >= 0) {
            if (x < Integer.MIN_VALUE + y) {
                throw new IllegalOperandException("Our system can't subtract very big number.");
            }
        }
        if (x >= 0 && y <= 0) {
            if (x > Integer.MAX_VALUE + y) {
                throw new IllegalOperandException("Our system can't subtract very big number.");
            }
        }
        return x - y;
    }

    @Override
    public String operationsString() {
        return "-";
    }
}
