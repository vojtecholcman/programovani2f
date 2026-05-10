/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce206;

import cz.gyarab.util.light.Chessboard;

/**
 *
 * @author vojta
 */
public class QueensBoard {

    public static void main(String[] args) {
        QueensBoard qb = new QueensBoard(8, 8);
        int count = qb.layout(8);
        System.out.println("Pocet reseni: " + count);
    }

    private final int rows;
    private final int cols;
    private final Chessboard board;

    public QueensBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new Chessboard(rows, cols);
    }

    public int layout(int count) {
        board.showWindow();
        return placeQueens(new boolean[rows][cols], 0, count);
    }

    private int placeQueens(boolean[][] placed, int startPos, int remaining) {
        if (remaining == 0) {
//            pause(800);
            return 1;
        }
        int total = 0;
        for (int pos = startPos; pos < rows * cols; pos++) {
            int row = pos / cols;
            int col = pos % cols;
            if (isSafe(placed, row, col)) {
                placed[row][col] = true;
                board.put(row, col, Chessboard.Piece.createWhite());
                total += placeQueens(placed, pos + 1, remaining - 1);
                placed[row][col] = false;
                board.remove(row, col);
            }
        }
        return total;
    }

    private boolean isSafe(boolean[][] placed, int row, int col) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (placed[r][c]) {
                    if (r == row || c == col || Math.abs(r - row) == Math.abs(c - col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
