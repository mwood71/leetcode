package Leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        int result = l.lengthOfLongestSubstring("aabaab!bb");
        System.out.println(result);
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == null) {
                hm.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, hm.size());
            } else {
                int index = hm.get(s.charAt(i));
                hm.put(s.charAt(i), i);
                Map<Character, Integer> temp = new HashMap<>(hm);
                for (Character key : temp.keySet()) {
                    if (hm.get(key) < index) {
                        hm.remove(key);
                    }
                }
            }
        }
        return maxLength;
    }
}
// Input: s = "abcabcbb"
// Output: 3