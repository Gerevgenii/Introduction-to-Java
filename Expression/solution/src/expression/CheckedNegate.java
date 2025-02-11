package expression;

import java.util.Objects;

public class CheckedNegate implements MathExpression {
    private final MathExpression mathExpression;

    public CheckedNegate(MathExpression mathExpression) {
        this.mathExpression = mathExpression;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        final int value = mathExpression.evaluate(x, y, z);
        if (value == Integer.MIN_VALUE) {
            throw new IllegalOperandException("You can't negate Integer.MIN_VALUE");
        }
        return -value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CheckedNegate checkedNegate && mathExpression.equals(checkedNegate.mathExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mathExpression);
    }

    @Override
    public String toString() {
        return "-(" + mathExpression.toString() + ")";
    }

    @Override
    public double evaluate(double x) {
        throw new IllegalOperandException("You can't use double");
    }

    @Override
    public int evaluate(int x) {
        if (x == Integer.MIN_VALUE) {
            throw new IllegalOperandException("You can't negate Integer.MIN_VALUE");
        }
        return -x;
    }
}
