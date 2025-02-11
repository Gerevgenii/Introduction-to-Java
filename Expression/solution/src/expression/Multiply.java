package expression;

public class Multiply extends BinaryOperation {
    public Multiply(MathExpression leftValue, MathExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x,double  y) {
        return x * y;
    }

    @Override
    public int operation(int x, int y) {
        return x * y;
    }

    @Override
    public String operationsString() {
        return "*";
    }
}
