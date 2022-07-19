package Leetcode.Backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Permutation2 {
    List<List<Integer>> result = new LinkedList<>();
    int maxLength;
    public static void main(String[] args) {
        Permutation2 permutation2 = new Permutation2();
        System.out.println(permutation2.permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> dt = new HashMap<>();
        for (int num : nums) {
            if (dt.get(num) == null) {
                dt.put(num, 1);
            } else {
                dt.put(num, dt.get(num) + 1);
            }
        }
        maxLength = nums.length;
        dfs(dt, new LinkedList<>());
        return result;
    }

    private void dfs(Map<Integer, Integer> dt, List<Integer> permutations) {
        if (dt.isEmpty()) {
            result.add(new LinkedList<>(permutations));
            return;
        }

        HashMap<Integer, Integer> iterateHm = new HashMap<>(dt);
        for (Integer key : iterateHm.keySet()) {
            if (dt.get(key) == 1) {
                dt.remove(key);
            } else {
                dt.put(key, dt.get(key) - 1);
            }
            permutations.add(key);
            dfs(dt, permutations);
            if (dt.get(key) == null) {
                dt.put(key, 1);
            } else {
                dt.put(key, dt.get(key) + 1);
            }
            permutations.remove(permutations.size() - 1);
        }
    }
}