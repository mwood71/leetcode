package Leetcode.ArraysAndHashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1,2,3,4})));
    }
    public int[] productExceptSelf(int[] nums) {
        int[] preorder = new int[nums.length];
        int[] postorder = new int[nums.length];

        preorder[0] = 1;
        postorder[postorder.length-1] = 1;

        for (int i = 1; i < preorder.length; i++) {
            preorder[i] = nums[i-1] * preorder[i-1];
        }

        for (int i = postorder.length - 2; i >= 0; i--) {
            postorder[i] = postorder[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = postorder[i] * preorder[i];
        }

        return nums;
    }
}
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// [1,1,2,6]
// [24,12,4,1]