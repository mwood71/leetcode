package Leetcode.Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderPostOrder {
    public static void main(String[] args) {
        ConstructBinaryTreeInorderPostOrder c = new ConstructBinaryTreeInorderPostOrder();
        c.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
    Map<Integer, Integer> hm = new HashMap<>();
    int[] postorder;
    int[] inorder;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        index = postorder.length-1;
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return dfs(0, index);
    }

    TreeNode dfs(int a, int b) {
        if (a > b) return null;

        TreeNode node = new TreeNode(postorder[index]);
        int mid = hm.get(postorder[index]);
        index -= 1;

        node.right = dfs(mid+1, b);
        node.left = dfs(a, mid-1);
        return node;
    }
}
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

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