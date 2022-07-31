package Leetcode.BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
        System.out.println(f.findMin(new int[]{3,4,5,1,2}));
    }

    public int findMin(int[] nums) {
        int a = 0;
        int b = nums.length-1;

        while (a < b) {
            int mid = a+(b-a)/2;
            if (nums[mid] > nums[b]) {
                a = mid+1;
            } else {
                b = mid;
            }
        }
        return nums[a];
    } 
}
// Input: nums = [3,4,5,1,2]
// Output: 1