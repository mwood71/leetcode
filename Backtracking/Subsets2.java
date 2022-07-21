package Leetcode.Backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2 {
    List<List<Integer>> result = new LinkedList<>();
    int[] nums;
    public static void main(String[] args) {
        Subsets2 subsets2 = new Subsets2();
        System.out.println(subsets2.subsetsWithDup(new int[]{4,4,4,1,4}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        dfs(new LinkedList<>(), 0);
        return result;
    }

    public void dfs(List<Integer> subsets, int currIndex) {
        result.add(new LinkedList<>(subsets));
        for (int i = currIndex; i < nums.length; i++) {
            if (currIndex != i && nums[i] == nums[i-1]) {
                continue;
            }
            subsets.add(nums[i]);
            dfs(subsets, i+1);
            subsets.remove(subsets.size()-1);
        }
    }
}


// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]