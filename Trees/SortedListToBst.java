package Leetcode.Trees;

public class SortedListToBst {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(3);
        node1.next = node2;
        // node2.next = node3;

        SortedListToBst s = new SortedListToBst();
        TreeNode t = s.sortedListToBST(node1);
        print(t);

    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        ListNode twoAhead = head;

        while (twoAhead.next != null && twoAhead.next.next != null) {
            prev = curr;
            curr = curr.next;
            twoAhead = twoAhead.next.next;
        }
        TreeNode tn = new TreeNode(curr.val);
        if (prev == null) {
            tn.left = sortedListToBST(null);
        } else {
            prev.next = null;
            tn.left = sortedListToBST(head);
        }
        tn.right = sortedListToBST(curr.next);

        return tn;
        
    }

    static void print(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        print(node.left);
        print(node.right);
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


class ListNode {
    int val;
    ListNode next;
    ListNode random;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}