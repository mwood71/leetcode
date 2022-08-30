package Leetcode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations c = new Combinations();
        List<List<Integer>> r = c.combine(4, 2);
        System.out.println(r);
    }
    List<List<Integer>> results = new LinkedList<>();
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        List<Integer> dt = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dt.add(i);
        }
        dfs(new LinkedList<>(), 1, n);
        return results;

    }

    void dfs(List<Integer> combinations, int startIndex, int n) {
        if (combinations.size() == k) {
            results.add(new LinkedList<>(combinations));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            combinations.add(i);
            dfs(combinations, i + 1, n);
            combinations.remove(combinations.size()-1);
        }
    }
}

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]