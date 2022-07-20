package Leetcode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    int[] nums;
    List<List<Integer>> results = new LinkedList<>();

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(new LinkedList<>(), 0);
        return results;
    }

    public void dfs(List<Integer> subsets, int currIndex) {
        results.add(new LinkedList<>(subsets));
        for (int i = currIndex; i < nums.length; i++) {
            subsets.add(nums[i]);
            dfs(subsets, i+1);
            subsets.remove(subsets.size()-1);
        }
    }
}
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]