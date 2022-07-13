package Leetcode.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode result = reverseLinkedList.reverseList(node1);
        
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode nextNode = head;

        while (current != null) {
            nextNode = nextNode.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]