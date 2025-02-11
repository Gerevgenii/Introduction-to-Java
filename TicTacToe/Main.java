package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        System.out.println("Давайте сыграем в игру (m, n, k)!");
        System.out.print("""
                Хотите ли вы сыграть в матч?
                Да - 1
                Нет - 0
                """);
        final int match = scanMatch();
        final int matchValue = scanMatchValue(match);
        System.out.print("""
                Выберете тех, кого хотите поставить играть (2 игрока),\s
                последовательность ходов напрямую зависит от последовательности выбора игроков:\s
                1) Бог рандома (RandomPlayer)\s
                2) Всегда ходим по порядку (SequentialPlayer)\s
                3) Настоящий игрок (HumanPlayer)
                """);
        System.out.print("Первый) ");
        final int numberPlayer1 = scanNumberPlayer();
        System.out.print("Второй) ");
        final int numberPlayer2 = scanNumberPlayer();
        System.out.println("Введите входные данные (m, n, k)");

        final int[] mnk = scanMNK();
        final int m = mnk[0];
        final int n = mnk[1];
        final int k = mnk[2];
        final Player playerO = getPlayer(numberPlayer2, m, n, Symbol.O);
        final Player playerX = getPlayer(numberPlayer1, m, n, Symbol.X);
        final Symbol symbol = Symbol.X;
        if (matchValue == 1) {
            final Game game1 = new Game(
                    true,
                    playerX
                    ,
                    playerO
            );
            playUntilEnd(m, n, k, game1, symbol);
        } else {
            final Match finalMatch = new Match(playerX, playerO);
            finalMatch.playMatch(matchValue, m, n, k, symbol);
        }
    }

    private static int[] scanMNK() {
        int m;
        int n;
        int k;
        while (true) {
            try {
                final Scanner scanner = new Scanner(System.in);
                m = scanner.nextInt();
                n = scanner.nextInt();
                k = scanner.nextInt();
                if (m < 0 || n < 0) {
                    throw new IllegalArgumentException();
                } else if (m < k || n < k) {
                    throw new IllegalArgumentException();
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Возможно, вы ввели не то, попробуйте ещё раз:");
            } catch (InputMismatchException e) {
                System.out.println("Только цифры! Введите ещё раз: ");
            }

        }
        return new int[]{m, n, k};
    }

    private static int scanNumberPlayer() {
        int numberPlayer1;
        while (true) {
            try {
                final Scanner firstLine = new Scanner(System.in);
                numberPlayer1 = firstLine.nextInt();
                if (!(numberPlayer1 == 1 || numberPlayer1 == 2 || numberPlayer1 == 3)) {
                    throw new IllegalArgumentException();
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Вы похоже ввели не то число, которое от вас " +
                                   "требовалось, у вас всё получится, попробуйте ещё раз: ");
            } catch (InputMismatchException e) {
                System.out.println("Только цифры! Введите ещё раз: ");
            }
        }
        return numberPlayer1;
    }

    private static int scanMatchValue(int match) {
        int matchValue = 1;
        if (match == 1) {
            System.out.println("Введите количество побед до финальной победы: ");
            while (true) {
                try {
                    final Scanner scanner = new Scanner(System.in);
                    matchValue = scanner.nextInt();
                    if (matchValue <= 0) {
                        throw new IllegalArgumentException();
                    } else {
                        break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Возможно, вы ввели не то, попробуйте ещё раз:");
                } catch (InputMismatchException e) {
                    System.out.println("Только цифры! Введите ещё раз: ");
                }
            }
        }
        return matchValue;
    }

    private static int scanMatch() {
        int match;
        while (true) {
            try {
                final Scanner scanner = new Scanner(System.in);
                match = scanner.nextInt();
                if (match != 1 && match != 0) {
                    throw new IllegalArgumentException();
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Возможно, вы ввели не то, попробуйте ещё раз:");
            } catch (InputMismatchException e) {
                System.out.println("Только цифры! Введите ещё раз: ");
            }
        }
        return match;
    }

    private static Player getPlayer(int numberPlayer, int m, int n, Symbol symbol) {
        return switch (numberPlayer) {
            case 1 -> new RandomPlayer(m, n, symbol);
            case 2 -> new SequentialPlayer(m, n, symbol);
            default -> new HumanPlayer(new Scanner(System.in), symbol);
        };
    }

    static int playUntilEnd(int m, int n, int k, Game game, Symbol cell) {
        int result;
        //noinspection TypeMayBeWeakened
        final MNKBoard board = new MNKBoard(m, n, k, cell);
        do {
            result = game.play(board);
        } while (!(result == 1 || result == 2 || result == 0));
        return result;
    }
}
