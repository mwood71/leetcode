package Leetcode.DynamicProgramming;

import java.util.Arrays;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] newArray1 = Arrays.copyOf(nums, nums.length);
        newArray1[0] = 0;
        System.arraycopy(nums, 0, newArray1, 1, nums.length - 1);

        int[] newArray2 = Arrays.copyOf(nums, nums.length);
        newArray2[0] = 0;
        System.arraycopy(nums, 1, newArray2, 1, nums.length - 1);

        return Math.max(robHelper(nums, newArray1), robHelper(nums, newArray2));


    }

    public int robHelper(int[] nums, int[] finalArray) {
        for (int i = 2; i < finalArray.length; i++) {
            finalArray[i] = Math.max(finalArray[i-2] + finalArray[i], finalArray[i-1]);
        }
        return finalArray[finalArray.length-1];
    }
}