package expression;

public class CheckedDivide extends BinaryOperation {
    public CheckedDivide(MathExpression leftValue, MathExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x, double y) {
        if (y == 0) {
            throw new IllegalOperandException("You cant divide number on zero");
        }
        return x / y;
    }

    @Override
    public int operation(int x, int y) {
        if (y == 0) {
            throw new IllegalOperandException("You cant divide number on zero");
        }
        if (x == Integer.MIN_VALUE && y == -1) {
            throw new IllegalOperandException("Divide result > Integer.MAX_VALUE.");
        }
        return x / y;
    }

    @Override
    public String operationsString() {
        return "/";
    }
}
