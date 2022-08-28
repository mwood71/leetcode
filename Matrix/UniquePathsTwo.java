package Leetcode.Matrix;

public class UniquePathsTwo {
    int[][] grid;
    int[][] cache;
    public static void main(String[] args) {
        UniquePathsTwo u = new UniquePathsTwo();
        int r = u.uniquePathsWithObstacles(new int[][]{
            {0,0,0},{0,1,0},{0,0,0}
        });
        System.out.println(r);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid;
        cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(0,0);
    }

    int dfs(int row, int column) {
        if (row < 0 || row >= grid.length) return 0;
        if (column < 0 || column >= grid[row].length) return 0;
        if (grid[row][column] == 1) return 0;
        if (row == grid.length-1 && column == grid[row].length-1) return 1;
        if (cache[row][column] != 0) return cache[row][column];
        cache[row][column] = dfs(row+1, column) + dfs(row, column+1);
        return cache[row][column];
    }
}
// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2