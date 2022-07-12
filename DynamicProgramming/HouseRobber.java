package Leetcode.DynamicProgramming;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int result = houseRobber.rob(new int[]{2,1,1,2});
        System.out.println(result);
    }

    public int rob(int[] nums) {
        int[] list = new int[nums.length+1];
        list[0] = 0;
        list[1] = nums[0];

        for (int i = 2; i < list.length; i++) {
            list[i] = Math.max(list[i-2] + nums[i-1], list[i-1]);
        }
        return list[list.length-1];
    }
}

// Input: nums = [1,2,3,1,100]
// Output: 4    
