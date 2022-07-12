package Leetcode.DynamicProgramming;

class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println( climbStairs.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] list = new int[n+1];
        list[0] = 1;
        list[1] = 1;

        for (int i = 2; i < list.length; i++) {
            list[i] = list[i-1] + list[i-2];
        }
        return list[n];
    }
    
}