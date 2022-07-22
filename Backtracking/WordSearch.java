package Leetcode.Backtracking;

public class WordSearch {
    boolean[][] visited;
    char[][] board;
    String word;
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}};
        System.out.println(wordSearch.exist(board, "SEE"));;
    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        this.word = word;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (word.charAt(0) == board[row][column]) {
                    if (dfs(row, column, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int row, int column, int letterCount) {
        if (letterCount == word.length()) return true;
        if (row < 0 || row > board.length-1) return false;
        if (column < 0 || column > board[0].length - 1) return false;
        if (word.charAt(letterCount) != board[row][column]) return false;
        if (visited[row][column] == true) return false;

        visited[row][column] = true;

        if (dfs(row + 1, column, letterCount+1) || dfs(row, column + 1, letterCount+1) || 
        dfs(row-1, column, letterCount+1) || dfs(row, column-1, letterCount+1)) {
            return true;
        }

        visited[row][column] = false;
        return false;
    }
}
// Input: board = [["A","B","C","E"],
                // ["S","F","C","S"],
                // ["A","D","E","E"]], word = "SEE"
// Output: true