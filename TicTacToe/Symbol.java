package game;

public enum Symbol {
    X, O;
    @Override
    public String toString() {
        return switch (this) {
            case X -> "X";
            case O -> "O";
        };
    }
    public Cell toCell() {
        return switch (this) {
            case X -> Cell.X;
            case O -> Cell.O;
        };
    }
}
