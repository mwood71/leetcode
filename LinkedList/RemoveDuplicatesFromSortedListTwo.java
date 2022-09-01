package Leetcode.LinkedList;

public class RemoveDuplicatesFromSortedListTwo {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RemoveDuplicatesFromSortedListTwo r = new RemoveDuplicatesFromSortedListTwo();
        ListNode result = r.deleteDuplicates(node1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode curr = head;
        ListNode prev = new ListNode(0);
        ListNode result = prev;
        int currValue = head.val;
        int count = 1;

        curr = curr.next;

        while (curr != null) {
            if (curr.val != currValue) {
                if (count < 2) {
                    prev.next = new ListNode(currValue);
                    prev = prev.next;
                    currValue = prev.val;
                }
                currValue = curr.val;
                count = 0;
            }
            curr = curr.next;
            count++;
        }
        if (count < 2) {
            prev.next = new ListNode(currValue);
        }
        return result.next;
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]