package com.ferhad.problems;

import com.ferhad.Node;

/**
 * Methods for Reordering LinkedLists
 * N1 -> N2 -> N3 -> N4 -> N5 -> N6 -> N7 becomes
 * N1 -> N7 -> N2 -> N6 -> N3 -> N5 -> N4
 */
public class ReorderLinkedList {
    
    /**
     * Reverses LinkedList
     * @param head head of the LinkedList
     * @return tail of the LinkedList as head in the reversed form
     */
    private Node reverse(Node head) {
        if (head == null)
            return null;
        Node reversedList = head;
        Node pointer = head.getNext();
        reversedList.setNext(null);
        while (pointer != null) {
            Node temp = pointer;
            pointer = pointer.getNext();
            temp.setNext(reversedList);
            reversedList = temp;
        }
        return reversedList;
    }
}
