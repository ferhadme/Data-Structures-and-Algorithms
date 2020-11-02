package com.ferhad.problems;

import com.ferhad.Node;

import java.util.Hashtable;

/**
 * @author Ferhad Mehdizade
 *
 * Find middle of the LinkedList without length
 */
public class MiddleOfLinkedList {

    /**
     * Brute-Force approach
     * @param head head of the LinkedList
     * @return middle of the LinkedList
     * Time complexity - O(n + m) = O(n), where n for finding length, and m for finding middle point
     * Space complexity - O(1)
     */
    public Node middleOfLinkedList(Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }

        if (length % 2 == 0)
            length--;

        for (int i = 0; i < length / 2; i++) {
            head = head.getNext();
        }
        return head;
    }

    /**
     * Finds middle point of the LinkedList efficiently using HashTable(HT indicates HashTable)
     * @param head head of the LinkedList
     * @return middle of the LinkedList
     * Time complexity - O(n) for scanning list
     * Space complexity - O(n) for creating HashTable
     */
    public Node middleOfLinkedListHT(Node head) {
        Hashtable<Integer, Node> nodesIndexes = new Hashtable<>();
        int index = 0;
        while (head != null) {
            nodesIndexes.put(index, head);
            head = head.getNext();
            index++;
        }

        return nodesIndexes.get(index / 2);
    }
    
}
