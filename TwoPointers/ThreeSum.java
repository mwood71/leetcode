package Leetcode.TwoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        List<List<Integer>> result = t.threeSum(new int[]{0,0,0,0});
        System.out.println(result);
    }
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;

            int a = i+1;
            int b = num.length-1;

            while (a < b) {
                int sum = num[i] + num[a] + num[b];
                if (sum == 0) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(num[i]);
                    temp.add(num[a]);
                    temp.add(num[b]);
                    result.add(temp);  
                    while (a < b && num[a] == num[a+1]) a++;
                    a++;

                } else if (sum < 0) {
                    while (a < b && num[a] == num[a+1]) a++;
                    a++;
                } else {
                    while (a < b && num[b] == num[b-1]) b--;
                    b--;
                }
            }
        }
        return result;
    }
}
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// -4 -1 -1 0 1 2 