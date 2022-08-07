package Leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] r = d.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(r));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = temperatures.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= stack.peek()[0]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                results[i] = 0;
                stack.add(new int[]{temperatures[i], i});
            } else {
                results[i] = stack.peek()[1] - i;
                stack.add(new int[]{temperatures[i], i});
            }
        }
        return results;
    }
}
// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]