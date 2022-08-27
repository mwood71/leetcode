package Leetcode.Matrix;

import java.util.Arrays;

public class SpiralMatrixTwo {
    public static void main(String[] args) {
        SpiralMatrixTwo s = new SpiralMatrixTwo();
        int[][] r = s.generateMatrix(1);
        printArray(r);
    }
    
    int[][] arr;
    int counter = 1;
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][0];
        arr = new int[n][n];
        // set origin 
        int row = 0;
        int column = 0;
        // set number to count how many items to iterate over
        int iterateCount = n - 1;
        
        // create while loop that runs while iterationCount is greater than or equal to 0
        // if it is equlal to zero update the origin value, else run the method
        // pass in origin, counter, and iteration num to method
        while (iterateCount >= 0) {
            if (iterateCount == 0) {
                arr[row][column] = counter;
            } else {
                addValues(row, column, iterateCount);
            }
            row++;
            column++;
            iterateCount -= 2;
        }  
        return arr;
    }

    void addValues(int row, int column, int iterateCount) {
        // init values
        int[] topLeft = new int[]{row, column};
        int[] topRight = new int[]{row, column+iterateCount};
        int[] bottomRight = new int[]{row+iterateCount, column+iterateCount};
        int[] bottomLeft = new int[]{row+iterateCount, column};

        // top row
        for (int i = topLeft[1]; i < topRight[1]; i++) {
            arr[topLeft[0]][i] = counter;
            counter++;
        }
        
        // right column
        for (int i = topRight[0]; i < bottomRight[0]; i++) {
            arr[i][topRight[1]] = counter;
            counter++;
        }
        // bottom row
        for (int i = bottomRight[1]; i > bottomLeft[1]; i--) {
            arr[bottomRight[0]][i] = counter;
            counter++;
        }
        // left column
        for (int i = bottomLeft[0]; i > topLeft[0]; i--) {
            arr[i][bottomLeft[1]] = counter;
            counter++;
        }
    }

    static void printArray(int[][] r) {
        for (int i = 0; i < r.length; i++) {
            System.out.println(Arrays.toString(r[i]));
        }
    }
}
// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]


// 1 2 3 4
// 12 13 14 5
// 11 16 15 6
// 10 9 8 7

// 1 2 3
// 8 9 4
// 7 6 5
