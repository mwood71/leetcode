package Leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        PermutationInString p = new PermutationInString();
        boolean result = p.checkInclusion("ab", "eidbaooo");
        System.out.println(result);
    }
    public boolean checkInclusion(String s1, String s2){
        if (s1.length() == 0) return true;
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> hm = new HashMap<>();
        Map<Character, Integer> compareHm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
            compareHm.put(s2.charAt(i), compareHm.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (hm.equals(compareHm)) return true;

        int a = 0;
        int b = s1.length();

        while (b < s2.length()) {
            if (compareHm.get(s2.charAt(a)) == 1) {
                compareHm.remove(s2.charAt(a));
            } else {
                compareHm.put(s2.charAt(a), compareHm.get(s2.charAt(a))-1);
            }
            compareHm.put(s2.charAt(b), compareHm.getOrDefault(s2.charAt(b), 0) + 1);

            if (hm.equals(compareHm)) return true;

            a++;
            b++;
        }
        return false;
    }
}