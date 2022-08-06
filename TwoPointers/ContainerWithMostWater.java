package Leetcode.TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int result = c.maxArea(new int[]{2,3,4,5,18,17,6});
        System.out.println(result);
    }
    public int maxArea(int[] height) {
        int max = 0; 
        int  a = 0;
        int b = height.length-1;

        while (a < b) {
            int total = (b-a) * Math.min(height[a], height[b]);
            max = Math.max(total, max);
            if (height[a] > height[b]) {
                b--;
            } else {
                a++;
            }
        }
        return max;
    }
}
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49