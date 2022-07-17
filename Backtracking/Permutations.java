package Leetcode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> dt = new LinkedList<>();
        for (int num : nums) {
            dt.add(num);
        }

        dfs(dt, new LinkedList<>());
        return result;
    }


    public void dfs(List<Integer> dt, List<Integer> permutation) {
        if (dt.isEmpty()) {
            List<Integer> copy = new LinkedList<>(permutation);
            result.add(copy);
            return;
        }

        for (int i = 0; i < dt.size(); i++) {
            Integer integer = dt.remove(i);
            permutation.add(integer);
            dfs(dt, permutation);
            dt.add(i, integer);
            permutation.remove(permutation.size()-1);
        }
    }
}
