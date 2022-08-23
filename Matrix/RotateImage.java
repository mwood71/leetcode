package Leetcode.Matrix;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        r.rotate(new int[][]{
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}});
    }
    int[][] matrix;
    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        int[] origin = new int[]{0,0};
        int length = matrix.length;
        int iterations = length/2;
        int counter = 0;

        while (counter < iterations) {
            rotate(origin, length);
            length -= 2;
            origin[0] += 1;
            origin[1] += 1;
            counter++;
        } 

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    void rotate(int[] origin, int length) {

        int counter = 0;
        int row = origin[0];
        int column = origin[1];

        while (counter < length - 1) {
            int topLeft = matrix[row][column+counter];
            int topRight = matrix[row+counter][column+length-1];
            int bottomRight = matrix[row+length-1][column+length-1-counter];
            int bottomLeft = matrix[row+length-1-counter][column];
    
            matrix[row][column+counter] = bottomLeft;
            matrix[row+counter][column+length-1] = topLeft;
            matrix[row+length-1][column+length-1-counter] = topRight;
            matrix[row+length-1-counter][column] = bottomRight;

            counter++;
        }
    }
}
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]