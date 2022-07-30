package Leetcode.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        System.out.println( b.search(new int[]{5}, 5));
    }
    public int search(int[] nums, int target) {
        int a = 0;
        int b = nums.length - 1;

        while (a <= b) {
            int mid = (int)Math.ceil((a + b) / 2.0);
            if (nums[mid] == target) return mid;
            if (target > nums[mid]) {
                a = mid+1;
            } else {
                b = mid-1;
            }
        }
        return -1;
    }
}
// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4