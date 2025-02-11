package expression;

public class CheckedMultiply extends BinaryOperation {
    public CheckedMultiply(MathExpression leftValue, MathExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x, double y) {
        if (x > 0 && y > 0 && x > Integer.MAX_VALUE / y ||
            x < 0 && y < 0 && x > Integer.MAX_VALUE / y ||
            x > 0 && y < 0 && y < Integer.MAX_VALUE / x ||
            x < 0 && y > 0 && x < Integer.MAX_VALUE / y) {
            throw new IllegalOperandException("Multiply result > Integer.MAX_VALUE.");
        }
        return x * y;
    }

    @Override
    public int operation(int x, int y) {
        if (x > 0 && y > 0 && x > Integer.MAX_VALUE / y ||
            x < 0 && y < 0 && x > Integer.MAX_VALUE / y ||
            y < Integer.MAX_VALUE / x && x > 0 && y < 0 ||
            x < Integer.MAX_VALUE / y && x < 0 && y > 0 ||
            (x == Integer.MIN_VALUE && y == -1) || (x == -1 && y == Integer.MIN_VALUE)) {
            throw new IllegalOperandException("Multiply result > Integer.MAX_VALUE.");
        }
        return x * y;
    }

    @Override
    public String operationsString() {
        return "*";
    }
}
