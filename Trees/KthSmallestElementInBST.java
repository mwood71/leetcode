package Leetcode.Trees;

public class KthSmallestElementInBST {
    int k;
    int count = 0;
    int result;
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node4 = new TreeNode(4, node2, node5);
        KthSmallestElementInBST kBst = new KthSmallestElementInBST();
        System.out.println(kBst.kthSmallest(node4, 1));
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return this.result;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        this.count++;
        if (count == this.k) this.result = root.val;
        dfs(root.right);
    }
}

// [4,2,5,null,3]
// 1
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