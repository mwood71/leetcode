package Leetcode.LinkedList;

public class ReorderList {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(node1);
    }
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode result = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;

        ListNode reversedList = reverseList(slow);

        while (reversedList != null) {
            ListNode temp = head.next;
            ListNode reversedListNext = reversedList.next; 

            head.next = reversedList;
            reversedList.next = temp;

            head = temp;
            reversedList = reversedListNext;
        }

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    } 
    
    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode next = head;
        ListNode prev = null;
        while (current != null) {
            next = next.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}