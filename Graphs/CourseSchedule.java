package Leetcode.Graphs;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        boolean result = c.canFinish(2, new int[][]{{
            1,0}, {0,1}});
        System.out.println(result);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] classList = new int[numCourses];
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
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == top) {
                    classList[prerequisites[i][0]]--;
                    if (classList[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        for (int i = 0; i < classList.length; i++) {
            if (classList[i] > 0) return false;
        }
        return true;
    }
}
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true