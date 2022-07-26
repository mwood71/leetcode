package Leetcode.Trees;

import java.util.HashMap;

public class ConstructBinaryTree {
    int index = 0;
    int[] inorder;
    int[] preorder;
    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        int[] inorder = new int[]{3,2,1};
        int[] preorder = new int[]{1,2,3};
        TreeNode result = constructBinaryTree.buildTree(preorder, inorder);
        print(result);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.inorder = inorder;
        this.preorder = preorder;
        return dfs(0, preorder.length - 1, map);
    }

    TreeNode dfs(int left, int right, HashMap<Integer, Integer> map) {
        int currValue = preorder[index++];
        int currIndex = (int) map.get(currValue);
        TreeNode root = new TreeNode(currValue);

        if (currIndex > left) {
            root.left = dfs(left, currIndex-1, map);
        }
        if (currIndex < right) {
            root.right = dfs(currIndex+1, right, map);
        }
        return root;
    }


    public static void print(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        print(node.left);
        print(node.right);
    } 

    
}
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
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
