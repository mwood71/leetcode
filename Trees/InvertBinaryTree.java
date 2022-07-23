package Leetcode.Trees;

import java.util.LinkedList;
import java.util.List;

import Leetcode.Trees.TreeNode;

public class InvertBinaryTree {
    public static void printTree(TreeNode root) {
        List<TreeNode> treeNodes = new LinkedList<>();
        if (root != null)  treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode polledNode = treeNodes.remove(0);
            System.out.println(polledNode.val);
            if (polledNode.left != null) {
                treeNodes.add(polledNode.left);
            }
            if (polledNode.right != null) {
                treeNodes.add(polledNode.right);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node7 = new TreeNode(7, node6, node9);
        TreeNode node4 = new TreeNode(4, node2, node7);
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode resultNode = invertBinaryTree.invertTree(node4);
        printTree(resultNode);
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root;
        dfs(temp);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
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
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]