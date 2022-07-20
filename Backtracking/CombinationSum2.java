package Leetcode.Backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    int[] candidates;
    int target;
    List<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        this.candidates = candidates;
        dfs(new LinkedList<>(), target, 0);
        return result;
       

    }

    public void dfs(List<Integer> combinations, int target, int currIndex) {
        if (target == 0) {
            result.add(new LinkedList<>(combinations));
            return;
        }

        for (int i = currIndex; i < candidates.length; i++) {
            if ((currIndex != i && candidates[i] == candidates[i-1])) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            combinations.add(candidates[i]);
            dfs(combinations, target - candidates[i], i+1);
            combinations.remove(combinations.size()-1);
        }
    }
}
// Input: candidates = [2,5,2,1,2], target = 5
