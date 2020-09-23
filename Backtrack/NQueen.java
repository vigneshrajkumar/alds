package Backtrack;

import java.util.Arrays;

public class NQueen {

    public static void run() {
        solve(4);
    }

    // private static boolean valid(int[][] board, int row, int col) {
    // for (int r = 0; r < board.length; r++) {
    // if (r == row)
    // continue;
    // if (board[r][col] == 1)
    // return false;
    // }

    // for (int c = 0; c < board[0].length; c++) {
    // if (c == col)
    // continue;
    // if (board[row][c] == 1)
    // return false;
    // }

    // return true;
    // }

    private static boolean valid(int board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private static void print(int[][] board) {
        for (int[] r : board)
            System.out.println(Arrays.toString(r));
    }

    private static boolean place(int[][] board, int col, int queens) {

        if (col >= queens) {
            return true;
        }

        for (int row = 0; row < board.length; row++) {
            if (valid(board, row, col)) {
                board[row][col] = 1;
                if (place(board, col + 1, queens)) {
                    return true;
                }
                board[row][col] = 0;
            }

        }

        return false;
    }

    private static void solve(int queens) {
        int[][] board = new int[queens][queens];
        print(board);
        System.out.println("-----");
        place(board, 0, queens);
        print(board);
    }
}
