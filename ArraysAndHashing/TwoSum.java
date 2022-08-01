package Leetcode.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        System.out.println(Arrays.toString(t.twoSum(new int[]{2,7,11,15}, 9)));
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int neededNum = target - nums[i];
            if (hm.get(neededNum) != null) {
                result = new int[]{hm.get(neededNum), i};
                break;
            }
            hm.put(nums[i], i);
        }
        return result;
    }
}
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].