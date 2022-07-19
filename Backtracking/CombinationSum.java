package Leetcode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    int[] candidates;
    int target;
    List<List<Integer>> result = new LinkedList<>();
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7}, 7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        dfs(candidates, new LinkedList<>(), target, 0);
        return result;
    }

    public void dfs(int[] candidates, List<Integer> combinations, int target, int index) {
        if (target == 0) {
            result.add(new LinkedList<>(combinations));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if ((target - candidates[i]) < 0) {
                continue;
            }
            combinations.add(candidates[i]);
            dfs(candidates, combinations, target - candidates[i], i);
            combinations.remove(combinations.size() - 1);
        }
    }

}
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]