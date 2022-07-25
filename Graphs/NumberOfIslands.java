package Leetcode.Graphs;

public class NumberOfIslands {
    char[][] grid;
    public static void main(String[] args) {
        char[][] array = new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(array));
    }
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int islandCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '1') {
                    islandCount++;
                    dfs(row, column);
                }
            }
        }
        return islandCount;
    }

    public void dfs(int row, int column) {
        if (row < 0 || row >= grid.length) return;
        if (column < 0 || column >= grid[row].length) return;
        if (grid[row][column] != '1') return;

        grid[row][column] = '0';

        dfs(row+1, column);
        dfs(row, column+1);
        dfs(row-1, column);
        dfs(row, column-1);
    }
}

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
