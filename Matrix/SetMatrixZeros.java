package Leetcode.Matrix;

import java.util.Arrays;
import java.util.Stack;

public class SetMatrixZeros {
    public static void main(String[] args) {
        SetMatrixZeros s = new SetMatrixZeros();
        s.setZeroes(new int[][]{
            {1,0,1},{1,0,1},{1,1,1}
        });
    }
    int[][] matrix;
    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;
        Stack<Integer> stack = new Stack<>(); 
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    stack.add(row);
                    stack.add(column);
                }
            }
        }

        while (!stack.isEmpty()) {
            int column = stack.pop();
            int row = stack.pop();

            dfs(row-1, column, "UP");
            dfs(row+1, column, "DOWN");
            dfs(row, column-1, "LEFT");
            dfs(row, column+1, "RIGHT");
        }

        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]));
        }
    }

    void dfs(int row, int column, String direction) {
        if (row < 0 || row >= matrix.length) return;
        if (column < 0 || column >= matrix[row].length) return;

        matrix[row][column] = 0;

        if (direction.equals("UP")) dfs(row-1, column, "UP");
        if (direction.equals("DOWN")) dfs(row+1, column, "DOWN");
        if (direction.equals("LEFT")) dfs(row, column-1, "LEFT");
        if (direction.equals("RIGHT")) dfs(row, column+1, "RIGHT");
    }
}
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]