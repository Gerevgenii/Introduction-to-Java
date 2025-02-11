package expression;

public class Variable implements MathExpression {
    private final String string;

    public Variable(String string) {
        this.string = string;
    }

    @Override
    public int evaluate(int x) {
        if ("x".equals(string)) {
            return x;
        } else {
            throw new IllegalArgumentException("Variable name can be only x!");
        }
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return switch (string) {
            case "x" -> x;
            case "y" -> y;
            case "z" -> z;
            default -> throw new IllegalArgumentException("Variable name can be only x!");
        };
    }

    @Override
    public double evaluate(double x) {
        if ("x".equals(string)) {
            return x;
        } else {
            throw new IllegalArgumentException("Variable name can be only x!");
        }
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Variable object && string.equals(object.string);
    }

    @Override
    public int hashCode() {
        return string.hashCode();
    }
}
