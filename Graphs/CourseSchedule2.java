package Leetcode.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1,0},{2,0},{3,1},{3,2}
        };
        CourseSchedule2 c = new CourseSchedule2();
        int[] result = c.findOrder(4, grid);
        System.out.println(Arrays.toString(result));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] classList = new int[numCourses];
        int[] results = new int[numCourses];
        int resultIndex = 0;

        for (int i = 0; i < prerequisites.length; i++) {
            classList[prerequisites[i][0]]++;
        }

        List<Integer> queue = new LinkedList<>();

        for (int i = 0; i < classList.length; i++) {
            if (classList[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int top = queue.remove(0);
            results[resultIndex++] = top;

            for (int i = 0; i < prerequisites.length; i++) {
                if (top == prerequisites[i][1]) {
                    classList[prerequisites[i][0]]--;

                    if (classList[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        for (int i = 0; i < classList.length; i++) {
            if (classList[i] != 0) {
                return new int[]{};
            }
        }
        return results;
    }
}
// Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,2,1,3]