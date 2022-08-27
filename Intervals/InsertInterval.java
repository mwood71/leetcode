package Leetcode.Intervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval i = new InsertInterval();
        int[][] r = i.insert(new int[][]{
            {1,5}
        }, new int[]{6,8});
        for (int x = 0; x < r.length; x++) {
            System.out.println(Arrays.toString(r[x]));
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{
                {newInterval[0], newInterval[1]}
            };
        }
        if (newInterval.length == 0) return intervals;

        List<Integer> result = new LinkedList<>();
        // add all the pairs that the lesser newInterval is greater than
        int index = 0;
        boolean completedArray = true;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i][0]);
                result.add(intervals[i][1]);
            } else {
                index = i;
                completedArray = false;
                break;
            }
        }

        if (completedArray) {
            result.add(newInterval[0]);
            result.add(newInterval[1]);
            return generateResult(result);
        }

        // add the lesser of the interval[i][0] and newinterval[0]
        if (intervals[index][0] < newInterval[0]) {
            result.add(intervals[index][0]);
        } else {
            result.add(newInterval[0]);
        }

        boolean valueAdded = false;
        // dont add newInterval[1] unless its greater than interval[i][1] but lesser than interval[i+1][0]
        for (int i = index; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval[1]);
                index = i;
                valueAdded = true;
                break;
            } else if (newInterval[1] <= intervals[i][1]) {
                result.add(intervals[i][1]);
                index = i + 1;
                valueAdded = true;
                break;
            }
        }

        if (!valueAdded) {
            result.add(newInterval[1]);
        } else {
            // add any remaining intervals to the result
            for (int i = index; i < intervals.length; i++) {
                result.add(intervals[i][0]);
                result.add(intervals[i][1]);
            }
        }

        return generateResult(result);

    }

    int[][] generateResult(List<Integer> result) {
        int[][] arr = new int[result.size()/2][2]; 
        int index = 0;
        int counter = 0;

        for (int i = 0; i < result.size(); i++) {
            if (index == 0) {
                arr[counter][index] = result.get(i);
                index = 1;
            } else {
                arr[counter][index] = result.get(i);
                index = 0;
                counter++;
            }
        }
        return arr;
    }
}

// 1  3  

// a = 8

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]