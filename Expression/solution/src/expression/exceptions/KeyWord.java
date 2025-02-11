package expression.exceptions;

public enum KeyWord implements Ticket {
    SET, CLEAR, ADD, SUBTRACT, MULTIPLY, DIVIDE, RIGHT_BRACKET, LEFT_BRACKET, X, Y, Z;

    @Override
    public String toString() {
        return switch (this) {
            case SET -> "set";
            case CLEAR -> "clear";
            case ADD -> "+";
            case SUBTRACT -> "-";
            case MULTIPLY -> "*";
            case DIVIDE -> "/";
            case RIGHT_BRACKET -> ")";
            case LEFT_BRACKET -> "(";
            case X -> "x";
            case Y -> "y";
            case Z -> "z";
        };
    }
}
