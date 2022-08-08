package Leetcode.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1n1 = new ListNode(9);
        ListNode l1n2 = new ListNode(9, l1n1);
        ListNode l1n3 = new ListNode(9, l1n2);
        ListNode l1n4 = new ListNode(9, l1n3);
        ListNode l1n5 = new ListNode(9, l1n4);
        ListNode l1n6 = new ListNode(9, l1n5);
        ListNode l1n7 = new ListNode(9, l1n6);

        ListNode l2n1 = new ListNode(9);
        ListNode l2n2 = new ListNode(9, l2n1);
        ListNode l2n3 = new ListNode(9, l2n2);
        ListNode l2n4 = new ListNode(9, l2n3);

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode r = a.addTwoNumbers(l1n7, l2n4);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        int remainder = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + remainder;
            if (sum >= 10) {
                remainder = 1;
                sum = sum % 10;
            } else {
                remainder = 0;
            }
            ListNode n = new ListNode(sum);
            pointer.next = n;
            pointer = pointer.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + remainder;
            if (sum >= 10) {
                remainder = 1;
                sum = sum % 10;
            } else {
                remainder = 0;
            }
            ListNode n = new ListNode(sum);
            pointer.next = n;
            pointer = pointer.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + remainder;
            if (sum >= 10) {
                remainder = 1;
                sum = sum % 10;
            } else {
                remainder = 0;
            }
            ListNode n = new ListNode(sum);
            pointer.next = n;
            pointer = pointer.next;

            l2 = l2.next;
        }

        if (remainder != 0) {
            ListNode n = new ListNode(remainder);
            pointer.next = n;
        }

        return result.next;
    }
}
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}