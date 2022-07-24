package Leetcode.Trees;

import java.util.LinkedList;
import java.util.List;

public class BTRightSidedView {
    List<Integer> results = new LinkedList<>();
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3, null, node4);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        BTRightSidedView btRightSidedView = new BTRightSidedView();
        System.out.println(btRightSidedView.rightSideView(node1));;
    }

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return results;
    }

    public void dfs(TreeNode root, int treeLevel) {
        if (root == null) return;
        if (treeLevel > results.size()) {
            results.add(root.val);
        }
        dfs(root.right, treeLevel+1);
        dfs(root.left, treeLevel+1);
    }
}
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

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