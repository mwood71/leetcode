package Leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        int result = l.characterReplacement("ABAB", 2);
        System.out.println(result);
    }
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == null) {
                List<Integer> queue = new LinkedList<>();
                int a = 0;
                char targetChar = s.charAt(i);
                int counter = 0;

                while (counter < s.length()) {
                    if (s.charAt(counter) != targetChar) {
                        queue.add(counter);
                        if (queue.size() > k) {
                            int tempIndex = queue.remove(0);
                            a = tempIndex+1;
                        }
                    }
                    max = Math.max(max, (counter-a)+1);
                    counter++;
                }
                hm.put(s.charAt(i), i);
            }
        }
        return max;
    }
}
// Input: s = "ABAB", k = 2
// Output: 4