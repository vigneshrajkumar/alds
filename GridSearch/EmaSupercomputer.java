package GridSearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmaSupercomputer {

    public static String[] input() {
        // return new String[] { "GGGGGG", "GBBBGB", "GGGGGG", "GGBBGB", "GGGGGG" };

        // return new String[]{
        // "BGBBGB",
        // "GGGGGG",
        // "BGBBGB",
        // "GGGGGG",
        // "BGBBGB",
        // "BGBBGB"
        // };

        return new String[] { "BBBGBGBBB", "BBBGBGBBB", "BBBGBGBBB", "GGGGGGGGG",
        "BBBGBGBBB", "BBBGBGBBB", "GGGGGGGGG",
        "BBBGBGBBB", "BBBGBGBBB", "BBBGBGBBB" };
    }

    private static int getArea(int size) {
        return size == 0 ? 1 : (size * 4) + 1;
    }

    private static boolean checkFit(char[][] grid, int[][] visited, int row, int col, int length) {
        int gHeight = grid.length;
        int gWidth = grid[0].length;

        // System.out.println("[" + row + "][" + col + "] len: " + length);

        if (grid[row][col] == 'B'){
            // System.out.println("Bad cell");
            return false; // exceds the grid at top
        }

        if (row - length < 0) {
            // System.out.println("exceeds at top");
            return false; // exceds the grid at top
        }

        if (row + length > gHeight - 1) {
            // System.out.println("exceeds at bottom");
            return false; // exceds the grid at bottom}
        }

        if (col - length < 0) {
            // System.out.println("exceeds at left");
            return false; // exceds the grid left
        }

        if (col + length > gWidth - 1) {
            // System.out.println("exceeds at right");
            return false; // exceds the grid right
        }

        // System.out.println("checking rows " + row + " to " + (row - length));
        for (int pos = row; pos >= row - length; pos--) {
            if (grid[pos][col] == 'B' || visited[pos][col] == 1) {
                // System.out.println("bad cell found while walking up");
                return false;
            }
        }

        // System.out.println("checking rows " + row + " to " + (row + length));
        for (int pos = row; pos <= row + length; pos++) {
            if (grid[pos][col] == 'B' || visited[pos][col] == 1) {
                // System.out.println("bad cell found while walking down");
                return false;
            }
        }

        // System.out.println("checking cols " + row + " to " + (col - length));
        for (int pos = col; pos >= col - length; pos--) {
            if (grid[row][pos] == 'B' || visited[row][pos] == 1) {
                // System.out.println("bad cell found while walking left");
                return false;
            }
        }

        // System.out.println("checking cols " + row + " to " + (col + length));
        for (int pos = col; pos <= col + length; pos++) {
            if (grid[row][pos] == 'B' || visited[row][pos] == 1) {
                // System.out.println("bad cell found while walking right");
                return false;
            }
        }

        // marking as visited
        for (int pos = row; pos >= row - length; pos--) {
            // System.out.println("marking [" + pos + "][" + col + "] as visited");
            visited[pos][col] = 1;
        }
        for (int pos = row; pos <= row + length; pos++) {
            // System.out.println("marking [" + pos + "][" + col + "] as visited");
            visited[pos][col] = 1;
        }

        for (int pos = col; pos >= col - length; pos--) {
            // System.out.println("bad cell found while walking right");
            // System.out.println("marking [" + row + "][" + pos + "] as visited");
            visited[row][pos] = 1;
        }

        for (int pos = col; pos <= col + length; pos++) {
            // System.out.println("marking [" + row + "][" + pos + "] as visited");
            visited[row][pos] = 1;
        }
    
        // System.out.println("[" + row + "][" + col + "]");
        return true;
    }

    private static int checkFitment(char[][] matrix, int[][] visited, int size) {
        int crossCount = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (checkFit(matrix, visited, row, col, size)) {
                    crossCount++;
                }
            }
        }
        return crossCount;
    }

    public static int twoPluses(String[] matrix) {

        char[][] grid = new char[matrix.length][matrix[0].length()];

        for (int ix = 0; ix < matrix.length; ix++) {
            char[] arr = matrix[ix].toCharArray();
            for (int jx = 0; jx < arr.length; jx++) {
                grid[ix][jx] = arr[jx];
            }
        }

        List<Integer> products = new ArrayList<>();

        int maxPlus = Math.min(grid.length, grid[0].length);
        maxPlus /= 2;
        while (maxPlus >= 0) {
            // System.out.println("checking for size " + maxPlus);
            int[][] visited = new int[matrix.length][matrix[0].length()];
            int possiblePluses = checkFitment(grid, visited, maxPlus);

            while(possiblePluses > 0){
                products.add(getArea(maxPlus));
                possiblePluses--;
            }

            // if (possiblePluses >= 2){
            //     return getArea(maxPlus) * getArea(maxPlus);
            // }
            
            System.out.println(possiblePluses + " pluses of size " + maxPlus + "(" + getArea(maxPlus) + ")");
            System.out.println("");
            // if (possiblePluses >= 2){
            //     return getArea(maxPlus) * getArea(maxPlus);
            // }            
            maxPlus--;
        }

        products.sort(Comparator.naturalOrder());


        int maxProduct = Integer.MIN_VALUE;

        int start = products.size() - 2;
        int end = products.size() - 1;

        while(start >= 0){
            System.out.println(start + " : " + end + " => " + products.get(start) + " : " + products.get(end));

            // System.out.println(getArea(products.get(start)) + " : " + getArea(products.get(end)));
            maxProduct = Math.max(maxProduct, products.get(start) * products.get(end));

            start--;
            end--;
        }

        System.out.println(products);


        return maxProduct;
    }

}