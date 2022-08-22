package Leetcode.Greedy;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        System.out.println(j.canJump(new int[]{1,1}));
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int windowsLength = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            windowsLength -= 1;
            if (windowsLength <= 0 && nums[i] == 0) {
                return false;
            }
            windowsLength = Math.max(windowsLength, nums[i]);
        }
        return true;
    }
}

// Input: nums = [3,2,1,0,4]
// Output: false