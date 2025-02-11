package expression.exceptions;

public interface CharSource {
    char next();
    char touch();
    boolean hasNext();
}
