package Leetcode.DynamicProgramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] list = new int[cost.length];
        list[0] = cost[0];
        list[1] = cost[1];

        for (int i = 2; i < list.length; i++) {
            list[i] = Math.min(list[i-1], list[i-2]) + cost[i];
        }
        return Math.min(list[list.length - 1], list[list.length - 2]);
    }
}


// Input: cost = [10,15,20]
// Output: 6      
