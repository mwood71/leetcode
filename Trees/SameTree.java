package Leetcode.Trees;

public class SameTree {
    boolean isSameTree = true;
    public static void main(String[] args) {
        TreeNode list1_node3 = new TreeNode(3);
        TreeNode list1_node2 = new TreeNode(2);
        TreeNode list1_node1 = new TreeNode(1, list1_node2, list1_node3);
        TreeNode list2_node3 = new TreeNode(3);
        TreeNode list2_node2 = new TreeNode(2);
        TreeNode list2_node1 = new TreeNode(1, list2_node2, list2_node3);
        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(list1_node1, list2_node1));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);
        return isSameTree;
    }

    public void dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return;
        if (p != null && q == null) {
            this.isSameTree = false;
            return;
        };
        if (p == null && q != null) {
            this.isSameTree = false;
            return;
        };
        if (p != null && q != null && p.val != q.val) {
            this.isSameTree = false;
            return;
        };
        isSameTree(p.left, q.left);
        isSameTree(p.right, q.right);
    }
}
// Input: p = [1,2,3], q = [1,2,3]
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