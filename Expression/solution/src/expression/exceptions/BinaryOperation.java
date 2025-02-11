package expression.exceptions;

import expression.TripleExpression;

import java.util.Objects;

public abstract class BinaryOperation implements TripleExpression {
    // :NOTE: модификаторы
    public final TripleExpression leftValue;
    public final TripleExpression rightValue;

    public BinaryOperation(TripleExpression leftValue, TripleExpression rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }
    @Override
    public int evaluate(int x, int y, int z) {
        return operation( leftValue.evaluate(x, y, z), rightValue.evaluate(x, y, z));
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
