package Leetcode.Matrix;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(3, 2));
    }
    int[][] cache;
    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        return dfs(0, 0);
    }

    int dfs(int row, int column) {
        if (row < 0 || row >= cache.length) return 0;
        if (column < 0 || column >= cache[row].length) return 0;
        if (row == cache.length-1 && column == cache[row].length-1) return 1;
        if (cache[row][column] != 0) return cache[row][column];

        cache[row][column] = dfs(row+1,column) + dfs(row, column+1);
        return cache[row][column];
    }

    void print() {
        for (int i = 0; i < cache.length; i++) {
            System.out.println(Arrays.toString(cache[i]));
        }
    }
}
// Input: m = 3, n = 2
// Output: 3

// x x
// x x
// x x



