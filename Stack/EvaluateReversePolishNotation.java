package Leetcode.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        int result = e.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println(result);
    }
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.valueOf(tokens[0]);
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = stack.pop();
                int a = stack.pop();

                if (tokens[i].equals("+")) {
                    int sum = a+b;
                    stack.add(sum);
                    total = sum;
                }
                else if (tokens[i].equals("-")) {
                    int difference = a - b;
                    stack.add(difference);
                    total = difference;
                }
                else if (tokens[i].equals("*")) {
                    int product = a*b;
                    stack.add(product);
                    total = product;
                }
                else {
                    int quotient = a / b;
                    stack.add(quotient);
                    total = quotient;
                }
                
            } else {
                stack.add(Integer.valueOf(tokens[i]));
            }
        }
        return total;
    }
}
// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9