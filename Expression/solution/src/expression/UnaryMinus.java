package expression;

import java.util.Objects;

public class UnaryMinus implements MathExpression {

    private final MathExpression mathExpression;

    public UnaryMinus(MathExpression mathExpression) {
        this.mathExpression = mathExpression;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return -mathExpression.evaluate(x, y, z);
    }

    @Override
    public double evaluate(double x) {
        return -mathExpression.evaluate(x);
    }

    @Override
    public int evaluate(int x) {
        return -mathExpression.evaluate(x);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UnaryMinus unaryMinus && mathExpression.equals(unaryMinus.mathExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mathExpression);
    }

    @Override
    public String toString() {
        return "-(" + mathExpression.toString() + ")";
    }
}
