package Leetcode.LinkedList;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode result = removeNthFromEnd.removeNthFromEnd(node1, 1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        if (fast == null) {
            head = head.next;
            return head;
        }


        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow != null && slow.next != null && slow.next.next != null) {
            ListNode next = slow.next.next;
            slow.next = next;
        } else {
            slow.next = null;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}