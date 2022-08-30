package Leetcode.ArraysAndHashing;

public class RemoveDuplicatesSortedArrayTwo {
    public static void main(String[] args) {
        RemoveDuplicatesSortedArrayTwo r = new RemoveDuplicatesSortedArrayTwo();
        System.out.println(r.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
    int[] nums;
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        this.nums = nums;
        int nullPointer = nums[0] - 1;
        int nullPointerCount = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i-1] && nums[i] == nums[i-2]) {
                nums[i-2] = nullPointer;
                nullPointerCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nullPointer) {
                int index = i+1;
                while (index < nums.length) {
                    if (nums[index] != nullPointer) {
                        swap(i, index);
                        break;
                    }
                    index++;
                }
            }
        }

        return nums.length - nullPointerCount;
    }

    void swap(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// Input: nums = [1,1,1,2,2,3]
// Output: 5, nums = [1,1,2,2,3,_]