package Leetcode.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacififcAtlanticWaterflow {
    int[][] countArray;
    int[][] grid;
    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        PacififcAtlanticWaterflow p = new PacififcAtlanticWaterflow();
        System.out.println(p.pacificAtlantic(grid));
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        grid = heights;
        countArray = new int[heights.length][heights[0].length];
        boolean[][] pacificVisited = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticVisited = new boolean[heights.length][heights[0].length];

        for (int row = 0; row < heights.length; row++) {
            dfs(row, 0, pacificVisited, -Integer.MIN_VALUE);
            dfs(row, heights[row].length-1, atlanticVisited, -Integer.MIN_VALUE);
        }

        for (int column = 0; column < heights[0].length; column++) {
            dfs(0, column, pacificVisited, -Integer.MIN_VALUE);
            dfs(heights.length-1, column, atlanticVisited, -Integer.MIN_VALUE);
        }

        List<List<Integer>> results = new LinkedList<>();
        for (int row = 0; row < countArray.length; row++) {
           for (int column = 0; column < countArray[row].length; column++) {
                if (countArray[row][column] == 2) {
                    results.add(Arrays.asList(row,column));
                }
           }
        }
        return results;
        
    }

    void dfs(int row, int column, boolean[][] visited, int maxValue) {
        if (row < 0 || row > this.grid.length - 1) return;
        if (column < 0 || column > this.grid[row].length - 1) return;
        if (visited[row][column] == true) return;
        if (grid[row][column] < maxValue) return;
        visited[row][column] = true;
        maxValue = grid[row][column];
        countArray[row][column]++;

        dfs(row+1,column,visited,maxValue);
        dfs(row,column+1,visited, maxValue);
        dfs(row-1,column,visited,maxValue);
        dfs(row,column-1,visited, maxValue);
    } 
}
// Input: heights = [
    // [1,2,2,3,5],
    // [3,2,3,4,4],
    // [2,4,5,3,1],
    // [6,7,1,4,5],
    // [5,1,1,2,4]
    // ]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]