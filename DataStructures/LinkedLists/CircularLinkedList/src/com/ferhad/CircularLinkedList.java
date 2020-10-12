package com.ferhad;

/**
 * @author Ferhad Mehdizade
 * Implementation of Circular LinkedList
 * Insert O(n) (in case of inserting to beginning time complexity is O(1))
 * Delete O(n) (in case of deleting from beginning time complexity is O(1))
 * Access O(n)
 * Search O(n)
 * Good for insertion, deletion process and this is very useful in the implementation of the queue data structure.
 *      A circular linked list is a variation of a linked list in which the last node points to the first node, completing
 *      a full circle of nodes. In other words, this variation of the linked list doesn't have a null element at the end.
 */

public class CircularLinkedList {
    private ListNode tail;
    private int length; // by default 0

    // Add data to the head of the list
    public void addToHead(int data) {
        ListNode node = new ListNode(data);
        if (tail == null) { //first data is added
            tail = node;
            tail.setNext(tail);
        } else { // data exists in the list
            node.setNext(tail.getNext());
            tail.setNext(node);
        }
        length++;
    }

    public void addToTail(int data) {
        addToHead(data);
        tail = tail.getNext();
    }

    public int length() {
        return length;
    }

    /* String representation of the list in the form ["str1", "str2", ..., "strn"]. But, because of Circular LinkedList,
        we represent list as [tail, head, secondElement, ..., nthElement] */
    @Override
    public String toString() {
        String result = "[";
        if (tail == null) {
            return result + "]";
        }
        result += tail.getData();
        ListNode temp = tail.getNext();

        while (temp != tail) {
            result += ", " + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }
}
