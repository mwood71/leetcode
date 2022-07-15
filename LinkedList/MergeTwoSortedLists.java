package Leetcode.LinkedList;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode list1Node3 = new ListNode(4);
        ListNode list1Node2 = new ListNode(2, list1Node3);
        ListNode list1Node1 = new ListNode(1, list1Node2);


        ListNode list2Node3 = new ListNode(4);
        ListNode list2Node2 = new ListNode(3, list2Node3);
        ListNode list2Node1 = new ListNode(1, list2Node2);
        ListNode result = mergeTwoSortedLists.mergeTwoLists(list1Node1, list2Node1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
