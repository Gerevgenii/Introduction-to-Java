package expression;

public class Divide extends BinaryOperation {
    public Divide(MathExpression leftValue, MathExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x, double y) {
        return x / y;
    }

    @Override
    public int operation(int x, int y) {
        return x / y;
    }

    @Override
    public String operationsString() {
        return "/";
    }
}
