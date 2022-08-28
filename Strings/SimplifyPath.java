package Leetcode.Strings;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/a/b/.."));
    }
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (temp.length() > 0) {
                    stack.add(temp);
                    temp = "";
                }
            } else {
                temp += c;
            }
        }
        if (temp.length() > 0) stack.add(temp);

        String result = "";
        while (!stack.isEmpty()) {
            String s = stack.pop();
            if (s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                int count = 1;
                while (!stack.isEmpty() && count > 0) {
                    String str = stack.pop();
                    if (str.equals("..")) {
                        count++;
                        continue;
                    }

                    if (str.equals(".")) {
                        continue;
                    } else {
                        count--;
                    }

                }
            } else {
                result = "/" + s + result;
            }
        }
        return result.length() == 0 ? "/" : result; 
    }
}
// Input: path = "/home//foo/"
// Output: "/home/foo"