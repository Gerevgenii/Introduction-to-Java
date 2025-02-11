package game;

import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random;
    private final Symbol symbol;
    private final int m;
    private final int n;
    public RandomPlayer(final Random random, Symbol symbol, int m, int n) {
        this.random = random;
        this.symbol = symbol;
        this.n = n;
        this.m = m;
    }

    public RandomPlayer(int m, int n, Symbol symbol) {
        this(new Random(), symbol, m, n);
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public Move move(final Position position, final Cell cell) {
        while (true) {
            final int r = random.nextInt(m);
            //noinspection StandardVariableNames
            final int c = random.nextInt(n);
            final Move move = new Move(r, c, cell);
            if (position.isValid(move)) {
                return move;
            }
        }
    }
}
