package Leetcode.LinkedList;

public class RotateList {
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

        RotateList r = new RotateList();
        ListNode n = r.rotateRight(null, 1);
        printList(n);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return new ListNode();
        if (k == 0) return head;
        ListNode headPointer = new ListNode(0);
        ListNode newHead = headPointer;
        ListNode temp = head;
        ListNode nextNode = head;
        ListNode prev = null;
        int count = 0;

        while (temp != null) {
            ListNode n = new ListNode(temp.val);
            headPointer.next = n;
            headPointer = headPointer.next;

            nextNode = nextNode.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
            count++;
        }

        k = k % count;
        newHead = newHead.next;

        while (k > 0) {
            ListNode n = new ListNode(prev.val);
            n.next = newHead;
            newHead = n;
            prev = prev.next;
            k--;
        }
        head = newHead;

        while (count - 1 > 0) {
            newHead = newHead.next;
            count--;
        }

        newHead.next = null;
        return head;   
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}