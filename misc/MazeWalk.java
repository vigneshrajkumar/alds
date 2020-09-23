package misc;

import java.util.Arrays;

/*      
    / invoke
    System.out.println(MazeWalk.walk(MazeWalk.getInput(), MazeWalk.startPos(), MazeWalk.startPos(), 0));
*/

// https://www.hackerrank.com/challenges/count-luck/problem
public class MazeWalk {

    public static int[] startPos() {return new int[]{2, 6};}

    public static char[][] getInput() {

        // Answer is 1
        String[] matrix = {
            "XXXXXXXXXXXXXXXXX",
            "XXX.XX.XXXXXXXXXX",
            "XX.*..M.XXXXXXXXX",
            "XXX.XX.XXXXXXXXXX",
            "XXXXXXXXXXXXXXXXX",
        };

        char[][] grid = new char[matrix.length][matrix[0].length()];

        int[] startPos = new int[2];
        for(int ix = 0; ix < matrix.length; ix++){
            char[] arr = matrix[ix].toCharArray();
            for(int jx = 0; jx < arr.length; jx++){
                if (arr[jx] == 'M'){
                    startPos[0] = ix;
                    startPos[1] = jx;
                }
                grid[ix][jx] = arr[jx];
            }   
        }

        return grid;
    }

    private static boolean multiplePathsAvailable(char[][] grid, int[] currPos, int[] prevPos) {
        int row = currPos[0];
        int col = currPos[1];
        int pRow = prevPos[0];
        int pCol = prevPos[1];
        int gHeight = grid.length;
        int gWidth = grid[0].length;



        int paths = 0;

        if (row > 0 && grid[row - 1][col] != 'X' && row - 1 != pRow) {
            System.out.println("up available");
            paths++;
        }

        if (row < gHeight - 1 && grid[row + 1][col] != 'X' && row + 1 != pRow) {
            System.out.println("down available");
            paths++;
        }

        if (col > 0 && grid[row][col - 1] != 'X' && col - 1 != pCol) {
            System.out.println("left available");
            paths++;
        }

        if (col < gWidth - 1 && grid[row][col + 1] != 'X' && col + 1 != pCol) {
            System.out.println("right available");
            paths++;
        }
        return paths > 1 ? true : false;
    }

    public static String walk(char[][] grid, int[] currPos, int[] prevPos, int spellsUsed) {
        int guess = 1;
        int spells = walker(grid, currPos, prevPos, spellsUsed);
        System.out.println("Spells: " + spells);
        return spells == guess ? "Impressed" : "Oops!";
    }

    public static int walker(char[][] grid, int[] currPos, int[] prevPos, int spellsUsed) {
        int gHeight = grid.length;
        int gWidth = grid[0].length;
        int row = currPos[0];
        int col = currPos[1];
        int pRow = prevPos[0];
        int pCol = prevPos[1];

        System.out.println("curr pos: " + Arrays.toString(currPos) + ": " + grid[row][col]);

        if (grid[row][col] == '*') {
            System.out.println("* found at " + row + " " + col);
            return spellsUsed;
        }

        if (multiplePathsAvailable(grid, currPos, prevPos)){
            System.out.println("inc");
            spellsUsed++;
        }
        
        if (row > 0 && grid[row - 1][col] != 'X' && row - 1 != pRow) {
            System.out.println("going up");
            int[] nextPos = new int[] { row - 1, col };
            int res = walker(grid, nextPos, currPos, spellsUsed);
            if (res > 0){
                return res;
            }
        }

        if (row < gHeight - 1 && grid[row + 1][col] != 'X' && row + 1 != pRow) {
            System.out.println("going down");
            int[] nextPos = new int[] { row + 1, col };
            int res = walker(grid, nextPos, currPos, spellsUsed);
            if (res > 0){
                return res;
            }
        }

        if (col > 0 && grid[row][col - 1] != 'X' && col - 1 != pCol) {
            System.out.println("going left");
            int[] nextPos = new int[] { row, col - 1 };
            int res = walker(grid, nextPos, currPos, spellsUsed);
            if (res > 0){
                return res;
            }
        }

        if (col < gWidth - 1 && grid[row][col + 1] != 'X' && col + 1 != pCol) {
            System.out.println("going right");
            int[] nextPos = new int[] { row, col + 1 };
            int res = walker(grid, nextPos, currPos, spellsUsed);
            if (res > 0){
                return res;
            }
        }
        return 0;
    }
}