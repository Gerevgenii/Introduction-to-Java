package expression;

import java.util.Objects;

public abstract class BinaryOperation implements MathExpression {
    // :NOTE: модификаторы
    public final MathExpression leftValue;
    public final MathExpression rightValue;

    public BinaryOperation(MathExpression leftValue, MathExpression rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }
    @Override
    public int evaluate(int x) {
        return (int) operation(leftValue.evaluate(x), rightValue.evaluate(x));
    }
    @Override
    public int evaluate(int x, int y, int z) {
        return operation( leftValue.evaluate(x, y, z), rightValue.evaluate(x, y, z));
    }

    @Override
    public double evaluate(double x) {
        return operation(leftValue.evaluate(x), rightValue.evaluate(x));
    }

    public abstract double operation(double x, double y);
    public abstract int operation(int x, int y);

    @Override
    public String toString() {
        return "(" + leftValue + " " + operationsString() + " " + rightValue + ")";
    }

    public abstract String operationsString();

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BinaryOperation object && leftValue.equals(object.leftValue)
               && rightValue.equals(object.rightValue)
               && operationsString().equals(object.operationsString());
    }

    // :NOTE: не надо так
    @Override
    public int hashCode() {
        return Objects.hash(leftValue, rightValue, operationsString());
    }
}
