package Leetcode.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate c = new ContainsDuplicate();
        System.out.println(c.containsDuplicate(new int[]{1,2,3}));
    }
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.get(nums[i]) != null) {
                return true;
            }
            hm.put(nums[i], nums[i]);
        }
        return false;
    }
}
// Input: nums = [1,2,3,1]
// Output: true