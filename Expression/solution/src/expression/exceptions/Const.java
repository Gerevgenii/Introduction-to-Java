package expression.exceptions;

import expression.TripleExpression;

import java.util.Objects;

public class Const implements TripleExpression {
    public final double value;
    private final boolean fl;

    public Const(double value) {
        this.value = value;
        fl = true;
    }
    public Const(int value) {
        //noinspection ImplicitNumericConversion
        this.value = value;
        fl = false;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return (int) value;
    }

    @Override
    public String toString() {
        return fl ? String.valueOf(value) : String.valueOf((int) value);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Const object && (int) value == (int) object.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
