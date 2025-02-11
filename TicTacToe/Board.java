package game;

public interface Board {
    Position getPosition();
    Symbol getTurn();
    Result makeMove(Move move);
}
