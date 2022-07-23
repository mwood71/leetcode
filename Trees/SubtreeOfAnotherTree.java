package Leetcode.Trees;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode list1_node2 = new TreeNode(2);
        TreeNode list1_node1 = new TreeNode(1);
        TreeNode list1_node5 = new TreeNode(5);
        TreeNode list1_node4 = new TreeNode(4, list1_node1, list1_node2);
        TreeNode list1_node3 = new TreeNode(3, list1_node4, list1_node5);

        TreeNode list2_node2 = new TreeNode(2);
        TreeNode list2_node1 = new TreeNode(1);
        TreeNode list2_node4 = new TreeNode(4, list2_node1, list2_node2);
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        System.out.println(subtreeOfAnotherTree.isSubtree(list1_node3, list2_node4));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (sameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode root, TreeNode subTree) {
        if (root == null && subTree == null) return true;
        if ((root == null && subTree != null) || (root != null && subTree == null) || (root.val != subTree.val)) {
            return false;
        }
        return sameTree(root.left, subTree.left) && sameTree(root.right, subTree.right);
    }

    
}
// Input: root = [3,4,5,1,2], subRoot = [4,1,2]
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