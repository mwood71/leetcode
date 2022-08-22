package Leetcode.Greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 j = new JumpGame2();
        System.out.println(j.jump(new int[]{1,2,0,1}));
    }
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;

        int firstWindow = nums[0];
        int secondWindow = 0;
        int count = 1;

        for (int i = 1; i < nums.length - 1; i++) {
            firstWindow -= 1;
            secondWindow = Math.max(secondWindow, nums[i] - firstWindow);

            if (firstWindow <= 0) {
                firstWindow = secondWindow;
                secondWindow = 0;
                count++;
            }
        }
        return count;
    }
}
// Input: nums = [2,3,1,1,4]
// Output: 2