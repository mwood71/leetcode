package Leetcode.BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] != target) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;
        int a = 0;
        int b = nums.length - 1;

        while (a < b) {
            int mid = a + (b-a) / 2;
            if (nums[mid] > nums[b]) {
                a = mid+1;
            } else {
                b = mid;
            }
        }

        if (target <= nums[nums.length-1]) {
            b = nums.length-1;
        } else {
            a = 0;
            b = b-1;
        }

        while (a <= b) {
            int mid = a+(b-a)/2;
            if (nums[mid] == target) return mid;
            if (target > nums[mid]) {
                a = mid+1;
            } else {
                b = mid - 1;
            }
        }
        return -1;
    }
}
// Input: nums = [7,0,1,2], target = 0
// Output: 4