package Leetcode.ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] s = new String[]{""};
        System.out.println(g.groupAnagrams(s));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        List<String> resultChecker = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tempArray = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray);

            boolean hasBeenSeen = false;
            for (int x = 0; x < resultChecker.size(); x++) {
                if (resultChecker.get(x).equals(sortedString)) {
                    results.get(x).add(strs[i]);
                    hasBeenSeen = true;
                } 
            }
            
            if (!hasBeenSeen) {
                resultChecker.add(sortedString);
                results.add(new ArrayList<>(Arrays.asList(strs[i])));
            }
            hasBeenSeen = false;
        }
        return results;
    }
}
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]