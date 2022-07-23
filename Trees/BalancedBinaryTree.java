package Leetcode.Trees;

public class BalancedBinaryTree {
    boolean isBalanced = true;
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node9, node20);
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println(balancedBinaryTree.isBalanced(node3));
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dfs(root);
        return isBalanced;
    }

    public int dfs(TreeNode root) {
        int right = 0;
        int left = 0;
        if (root.left != null) {
            left = dfs(root.left);
        }
        if (root.right != null) {
            right = dfs(root.right);
        }
        if (Math.abs(left - right) > 1) {
            this.isBalanced = false;
        };
        return Math.max(left, right) + 1;
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
// Input: root = [3,9,20,null,null,15,7]
// Output: true