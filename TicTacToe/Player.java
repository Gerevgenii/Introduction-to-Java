package game;

public interface Player {
    Symbol getSymbol();
    Move move(Position position, Cell cell);
}
