package misc;

import java.util.Arrays;

public class Bomberman {

    private static void print(int[][] grid) {
        
        for (String g : transformToStringArray(grid)) {
            System.out.println(g);
        }
    }

    private static void explode(int[][] grid, int ts) {

        int gWidth = grid[0].length;
        int gHeight = grid.length;
        int tgt = ts - 3;
        // System.out.println("exploding bombs with ts " + tgt + "; cts: " + ts );
        
        for (int row = 0; row < gHeight; row++) {
            for (int col = 0; col < gWidth; col++) {

                if (grid[row][col] == tgt) {

                    // System.out.println("B["+row+"][" +col+"]");

                    grid[row][col] = -1;

                    if (row - 1 >= 0 && grid[row - 1][col]  != tgt) {
                        // System.out.println("exploding up");
                        grid[row - 1][col] = -1;
                    }

                    if (row + 1 < gHeight && grid[row + 1][col] != tgt) {
                        // System.out.println("exploding down");
                        grid[row + 1][col] = -1;
                    }

                    if (col - 1 >= 0 && grid[row][col - 1] != tgt) {
                        // System.out.println("exploding left");
                        grid[row][col - 1] = -1;
                    }

                    if (col + 1 < gWidth && grid[row][col + 1] != tgt) {
                        // System.out.println("exploding right");
                        grid[row][col + 1] = -1;
                    }

                }

            }
        }
    }

    private static void plant(int[][] grid, int ts) {

        // System.out.println("plant " + ts);

        int gWidth = grid[0].length;
        int gHeight = grid.length;

        for (int row = 0; row < gHeight; row++) {
            for (int col = 0; col < gWidth; col++) {
                if (grid[row][col] == -1) {
                    grid[row][col] = ts;
                }
            }
        }
    }
   
    private static String[] transformToStringArray(int[][] grid){

        String[] matrix = new String[grid.length];
    
        for (int row = 0; row < grid.length; row++) {
            char[] arr = new char[grid[0].length];
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == -1)
                    arr[col] = '.';
                else
                    arr[col] = 'O';
            }
            matrix[row] = new String(arr);
        }
        return matrix;
    }

    private static String[] simulate(String[] matrix, int time) {

        if (time > 5 && (time % 4 == 2)){
            time = 2;
        }

        if (time > 5 && (time % 4 == 3)){
            time = 3;
        }

        if (time > 5 && (time % 4 == 0)){
            time = 4;
        }

        if (time > 5 && (time % 4 == 1)){
            time = 5;
        }

        int[][] grid = new int[matrix.length][matrix[0].length()];

        for (int row = 0; row < matrix.length; row++) {
            char[] arr = matrix[row].toCharArray();
            for (int col = 0; col < arr.length; col++) {
                if (arr[col] == '.') {
                    grid[row][col] = -1;
                } else {
                    grid[row][col] = 0;
                }
            }
        }

        for (int ts = 1; ts <= time; ts++) {
            // System.out.println("ts: " + ts);
            // print(grid);
            if (ts % 2 == 0) {
                plant(grid, ts);
            } else {
                explode(grid, ts);
            }
            // System.out.println("after:");
            // print(grid);
            // System.out.println("");
        }
        return transformToStringArray(grid);
    }

    public static void run(){

        // String[] grid = new String[]{
        //     "...",
        //     ".O.",
        //     "..."
        // };

        String[] grid = new String[]{"O",
        ".",
        "O",
        "O",
        ".",
        ".",
        ".",
        "O",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        "O",
        "O",
        ".",
        ".",
        ".",
        "O",
        "O",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        "O",
        ".",
        ".",
        ".",
        ".",
        "O",
        ".",
        ".",
        "O",
        "O",
        "O",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        "O",
        "O",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        "O",
        "O",
        "O",
        ".",
        "O",
        ".",
        ".",
        ".",
        "O",
        ".",
        ".",
        "O",
        ".",
        "O",
        ".",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        ".",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        "O",
        ".",
        ".",
        "O",
        "O",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        "O",
        "O",
        ".",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        "O",
        "O",
        ".",
        ".",
        ".",
        ".",
        "O",
        "O",
        "O",
        "O",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        ".",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        ".",
        "O",
        ".",
        ".",
        ".",
        "O",
        ".",
        "O",
        "O",
        "O",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        ".",
        "O",
        ".",
        ".",
        "O",
        "O",
        ".",
        ".",
        ".",
        "O",
        "O"};

        // String[] grid = new String[]{
        //     ".......",
        //     "...O...",
        //     "....O..",
        //     ".......",
        //     "OO.....",
        //     "OO....."};

        String[] res = simulate(grid,669782673);

        for(String s : res){
            System.out.println(s);
        }
    }

}