package Leetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> list = new LinkedList<>();
        //    [[2],
        //    [3,4],
        //   [6,5,7],
        //  [4,1,8,3]]
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        System.out.println(t.minimumTotal(list));
        
    }

    Integer[][] cache;
    List<List<Integer>> triangle;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.cache = new Integer[triangle.size()][triangle.get(triangle.size()-1).size()];
        this.triangle = triangle;
        return dfs(0,0);
    }

    int dfs(int row, int column) {
        if (row == triangle.size()-1) return triangle.get(row).get(column);
        if (cache[row][column] != null) return cache[row][column];

        int path1 = dfs(row+1,column);
        int path2 = dfs(row+1, column+1);

        cache[row][column] = Math.min(path1, path2) + triangle.get(row).get(column);
        return cache[row][column];
    }
}
