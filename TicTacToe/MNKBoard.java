package game;

import java.util.Arrays;
import java.util.Map;

public class MNKBoard implements Board, Position {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.'
    );

    private final Cell[][] cells;
    private Symbol turn;
    private final int k;
    private final int m;
    private final int n;
    private int emptyCell;

    public MNKBoard(int m, int n, int k, Symbol cell) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.emptyCell = m * n;
        this.cells = new Cell[m][n];
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        turn = cell;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public Symbol getTurn() {
        return turn;
    }

    @Override
    public Result makeMove(final Move move) {
        if (!isValid(move)) {
            return Result.LOSE;
        }

        if (cells[move.getRow()][move.getColumn()] == Cell.E) {
            emptyCell--;
        }
        cells[move.getRow()][move.getColumn()] = move.getValue();
        final int win = getResult(move.getRow(), move.getColumn(), k);
        if (win == 1) return Result.WIN;
        if (win == 0) return Result.ADDITIONAL;
        if (emptyCell == 0) {
            return Result.DRAW;
        }
        turn = turn == Symbol.X ? Symbol.O : Symbol.X;
        return Result.UNKNOWN;
    }

    private int getResult(int row, int column, int k) {
        int inRow = 0;
        for (int i = column; i < n; i++) {
            if (cells[row][i] == turn.toCell()) {
                inRow++;
            } else {
                break;
            }
        }
        for (int i = column - 1; i >= 0; i--) {
            if (cells[row][i] == turn.toCell()) {
                inRow++;
            } else {
                break;
            }
        }
        if (inRow == k) {
            return 1;
        }
        if (inRow >= 4) {
            return 0;
        }
        int inColum = 0;
        for (int i = row; i < m; i++) {
            if (cells[i][column] == turn.toCell()) {
                inColum++;
            } else {
                break;
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            if (cells[i][column] == turn.toCell()) {
                inColum++;
            } else {
                break;
            }
        }
        if (inColum == k) {
            return 1;
        }
        if (inColum >= 4) {
            return 0;
        }
        //noinspection SpellCheckingInspection
        int inDiag1 = 0;
        int positionRow = row;
        int positionColumn = column;
        while (true) {
            if ((positionRow < m) && (positionColumn < n)) {
                if (cells[positionRow][positionColumn] == turn.toCell()) {
                    inDiag1++;
                    positionRow++;
                    positionColumn++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        inDiag1--;
        positionRow = row;
        positionColumn = column;
        while (true) {
            if ((positionRow >= 0) && (positionColumn >= 0)) {
                if (cells[positionRow][positionColumn] == turn.toCell()) {
                    inDiag1++;
                    positionRow--;
                    positionColumn--;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        if (inDiag1 == k) {
            return 1;
        }
        if (inDiag1 >= 4) {
            return 0;
        }
        //noinspection SpellCheckingInspection
        int inDiag2 = 0;
        positionRow = row;
        positionColumn = column;
        while (true) {
            if ((positionRow < m) && (positionColumn >= 0)) {
                if (cells[positionRow][positionColumn] == turn.toCell()) {
                    inDiag2++;
                    positionRow++;
                    positionColumn--;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        inDiag2--;
        positionRow = row;
        positionColumn = column;
        while (true) {
            if ((positionRow >= 0) && (positionColumn < n)) {
                if (cells[positionRow][positionColumn] == turn.toCell()) {
                    inDiag2++;
                    positionRow--;
                    positionColumn++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        if (inDiag2 == k) {
            return 1;
        }
        if (inDiag2 >= 4) {
            return 0;
        }
        return -1;
    }

    @Override
    public boolean isValid(final Move move) {
        //noinspection ConstantOnWrongSideOfComparison
        return 0 <= move.getRow() && move.getRow() < m
               && 0 <= move.getColumn() && move.getColumn() < n
               && cells[move.getRow()][move.getColumn()] == Cell.E
               && turn == getTurn();
    }

    @Override
    public Cell getCell(final int r, final int c) {
        return cells[r][c];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < n; i++) {
            sb.append(i + 1);
        }
        for (int r = 0; r < m; r++) {
            sb.append("\n");
            sb.append(r + 1);
            for (@SuppressWarnings("StandardVariableNames") int c = 0; c < n; c++) {
                sb.append(SYMBOLS.get(cells[r][c]));
            }
        }
        return sb.toString();
    }
}
