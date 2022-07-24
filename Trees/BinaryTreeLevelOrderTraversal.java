package Leetcode.Trees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node9, node20);
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(node3));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> rowResults = new LinkedList<>();
        if (root == null) return results;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int queueCount = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            queueCount--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            rowResults.add(node.val);
            if (queueCount == 0) {
                queueCount = queue.size();
                results.add(rowResults);
                rowResults = new LinkedList<>();
            }
        }
        return results;
    }
}
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

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