package Leetcode.BinarySearch;

public class Search2dMatrix {
    public static void main(String[] args) {
        Search2dMatrix s = new Search2dMatrix();
        int[][] matrix = new int[][]{
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        System.out.println(s.searchMatrix(matrix, 2));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length-1]) {
                if (binarySearch(0, matrix[i].length-1, matrix[i], target)) return true;
                return false;
            }
        }
        return false;
    }   

    boolean binarySearch(int a, int b, int[] arr, int target) {
        while (a <= b) {
            int mid = (int)Math.ceil((a+b)/2.0);
            if (arr[mid] == target) return true;
            if (target > arr[mid]) {
                a = mid+1;
            } else {
                b = mid-1;
            }
        }
        return false;
    }
}
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true