package Leetcode.Trees;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees u = new UniqueBinarySearchTrees(); 
        System.out.println( u.numTrees(18));
    }
    Integer[] cache;
    public int numTrees(int n) {
        cache = new Integer[n+1];
        return dfs(n);
    }

    int dfs(int n) {
       if (n <= 1) return 1; 
       if (cache[n] != null) return cache[n];

       int total = 0;

       for (int i = 1; i <= n; i++) {
        int leftParam = i-1;
        cache[leftParam] = dfs(leftParam);
        int rightparam = n-i;
        cache[rightparam] = dfs(rightparam);
        total += cache[rightparam]*cache[leftParam];
       }
       return total;
    }
}
// Input: n = 3
// Output: 5
