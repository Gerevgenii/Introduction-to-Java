package game;

import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final PrintStream out;
    private Scanner in;
    private final Symbol symbol;

    public HumanPlayer(Scanner in, Symbol symbol) {
        this.symbol = symbol;
        this.out = System.out;
        this.in = in;
    }


    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public Move move(final Position position, final Cell cell) {

        out.println("Введите строчку и столбец: ");
        while (true) {
            try {
                in = new Scanner(System.in);
                final Move move = new Move(in.nextInt() - 1, in.nextInt() - 1, cell);
                if (position.isValid(move)) {
                    return move;
                }
                throw new IllegalArgumentException();
            } catch (NoSuchElementException e) {
                out.println("Попробуйте ещё раз, но теперь только цифры: ");
            } catch (IllegalArgumentException e) {
                out.println("Вы ввели не совсем то, что хотели, попробуйте ещё раз: ");
            }
        }
    }
}
