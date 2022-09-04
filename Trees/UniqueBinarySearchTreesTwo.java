package Leetcode.Trees;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesTwo {
    public static void main(String[] args) {
        UniqueBinarySearchTreesTwo u = new UniqueBinarySearchTreesTwo();
        List<TreeNode> r = u.generateTrees(3);
        for (TreeNode tn : r) {
            System.out.println(tn.val);
        }
    }
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    List<TreeNode> dfs(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> rightTree = dfs(i+1, end);
            List<TreeNode> leftTree = dfs(start, i-1);

            for (TreeNode rt : rightTree) {
                for (TreeNode lt : leftTree) {
                    TreeNode tn = new TreeNode(i);
                    tn.left = lt;
                    tn.right = rt;
                    list.add(tn);
                }
            }
        }
        return list;
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



// 1 2 3
// 1
