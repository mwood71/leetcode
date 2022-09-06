package Leetcode.Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.xml.transform.Templates;

public class BinaryTreeZigzag {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        BinaryTreeZigzag b = new BinaryTreeZigzag();
        System.out.println(b.zigzagLevelOrder(node1));
        b.zigzagLevelOrder(node1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> currStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();

        currStack.add(root);
        boolean leftToRight = true;
        List<Integer> temp = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        while (!currStack.isEmpty()) {
            TreeNode node = currStack.pop();
            temp.add(node.val);
            

            if (leftToRight) {
                if (node.left != null) {
                    nextStack.add(node.left);
                }
                if (node.right != null) {
                    nextStack.add(node.right);
                }
            } else {
                if (node.right != null) {
                    nextStack.add(node.right);
                }
                if (node.left != null) {
                    nextStack.add(node.left);
                }
            }

            if (currStack.isEmpty()) {
                Stack<TreeNode> t = currStack;
                currStack = nextStack;
                nextStack = t;
                leftToRight = !leftToRight;

                result.add(temp);
                temp = new LinkedList<>();
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}