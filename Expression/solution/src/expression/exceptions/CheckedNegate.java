package expression.exceptions;

import expression.TripleExpression;

import java.util.Objects;

public class CheckedNegate implements TripleExpression {
    private final TripleExpression tripleExpression;

    public CheckedNegate(TripleExpression tripleExpression) {
        this.tripleExpression = tripleExpression;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        final int value = tripleExpression.evaluate(x, y, z);
        if (value == Integer.MIN_VALUE) {
            throw new IllegalOperandException("You can't negate Integer.MIN_VALUE");
        }
        return -value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CheckedNegate checkedNegate && tripleExpression.equals(checkedNegate.tripleExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tripleExpression);
    }

    @Override
    public String toString() {
        return "-(" + tripleExpression.toString() + ")";
    }

}
