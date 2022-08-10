package Leetcode.LinkedList;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        int r = f.findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(r);
    }
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } 
        slow = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
// Input: nums = [1,3,4,2,2]
// Output: 2  