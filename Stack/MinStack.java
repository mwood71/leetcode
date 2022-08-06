package Leetcode.Stack;

import java.util.Stack;

class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (minStack.isEmpty()) {
            stack.push(val);
            minStack.push(val);
            return;
        } 
        if (val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if (!minStack.isEmpty() && stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]