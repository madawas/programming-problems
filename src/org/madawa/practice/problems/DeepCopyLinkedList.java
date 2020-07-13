package org.madawa.practice.problems;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 */
public class DeepCopyLinkedList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();

        Node current = head;
        Node result = new Node(head.val);
        Node newHead = result;
        visited.put(current, result);

        while (current != null) {
            if (current.next == null) {
                result.next = null;
            } else if (visited.containsKey(current.next)) {
                result.next = visited.get(current.next);
            } else {
                result.next = new Node(current.next.val);
                visited.put(current.next, result.next);
            }

            if (current.random == null) {
                result.random = null;
            } else if (visited.containsKey(current.random)) {
                result.random = visited.get(current.random);
            } else {
                result.random = new Node(current.random.val);
                visited.put(current.random, result.random);
            }
            current = current.next;
            result = result.next;
        }
        return newHead;
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
