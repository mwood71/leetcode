package Leetcode.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {
    HashMap<Integer, Node> visited = new HashMap<>();
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node1.val = 4;
        node1.neighbors = Arrays.asList(node2, node3);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        CloneGraph cloneGraph = new CloneGraph();
        Node result = cloneGraph.cloneGraph(node1);
        System.out.println(result.neighbors);
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.get(node.val) != null) return visited.get(node.val);
        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new LinkedList<>();
        visited.put(newNode.val, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
}
