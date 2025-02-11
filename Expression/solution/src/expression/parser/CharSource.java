package expression.parser;

public interface CharSource {
    char next();
    char touch();
    boolean hasNext();
}
