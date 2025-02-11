package expression.exceptions;

public class Power extends BinaryOperation {
    public Power(MathExpression leftValue, MathExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x, double y) {
        // :NOTE: 2 ** 0.5 ~ 1.4
        return Math.pow(x, y);
    }

    @Override
    public int operation(int x, int y) {
        //noinspection ImplicitNumericConversion
        return (int) Math.pow(x, y);
    }

    @Override
    public String operationsString() {
        return "^";
    }
}
