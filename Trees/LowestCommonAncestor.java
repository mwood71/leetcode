package Leetcode.Trees;

public class LowestCommonAncestor {
    TreeNode resultNode = null;
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4, node3, node5);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8, node7, node9);
        TreeNode node2 = new TreeNode(2, node0, node4);
        TreeNode node6 = new TreeNode(6, node2, node8);
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode result = lowestCommonAncestor.lowestCommonAncestor(node6, new TreeNode(2), new TreeNode(8));
        System.out.println(result.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6

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