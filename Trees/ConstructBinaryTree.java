package Leetcode.Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        int[] inorder = new int[]{9,3,15,20,7};
        int[] preorder = new int[]{3,9,20,15,7};
        TreeNode result = constructBinaryTree.buildTree(preorder, inorder);
        print(result);
    }

    int index = 0;
    int[] preorder;
    Map<Integer, Integer> hm;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        this.hm = hm;

        return dfs(0,preorder.length-1);
    }

    TreeNode dfs(int a, int b) {
        if (a > b) return null;

        int currNum = preorder[index];
        index++;
        int inorderIndex = hm.get(currNum);

        TreeNode currNode = new TreeNode(currNum);

        currNode.left = dfs(a, inorderIndex-1);
        currNode.right = dfs(inorderIndex+1, b);
        return currNode;
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