package expression;

public class IllegalOperandException extends RuntimeException {
    private final String error;
    public IllegalOperandException(String string) {
        this.error = string;
    }
}
