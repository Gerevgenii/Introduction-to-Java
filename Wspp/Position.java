package wspp;

public record Position(int line, int number) {
    @Override
    public String toString() {
        return line + ":" + number;
    }
}
