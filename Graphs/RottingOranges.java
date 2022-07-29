package Leetcode.Graphs;

import java.util.LinkedList;
import java.util.List;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges r = new RottingOranges();
        int result = r.orangesRotting(new int[][]{
            {2,1,1},
            {1,1,0},
            {0,1,1}
        });
        System.out.println(result);
    }
    public int orangesRotting(int[][] grid) {
        int totalCount = grid.length * grid[0].length;
        int rottenCount = 0;
        int queueCount = 0;
        int totalMin = 0;
        List<int[]> queue = new LinkedList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 2) {
                    queue.add(new int[]{row, column});
                    queueCount++;
                } else if (grid[row][column] == 0) {
                    totalCount--;
                }
            }
        }

        while (!queue.isEmpty()) {
            if (queueCount == 0) {
                totalMin++;
                queueCount = queue.size();
            }
            int[] list = queue.remove(0);
            int row = list[0];
            int column = list[1];
            rottenCount++;
            queueCount--;

            if (row+1 < grid.length && grid[row+1][column] == 1) {
                grid[row+1][column] = 2;
                queue.add(new int[]{row+1,column});
            }
            if (row-1 >= 0 && grid[row-1][column] == 1) {
                grid[row-1][column] = 2;
                queue.add(new int[]{row-1,column});
            }
            if (column+1 < grid[0].length && grid[row][column+1] == 1) {
                grid[row][column+1] = 2;
                queue.add(new int[]{row,column+1});
            }
            if (column-1 >= 0 && grid[row][column-1] == 1) {
                grid[row][column-1] = 2;
                queue.add(new int[]{row,column-1});
            }
        }

        return rottenCount < totalCount ? -1 : totalMin;
    }
}

// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4