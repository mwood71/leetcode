package Leetcode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> results = new LinkedList<>();
    String s;
    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));;
    }
    public List<List<String>> partition(String s) {
        this.s = s;
        s.toCharArray();
        dfs(new LinkedList<>(), 0);
        return results;
    }

    public void dfs(List<String> subsets, int currIndex) {
        if (currIndex >= s.length()) {
            results.add(new LinkedList<>(subsets));
            return;
        }
        for (int i = currIndex; i < s.length(); i++) {
            if (!isPalindrome(currIndex, i)) continue;
            subsets.add(s.substring(currIndex, i+1));
            dfs(subsets, i+1);
            subsets.remove(subsets.size()-1);
        }
    }

    public boolean isPalindrome(int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }  
            left++;
            right--;
        }
        return true;
    }
}
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]