package misc;

public class LargestArea {

    static int counter = 0;

    public static int[][] input() {
        return new int[][] { 
            { 0, 1, 0, 0, 0, 0, 1, 1, 0 },
            { 1, 1, 0, 0, 1, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 1, 1, 0, 1, 0, 1, 1 },
            { 0, 1, 1, 1, 0, 0, 1, 1, 0 },
            { 0, 1, 0, 1, 1, 0, 1, 1, 0 },
            { 0, 1, 0, 0, 1, 1, 0, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 0, 0 }
        };
    }

    private static int walk(int[][] grid, int[][] visited, int row, int col, int area) {
        int gHeight = grid.length;
        int gWidth = grid[0].length;

        System.out.println("marking [" + row + "][" + col + "] as visited");
        visited[row][col] = 1;

        if (row - 1 >= 0 && grid[row - 1][col] != 0 && visited[row - 1][col] != 1) {
            // System.out.println("walking up");
            int walkedArea =  walk(grid, visited, row - 1, col, area + 1);
            System.out.println("a: " + walkedArea);
            area += walkedArea;
        }

        if (row - 1 >= 0 && col + 1 < gWidth && grid[row - 1][col + 1] != 0 && visited[row - 1][col + 1] != 1) {
            // System.out.println("walking top right");
            int walkedArea =  walk(grid, visited, row - 1, col + 1, area + 1);
            System.out.println("a: " + walkedArea);
            area += walkedArea;
        }

        if (col + 1 < gWidth && grid[row][col + 1] != 0 && visited[row][col + 1] != 1) {
            // System.out.println("walking right");
            int walkedArea =  walk(grid, visited, row, col + 1, area + 1);
            System.out.println("a: " + walkedArea);
            area += walkedArea;
        }

        if (col + 1 < gWidth && row + 1 < gHeight && grid[row + 1][col + 1] != 0 && visited[row + 1][col + 1] != 1) {
            // System.out.println("walking down right");
            int walkedArea =  walk(grid, visited, row + 1, col + 1, area + 1);
            System.out.println("a: " + walkedArea);
            area += walkedArea;
        }
        
        if (row + 1 < gHeight && grid[row + 1][col] != 0 && visited[row + 1][col] != 1) {
            // System.out.println("walking down");
            int walkedArea =  walk(grid, visited, row + 1, col, area + 1);
            System.out.println("a: " + walkedArea);
            area += walkedArea;
        }

        if (row + 1 < gHeight && col - 1 >= 0 && grid[row + 1][col - 1] != 0 && visited[row + 1][col - 1] != 1) {
            // System.out.println("walking down left");
            int walkedArea =  walk(grid, visited, row + 1, col - 1, area + 1);
            System.out.println("a: " + walkedArea);
            area += walkedArea;
        }

        if (col - 1 >= 0 && grid[row][col - 1] != 0 && visited[row][col - 1] != 1) {
            // System.out.println("walking left");
            int walkedArea =  walk(grid, visited, row, col - 1, area + 1);
            System.out.println("a: " + walkedArea);
            area += walkedArea;
        }

        if (col - 1 >= 0 && row - 1 >= 0 && grid[row - 1][col - 1] != 0 && visited[row - 1][col - 1] != 1) {
            // System.out.println("walking top left");
            int walkedArea =  walk(grid, visited, row - 1, col - 1, area + 1);
            System.out.println("a: " + walkedArea);
            area += walkedArea;
        }


        System.out.println("ret " + area);
        return area;
    }

    public static int find(int[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];

        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0 || visited[row][col] == 1) {
                    continue;
                }
                int area = walk(grid, visited, row, col, 1);
                // System.out.println("[" + row + "][" + col + "] area: " + area);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}