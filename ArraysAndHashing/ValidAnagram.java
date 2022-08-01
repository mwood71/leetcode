package Leetcode.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram("anagram", "nagaran"));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.get(s.charAt(i)) == null) {
                sMap.put(s.charAt(i), 0);
            } else {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            }

            if (tMap.get(t.charAt(i)) == null) {
                tMap.put(t.charAt(i), 0);
            } else {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            }
        }

        
        return tMap.equals(sMap) ? true : false;
    }
}
// Input: s = "anagram", t = "nagaram"
// Output: true