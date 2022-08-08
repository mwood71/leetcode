package Leetcode.LinkedList;

public class HasCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        HasCycle h = new HasCycle();
        boolean r = h.hasCycle(node1);
        System.out.println(r);
    }
    public boolean hasCycle(ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while (pointer1 != null && pointer2 != null) {
            if (pointer2.next == null || pointer2.next.next == null) {
                return false;
            }
            pointer2 = pointer2.next.next;
            pointer1 = pointer1.next;

            if (pointer1 == pointer2) return true;
        }
        return false;
    }
}
// Input: head = [3,2,0,-4], pos = 1
// Output: true
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}