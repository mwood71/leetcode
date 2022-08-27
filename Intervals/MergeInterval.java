package Leetcode.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        MergeInterval m = new MergeInterval();
        int[][] r = m.merge(new int[][]{
            {1,4}, {0,4}
        });
        for (int i = 0; i < r.length; i++) {
            System.out.println(Arrays.toString(r[i]));
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{{}};
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] num1, int[] num2) {
                if (num1[0] < num2[0]) return -1;
                if (num1[0] == num2[0]) return 0;
                return 1;
            }
        });
        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][0]);
        int a = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > a) {
                list.add(a);
                list.add(intervals[i][0]);
                a = intervals[i][1];
            } else if (intervals[i][1] > a) {
                a = intervals[i][1];
            }
        }
        list.add(a);

        int[][] result = new int[list.size()/2][2];
        int index = 0;
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            if (index == 0) {
                result[counter][index] = list.get(i);
                index = 1;
            } else {
                result[counter][index] = list.get(i);
                index = 0;
                counter++;
            }
        }
        return result;  
    }
}
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]