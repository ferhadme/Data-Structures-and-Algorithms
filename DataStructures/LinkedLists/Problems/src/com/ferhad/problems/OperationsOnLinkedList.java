package com.ferhad.problems;

import com.ferhad.Node;

/**
 * @author Ferhad Mehdizade
 *
 * Operations on the LinkedList such as inserting, reversing
 */
public class OperationsOnLinkedList {

    /**
     * Inserts new Node into Sorted LinkedList by keeping order
     * @param head head of the LinkedList
     * @param newNode inserted node
     * @return true if insertion is successful, otherwise false
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public boolean insertInSortedList(Node head, Node newNode) {
        if (head == null)
            return false;
        Node current = head;
        Node temp = head;
        while (current != null && current.getData() < newNode.getData()) {
            temp = current;
            current = current.getNext();
        }

        newNode.setNext(current);
        temp.setNext(newNode);
        return true;
    }

    /**
     * Reverses Singly LinkedList iteratively
     * @param head head of the LinkedList
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public void reverseLinkedListIterative(Node head) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
    }

    /**
     * Reverses Singly LinkedList recursively
     * @param head head of the LinkedList
     * Time complexity - O(n)
     * Space complexity - O(n) for recursive stack
     */
    public void reverseLinkedListRecursively(Node head) {
        if (head == null || head.getNext() == null)
            return;

        reverseLinkedListRecursively(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);
    }

    /**
     * Displays LinkedList from end to the beginning
     * @param head head of the LinkedList
     * Time complexity - O(n)
     * Space complexity - O(n) for recursive stack
     */
    public void printLinkedListFromEnd(Node head) {
        if (head == null)
            return;
        printLinkedListFromEnd(head.getNext());
        System.out.println(head.getData() + ", ");
    }

}
