package com.ferhad;

import java.util.Hashtable;

/**
 * Check whether the given LinkedList is either NULL-terminated or ends in a cycle(cyclic)
 * Consider the following LinkedList which has a loop in it
 *
 *      [] -> [] -> [] -> [] -> [] -> []
 *                        |           |
 *                       [] <- [] <- []
 *
 * [] represents Node, (->, <-, |) represent pointers.
 */
public class FloydCycleAlgorithm {

    /**
     * Checking LinkedList is Cyclic(has a loop) or not using HashTable approach
     * If Node is next node of more than 1 other Node, then it is Cyclic
     * Iterate over the LinkedList, check each node if it is in HashTable or not
     * If it is, return true, otherwise repeat process
     * @param head head of the LinkedList
     * @return true if LinkedList is Cyclic, otherwise false
     * Time complexity - O(n) for scanning LinkedList
     * Space complexity - O(n) for HashTable with n size
     */
    public boolean isCyclicLinkedList(Node head) {
        if (head != null) {
            Hashtable<Node, Node> recordForPointers = new Hashtable<>();
            Node temp = head;
            while (temp != null) {
                if (recordForPointers.containsKey(temp))
                    return true;
                recordForPointers.put(temp, temp);
                temp = temp.getNext();
            }
        }
        return false;
    }

    /**
     * This approach uses two pointers moving at different speeds to walk the linked list. Once they enter the loop
     * they are expected to meet, which denotes that there is a loop.
     * @param head head of the LinkedList
     * @return true if LinkedList is Cyclic, otherwise false
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public boolean isFloydCyclicLinkedList(Node head) {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && slowPtr != null) {
            // fastPtr moves 2 pointers at a time
            // slowPtr moves 1 pointer at a time
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (fastPtr.equals(slowPtr))
                return true;
        }
        return false;
    }

}
