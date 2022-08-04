package Leetcode.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    char[][] board;
    public static void main(String[] args) {
        String[][]arr = new String[][]{
            {".",".",".",".","5",".",".","1","."},
            {".","4",".","3",".",".",".",".","."},
            {".",".",".",".",".","3",".",".","1"},
            {"8",".",".",".",".",".",".","2","."},
            {".",".","2",".","7",".",".",".","."},
            {".","1","5",".",".",".",".",".","."},
            {".",".",".",".",".","2",".",".","."},
            {".","2",".","9",".",".",".",".","."},
            {".",".","4",".",".",".",".",".","."}
        };

        String tempString = "";
        char[][] charArray = new char[arr.length][arr[0].length];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                tempString += arr[row][column];
            }
            charArray[row] = tempString.toCharArray();
            tempString = "";
        }

        ValidSudoku v = new ValidSudoku();
        System.out.println(v.isValidSudoku(charArray));
    }
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] != '.' && (!validRow(row, column) || !validColumn(row, column)
                 || !validGrid(row, column))) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean validRow(int row, int column) {
        Map<Character, Character> hm = new HashMap<>();
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != '.') {
                if (hm.get(board[row][i]) != null) {
                    return false;
                }
                hm.put(board[row][i], board[row][i]);
            }
        }
        return true;
    }

    boolean validColumn(int row, int column) {
        Map<Character, Character> hm = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != '.') {
                if (hm.get(board[i][column]) != null) {
                    return false;
                }
                hm.put(board[i][column], board[i][column]);
            }
        }
        return true;
    }

    boolean validGrid(int row, int column) {
        System.out.println("vlue: " + board[row][column]);
        System.out.println("row: " + row + ", column: " + column);
        MinAndMax m = getValues(row, column);
        System.out.println("row min: " + m.rowMin + ", row max: " + m.rowMax);
        System.out.println("column min: " + m.columnMin + ", column max: " + m.columnMax);
        Map<Character, Character> hm = new HashMap<>();
        for (int y = m.rowMin; y <= m.rowMax; y++) {
            for (int x = m.columnMin; x <= m.columnMax; x++) {
                if (board[y][x] != '.') {
                    if (hm.get(board[y][x]) != null) {
                        return false;
                    }
                    hm.put(board[y][x], board[y][x]);
                }
            }
        }
        return true;
    }

    MinAndMax getValues(int row, int column) {
        row = row / 3;
        column = column / 3;

        String combo = "" + row + column;
        MinAndMax m = new MinAndMax();

        switch (combo) {
            case "00" : {
                m.rowMin = 0;
                m.rowMax = 2;
                m.columnMin = 0;
                m.columnMax = 2;
                break;
            }
            case "01" : {
                m.rowMin = 0;
                m.rowMax = 2;
                m.columnMin = 3;
                m.columnMax = 5;
                break;
            }
            case "02" : {
                m.rowMin = 0;
                m.rowMax = 2;
                m.columnMin = 6;
                m.columnMax = 8;
                break;
            }
            case "10" : {
                m.rowMin = 3;
                m.rowMax = 5;
                m.columnMin = 0;
                m.columnMax = 2;
                break;
            }
            case "11" : {
                m.rowMin = 3;
                m.rowMax = 5;
                m.columnMin = 3;
                m.columnMax = 5;
                break;
            }
            case "12" : {
                m.rowMin = 3;
                m.rowMax = 5;
                m.columnMin = 6;
                m.columnMax = 8;
                break;
            }
            case "20" : {
                m.rowMin = 6;
                m.rowMax = 8;
                m.columnMin = 0;
                m.columnMax = 2;
                break;
            }
            case "21" : {
                m.rowMin = 6;
                m.rowMax = 8;
                m.columnMin = 3;
                m.columnMax = 5;
                break;
            }
            case "22" : {
                m.rowMin = 6;
                m.rowMax = 8;
                m.columnMin = 6;
                m.columnMax = 8;
            }
        }
        return m;
    }
}

class MinAndMax {
    int rowMin;
    int rowMax;
    int columnMin;
    int columnMax;
}



// [".",".",".",".","5",".",".","1","."],
// [".","4",".","3",".",".",".",".","."],
// [".",".",".",".",".","3",".",".","1"],
// ["8",".",".",".",".",".",".","2","."],
// [".",".","2",".","7",".",".",".","."],
// [".","1","5",".",".",".",".",".","."],
// [".",".",".",".",".","2",".",".","."],
// [".","2",".","9",".",".",".",".","."],
// [".",".","4",".",".",".",".",".","."]