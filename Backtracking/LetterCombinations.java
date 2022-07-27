package Leetcode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> r = letterCombinations.letterCombinations("23");
        System.out.println(r);
    }
    List<String> results = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new LinkedList<>();
        char[][] numbers = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };

        List<char[]> dt = new LinkedList<>();

        for (int i = 0; i < digits.length(); i++) {
            int a = Character.getNumericValue(digits.charAt(i));
            if (a != 1 && a != 0) {
                dt.add(numbers[a-2]);
            }
        }

        dfs(dt, new String(), 0);
        return results;
        
    }

    void dfs(List<char[]> dt, String combinations, int index) {
        if (index >= dt.size()) {
            results.add(new String(combinations));
            return;
        }
        for (int i = index; i < dt.size(); i++) {
            if (index != i) continue;
            for (int x = 0; x < dt.get(i).length; x++) {
                combinations += dt.get(i)[x];
                dfs(dt, combinations, index+1);
                combinations = combinations.substring(0, combinations.length()-1);
            }
        }
    }
}
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
