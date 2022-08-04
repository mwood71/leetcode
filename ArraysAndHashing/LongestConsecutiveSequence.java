package Leetcode.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(new int[]{}));
    }
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, num);
        }

        int max = 0;

        for (int num : nums) {
            if (hm.get(num-1) == null) {
                int size = 1;
                while (hm.get(num+1) != null) {
                    num = num+1;
                    size++;
                }
                max = Math.max(size, max);
            }
        }
        return max;
    }
}
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4