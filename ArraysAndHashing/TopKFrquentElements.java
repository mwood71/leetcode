package Leetcode.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrquentElements {
    public static void main(String[] args) {
        TopKFrquentElements t = new TopKFrquentElements();
        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] results = new int[k];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.get(nums[i]) == null) {
                hm.put(nums[i], 1);
            } else {
                hm.put(nums[i], hm.get(nums[i])+1);
            }
        }

        while (k > 0) {
            int maxNum = 0;
            int maxNumCount = 0;
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if (entry.getValue() > maxNumCount) {
                    maxNum = entry.getKey();
                    maxNumCount = entry.getValue();
                }
            }
            hm.remove(maxNum);
            results[k-1] = maxNum;
            k--;
        }
        return results;
    }
}
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]