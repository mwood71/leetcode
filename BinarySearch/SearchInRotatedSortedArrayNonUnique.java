package Leetcode.BinarySearch;

public class SearchInRotatedSortedArrayNonUnique {
    int[] nums;
    public static void main(String[] args) {
        SearchInRotatedSortedArrayNonUnique s = new SearchInRotatedSortedArrayNonUnique();
        boolean result = s.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2);
        System.out.println(result);
    }
    public boolean search(int[] nums, int target) {
        this.nums = nums;
        int mid = -1;
        int a = 0; 
        int b = nums.length-1;

        while (a < b) {
            mid = a+(b-a)/2;
            if (nums[mid] == nums[b]) {
                mid = (furthestRight(mid, nums[mid]) + 1) > nums.length-1 ? b : furthestRight(mid, nums[mid]) + 1;
            }

            if (nums[mid] > nums[b]) {
                a = furthestRight(mid, nums[mid]) + 1;
            } else {
                b = furthestLeft(mid, nums[mid]);
            }
        }
        int start = furthestLeft(a, nums[a]);
        
        if (target > nums[nums.length-1]) {
            a = 0;
            b = start == 0 ? 0 : start - 1;
        } else {
            a = start;
            b = nums.length-1;
        }

        while (a <= b) {
            int midIndex = a+(b-a)/2;
            if (nums[midIndex] == target) return true;

            if (target > nums[midIndex]) {
                a = furthestRight(midIndex, nums[midIndex]) + 1;
            } else {
                b = furthestLeft(midIndex, nums[midIndex]) - 1;
            }
        }
        return false;

    }

    int furthestLeft(int i, int value) {
        while (i >= 0) {
            if (nums[i] != value) break;
            i--;
        }
        return i + 1;
    }

    int furthestRight(int i, int value) {
        while (i <= nums.length-1) {
            if (nums[i] != value) break;
            i++;
        }
        return i - 1;
    }
}
// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true