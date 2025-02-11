package expression;

public class Set extends BinaryOperation {
    public Set(MathExpression leftValue, MathExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x, double y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int operation(int x, int y) {
        return x | (1 << y);
    }

    @Override
    public String operationsString() {
        return "set";
    }
}
