package Leetcode.DivideAndConquer;

import java.util.Arrays;

public class SortColors {
    int[] nums;
    public static void main(String[] args) {
        SortColors s = new SortColors();
        s.sortColors(new int[]{2,0,2,1,1,0});
        System.out.println(Arrays.toString(s.nums));
    }

    public void sortColors(int[] nums) {
        this.nums = nums;
        quickSort(0, nums.length-1);
    }

    void quickSort(int left, int right) {
        if (left >= right) return;
        int pivot = nums[right];
        int pivotIndex = right;

        int a = left;
        int b = right;

        while (a < b) {
            while (nums[a] <= pivot && a < b) {
                a++;
            }
            while (nums[b] >= pivot && b > a) {
                b--;
            }
            move(a,b);
        }
        move(a, pivotIndex);

        quickSort(left, a-1);
        quickSort(a+1, right);

    }

    void move(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]