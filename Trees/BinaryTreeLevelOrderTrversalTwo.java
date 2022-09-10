package Leetcode.Trees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTrversalTwo {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        BinaryTreeLevelOrderTrversalTwo b = new BinaryTreeLevelOrderTrversalTwo();
        System.out.println(b.levelOrderBottom(node3));;
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<TreeNode> currStack = new LinkedList<>();
        List<TreeNode> nextStack = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        currStack.add(root);
        List<Integer> list = new LinkedList<>();

        while (!currStack.isEmpty()) {
            TreeNode node = currStack.remove(0);
            list.add(node.val);
            if (node.left != null) nextStack.add(node.left);
            if (node.right != null) nextStack.add(node.right);

            if (currStack.isEmpty()) {
                List<TreeNode> temp = currStack;
                currStack = nextStack;
                nextStack = temp;
                result.add(0, list);
                list = new LinkedList<Integer>();
            }
        }
        return result;
    }
}
// Input: root = [3,9,20,null,null,15,7]
// Output: [[15,7],[9,20],[3]]

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