package Leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node4;
        node4.random = node2;
        node5.random = node1;
        CopyListWithRandomPointer c = new CopyListWithRandomPointer();
        Node r = c.copyRandomList(node1);
        while (r != null) {
            System.out.println("node val: " + r.val);
            r = r.next;
        }
    }
    public Node copyRandomList(Node head) {
        Node headPointer1 = head;
        Node copy = new Node(0);
        Node copyPointer1 = copy;
        Map<Node, Node> realToCopy = new HashMap<>();
        while (headPointer1 != null) {
            Node tempNode = new Node(headPointer1.val);
            copyPointer1.next = tempNode;
            copyPointer1 = copyPointer1.next;
            realToCopy.put(headPointer1, copyPointer1);
            headPointer1 = headPointer1.next;
        }

        Node copyPointer2 = copy.next;
        Node headPointer2 = head;
        while (headPointer2 != null) {
            if (headPointer2.random == null) {
                copyPointer2.random = null;
            } else {
                copyPointer2.random = realToCopy.get(headPointer2.random);
            }
            copyPointer2 = copyPointer2.next;
            headPointer2 = headPointer2.next;
        }
        return copy.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}