package Leetcode.Stack;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> r = g.generateParenthesis(3);
        System.out.println(r);
    }
    List<String> results = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return results;
    }

    void dfs(int a, int b, String s) {
        if (b < a) return;
        if (a == 0 && b == 0) {
            results.add(s);
            return;
        }

        if (a > 0) dfs(a-1, b, s + "(");
        if (b > 0) dfs(a, b-1, s + ")");
    }
}
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]


