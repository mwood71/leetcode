package Leetcode.Graphs;

import java.util.Arrays;

public class SurroundedRegions {
    int[][] grid;
    char[][] board;
    public static void main(String[] args) {
        char[][] grid = new char[][]{
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        SurroundedRegions s = new SurroundedRegions();
        s.solve(grid);
        for (int row = 0; row < grid.length; row++) {
            System.out.println(Arrays.toString(grid[row]));
        }
    }

    public void solve(char[][] board) {
        this.board = board;
        grid = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') {
                dfs(row, 0);
            }
            if (board[row][board[row].length-1] == 'O') {
                dfs(row, board[row].length-1);
            }
        }

        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column] == 'O') {
                dfs(0, column);
            }
            if (board[board.length-1][column] == 'O') {
                dfs(board.length-1, column);
            }
        }
        
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 1) {
                    board[row][column] = 'O';
                } else {
                    board[row][column] = 'X';
                }
            }
        }
    }

    void dfs(int row, int column) {
        if (row < 0 || row > grid.length - 1) return;
        if (column < 0 || column > grid[row].length - 1) return;
        if (board[row][column] != 'O') return;
        if (grid[row][column] == 1) return;
        grid[row][column]++;

        dfs(row-1,column);
        dfs(row,column+1);
        dfs(row+1,column);
        dfs(row,column-1);
    }
}
// Input: board = [
//     ["X","X","X","X"],
//     ["X","O","O","X"],
//     ["X","X","O","X"],
//     ["X","O","X","X"]
//     ]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]