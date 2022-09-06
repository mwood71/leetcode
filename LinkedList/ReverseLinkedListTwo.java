package Leetcode.LinkedList;

public class ReverseLinkedListTwo {
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

        ReverseLinkedListTwo r = new ReverseLinkedListTwo();
        ListNode l = r.reverseBetween(node1, 1, 1);

        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        boolean firstNode = false;
        if (left == 1) firstNode = true;
        // get the start
        ListNode start = null;
        if (!firstNode) {
            start = head;
            int counter = 1;

            while (counter < left-1) {
                start = start.next;
                counter++;
            }
        }
        
        // get the end
        int difference = right-left+2;
        ListNode end = null;
        if (firstNode) {
            difference--;
            end = head;
        } else {
            end = start;
        }
        while (difference > 0) {
            end = end.next;
            difference--;
        }

        // get the nodes to reverse
        int reverseCount = right-left+1;
        ListNode reverseNodes = new ListNode();
        ListNode pointer = reverseNodes;
        ListNode startPointer = null;
        if (firstNode) {
            startPointer = head;
        } else {
            startPointer = start.next;
        }
       
        while (reverseCount > 0) {
            pointer.next = startPointer;
            startPointer = startPointer.next;
            pointer = pointer.next;
            reverseCount--;
        }
        pointer.next = null;

        // add reversed nodes to the start
        if (firstNode) {
            start = reverse(reverseNodes.next);
        } else {
            start.next = reverse(reverseNodes.next);
        }

        // add end nodes to the end of the reversed and start
        ListNode result = null;
        if (firstNode) {
            result = start;
        } else {
            result = head;
        }
        ListNode l = result;
        while (result.next != null) {
            result = result.next;
        }
        result.next = end;

        return l;


    }

    ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode next = head;
        ListNode prev = null;
        while (curr != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}