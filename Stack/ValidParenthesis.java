package Leetcode.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis v = new ValidParenthesis();
        boolean result = v.isValid("([])");
        System.out.println(result);
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put(']', '[');
        hm.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == null) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || hm.get(s.charAt(i)) != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }   
}
// Input: s = "()[]{}"
// Output: true