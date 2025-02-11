package game;

import static game.Main.playUntilEnd;

public final class Match {
    private final Player playerX;
    private final Player playerO;

    public Match(Player playerX,Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
    }
    public void playMatch(int matchCount, int m, int n, int k, Symbol symbol) {
        final Game game1 = new Game(
                true,
                playerX
                ,
                playerO
        );
        final Game game2 = new Game(
                true,
                playerO
                ,
                playerX
        );
        Symbol symbol1 = symbol;
        int playerXCount = 0;
        int playerOCount = 0;
        while (playerXCount < matchCount && playerOCount < matchCount) {
            System.out.println("Число побед первого игрока: " + playerXCount);
            System.out.println("Число побед второго игрока: " + playerOCount);
            final int result = playUntilEnd(m, n, k,
                    switch (symbol1) {
                        case X -> game1;
                        case O -> game2;
                    }, symbol1);
            if (result == 1) {
                switch (symbol1) {
                    case X -> playerXCount++;
                    case O -> playerOCount++;
                }
            } else if (result == 2) {
                switch (symbol1) {
                    case X -> playerOCount++;
                    case O -> playerXCount++;
                }
            }
            symbol1 = symbol1 == Symbol.X ? Symbol.O : Symbol.X;
        }
        System.out.print("Финальным победителем является: ");
        if (playerXCount == matchCount) {
            System.out.println("player1");
        } else {
            System.out.println("player2");
        }
    }
}
