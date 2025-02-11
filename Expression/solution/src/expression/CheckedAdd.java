package expression;

public class CheckedAdd extends BinaryOperation {
    public CheckedAdd(MathExpression leftValue, MathExpression rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public double operation(double x, double y) {
        if (x > 0 && y > 0) {
            if (Integer.MAX_VALUE - x < y) {
                throw new IllegalOperandException("Our system can't add very big number.");
            }
        }
        if (x < 0 && y < 0) {
            if (Integer.MIN_VALUE - x > y) {
                throw new IllegalOperandException("Our system can't add very small number.");
            }
        }
        return x + y;
    }

    @Override
    public int operation(int x, int y) {
        if (x > 0 && y > 0) {
            if (Integer.MAX_VALUE - x < y) {
                throw new IllegalOperandException("Our system can't add very big number.");
            }
        }
        if (x < 0 && y < 0) {
            if (Integer.MIN_VALUE - x > y) {
                throw new IllegalOperandException("Our system can't add very small number.");
            }
        }
        return x + y;
    }

    @Override
    public String operationsString() {
        return "+";
    }
}
