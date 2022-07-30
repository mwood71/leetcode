package Leetcode.Graphs;

import java.util.Arrays;

public class RedundantConnection {
    int[] sizes;
    int[] parents;
    public static void main(String[] args) {
        RedundantConnection r = new RedundantConnection();
        int[][] grid = new int[][]{{1,2},{1,3},{2,3}};
         System.out.println(Arrays.toString(r.findRedundantConnection(grid)));
    }
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length];
        sizes = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }

        int[] result = new int[]{};

        for (int i = 0; i < edges.length; i++) {
            int a = getParent(edges[i][0] - 1);
            int b = getParent(edges[i][1] - 1);

            if (a == b) {
                result = edges[i];
            };

            if (sizes[a] > sizes[b]) {
                parents[b] = a;
                sizes[a] += sizes[b];
            } else {
                parents[a] = b;
                sizes[b] += sizes[a];
            }
        }

        return result;
    }

    int getParent(int i) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return i;
    }
}
// Input: edges = [[1,2],[1,3],[2,3]]
// Output: [2,3]