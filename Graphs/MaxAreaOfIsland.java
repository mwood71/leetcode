package Leetcode.Graphs;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int total = maxAreaOfIsland.maxAreaOfIsland(new int[][]{{1,1,1,0,0,0,0,1}});
        System.out.println(total);
    }
    int[][] grid;
    int tempMax = 0;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 1) {
                    dfs(row, column);
                    maxArea = Math.max(maxArea, tempMax);
                    tempMax = 0;
                }
            }
        }
        return maxArea;
    }

    void dfs(int row, int column) {
        if (row < 0 || row > grid.length - 1) return;
        if (column < 0 || column > grid[row].length - 1) return;
        if (grid[row][column] != 1) return;

        grid[row][column] = 0;
        this.tempMax++;

        dfs(row+1, column);
        dfs(row, column+1);
        dfs(row-1,column);
        dfs(row, column-1);
    }
}

// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0