package Leetcode.Trees;

public class CountGoodNodesInBT {
    int goodNodeCount = 0;
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4, node1, node5);
        TreeNode node1_2 = new TreeNode(1, node3, null);
        TreeNode node3_2 = new TreeNode(3, node1_2, node4);
        CountGoodNodesInBT countGoodNodesInBT = new CountGoodNodesInBT();
        System.out.println(countGoodNodesInBT.goodNodes(node3_2));
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return this.goodNodeCount;
    }

    public void dfs(TreeNode root, int maxNode) {
        if (root == null) return;
        if (root.val >= maxNode) {
            goodNodeCount++;
            maxNode = root.val;
        }
        dfs(root.left, maxNode);
        dfs(root.right, maxNode);
    }
    
}
// Input: root = [3,1,4,3,null,1,5]
// Output: 4
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