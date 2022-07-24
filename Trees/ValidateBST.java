package Leetcode.Trees;

public class ValidateBST {
    boolean isValid = true;
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, node3);
        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(node2));
    }
    public boolean isValidBST(TreeNode root) {
        dfs(root, -Double.MAX_VALUE, Double.MAX_VALUE);
        return this.isValid;
    }

    public void dfs(TreeNode root, double min, double max) {
        if (root == null) return;
        if (root.val <= min || root.val >= max) {
            this.isValid = false;
            return;
        }
        dfs(root.left, min, root.val);
        dfs(root.right, root.val, max);
    }
}
// Input: root = [2,1,3]
// Output: true
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