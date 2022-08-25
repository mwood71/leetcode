package Leetcode.Matrix;

import java.util.LinkedList;
import java.util.List;

public class SprialMatrix {
    public static void main(String[] args) {
        SprialMatrix s = new SprialMatrix();
        List<Integer>r = s.spiralOrder(new int[][]{
            {1,2,3,4,5,6,7,8,9,10}
        });
        System.out.println(r);
    }
    List<Integer> result;
    int[][] matrix;
    public List<Integer> spiralOrder(int[][] matrix) {
        result = new LinkedList<>();
        this.matrix = matrix;

        int height = matrix.length;
        int width = matrix[0].length;
        int a = 0;
        int b = 0;

        while (height > 0 && width > 0) {
            add(new int[]{a,b}, height, width);
            a++;
            b++;
            height -= 2;
            width -= 2;
        }

        return result;

    }

    void add(int[] origin, int height, int width) {
        int a = origin[0];
        int b = origin[1];

        if (height == 1) {
            int counter = 0;
            while (counter < width) {
                result.add(matrix[a][b]);
                b++;
                counter++;
            }
            return;
        }

        if (width == 1) {
            int counter = 0;
            while (counter < height) {
                result.add(matrix[a][b]);
                a++;
                counter++;
            }
            return;
        }

        int[] topLeft = origin;
        int[] topRight = new int[]{a, b+width-1};
        int[] bottomRight = new int[]{a+height-1, b+width-1};
        int[] bottomLeft = new int[]{a+height-1, b};
        
        while (topLeft[1] < topRight[1]) {
            result.add(matrix[topLeft[0]][topLeft[1]]);
            topLeft[1]++;
        }
        while (topRight[0] < bottomRight[0]) {
            result.add(matrix[topRight[0]][topRight[1]]);
            topRight[0]++;
        }
        while (bottomRight[1] > bottomLeft[1]) {
            result.add(matrix[bottomRight[0]][bottomRight[1]]);
            bottomRight[1]--;
        }
        while (bottomLeft[0] > topLeft[0]) {
            result.add(matrix[bottomLeft[0]][bottomLeft[1]]);
            bottomLeft[0]--;
        }
    }
}
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// [
//     [1,2,3],
//     [4,5,6],
//     [7,8,9]
// ]