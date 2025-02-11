package game;

@SuppressWarnings("unused")
public class SequentialPlayer implements Player {

    private final int m;
    private final int n;
    private final Symbol symbol;
    public SequentialPlayer(int m, int n, Symbol symbol) {
        this.m = m;
        this.n = n;
        this.symbol = symbol;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public Move move(final Position position, final Cell cell) {
//        Board board = (Board) position;
//        board.makeMove()
        for (int r = 0; r < m; r++) {
            for (@SuppressWarnings("StandardVariableNames") int c = 0; c < n; c++) {
                final Move move = new Move(r, c, cell);
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new IllegalStateException("No valid moves");
    }
}
