package Backtrack;

import java.util.Arrays;

public class Sudoku {
    public static void run() {
        int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }, };
        // int[][] board = new int[][]{
        // {7,8,0},
        // {6,0,0},
        // {0,0,0},
        // };

        // int[][] board = new int[][]{
        // {7,8,0,4,0,0},
        // {6,0,0,0,7,5},
        // {0,0,0,6,0,1},
        // {0,0,7,0,4,0},
        // {0,0,1,0,5,0},
        // {9,0,4,0,6,0}
        // };

        System.out.println(solve(board));

        print(board);

    }

    private static int[] findEmpty(int[][] board) {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[0].length; col++)
                if (board[row][col] == 0)
                    return new int[] { row, col };

        return new int[] { -1, -1 };
    }

    private static boolean isValid(int[][] board, int value, int row, int col) {
        for (int r = 0; r < board.length; r++) {
            if (r == row)
                continue;
            if (board[r][col] == value)
                return false;
        }

        for (int c = 0; c < board[0].length; c++) {
            if (c == col)
                continue;
            if (board[row][c] == value)
                return false;
        }

        int boxRow = row / 3;
        int boxCol = col / 3;

        for (int r = boxRow; r < boxRow * 3 + 3; r++) {
            for (int c = boxCol; c < boxCol * 3 + 3; c++) {
                if (r == row && c == col)
                    continue;
                if (board[r][c] == value)
                    return false;
            }
        }

        return true;
    }

    private static void print(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            if (row % 3 == 0 && row != 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < (33); i++) {
                    sb.append("-");
                }
                System.out.println(sb.toString());
            }
            for (int col = 0; col < board[0].length; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + board[row][col] + " ");
                if (col == board.length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

    private static boolean solve(int[][] board) {

        System.out.println("solve()");

        int[] next = findEmpty(board);

        System.out.print("next: " + Arrays.toString(next) + " ");

        if (next[0] == -1 && next[1] == -1) {
            System.out.println("no more empty cells ");
            return true;
        }

        for (int val = 1; val < 10; val++) {

            System.out.print("v: " + val + " ");

            if (isValid(board, val, next[0], next[1])) {

                System.out.print("valid ");

                board[next[0]][next[1]] = val;

                if (solve(board)) {
                    return true;
                } else {
                    System.out.print("backtrack ");
                    board[next[0]][next[1]] = 0;
                }
            }
        }
        return false;
    }
}
