package Leetcode.TwoPointers;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        TwoSum2 t = new TwoSum2();
        System.out.println(Arrays.toString(t.twoSum(new int[]{2,7,11,15}, 9)));
    }
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length-1;
        int[] resultArray = new int[2];

        while (a < b) {
            int result = numbers[a] + numbers[b];
            if (result == target) resultArray = new int[]{a+1,b+1};
            if (result > target) {
                b--;
            } else {
                a++;
            }
        }

        return resultArray;
    }
}
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].