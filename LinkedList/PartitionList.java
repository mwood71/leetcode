package Leetcode.LinkedList;

public class PartitionList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;
        // node5.next = node6;

        PartitionList p = new PartitionList();
        ListNode n = p.partition(node1, 2);

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode();
        ListNode firstPointer = first;

        ListNode second = new ListNode();
        ListNode secondPointer = second;

        ListNode iteratorNode = head;

        while (iteratorNode != null) {
            if (iteratorNode.val >= x) {
                secondPointer.next = new ListNode(iteratorNode.val);
                secondPointer = secondPointer.next;
            } else {
                firstPointer.next = new ListNode(iteratorNode.val);
                firstPointer = firstPointer.next;
            }
            iteratorNode = iteratorNode.next;
        }

        firstPointer.next = second.next;
        return first.next;
    }
}

// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}