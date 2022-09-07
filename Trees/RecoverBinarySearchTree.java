package Leetcode.Trees;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        node3.right = node2;
        RecoverBinarySearchTree r = new RecoverBinarySearchTree();
        r.recoverTree(node1);
        System.out.println(node1.val);
        System.out.println(node1.left.val);
    }
    TreeNode node1;
    TreeNode node2;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (pre == null) {
            pre = node;
        } else {
            if (pre.val > node.val) {
                if (node1 == null) {
                    node1 = pre;
                }
                node2 = node;
            } 
            pre = node;
        }
        inorder(node.right);
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