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

    /**
     * Finds length of the LinkedList is even or odd
     * @param head head of the LinkedList
     * @return true if length is even, otherwise false
     * Time complexity - O(n/2) = O(n), where n is the length
     * Space complexity - O(1)
     */
    public boolean isLinkedListEven(Node head) {
        while (head != null && head.getNext() != null) {
            head = head.getNext().getNext();
        }
        return head == null;
    }

    /**
     * Merging 2 LinkedLists into third LinkedList in sorted order recursively
     * @param head1 head of the first LinkedList
     * @param head2 head of the second LinkedList
     * @return head of the Merged LinkedList
     * Time complexity - O(n + m)
     * Space complexity - O(n + m) for recursive stack,
     * where n and m are sizes respectively
     */
    public Node merge2ListsR(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node head = new Node();
        if (head1.getData() >= head2.getData()) {
            head = head2;
            head.setNext(merge2ListsR(head2.getNext(), head1));
        } else {
            head = head1;
            head.setNext(merge2ListsR(head1.getNext(), head2));
        }
        return head;
    }

    /**
     * Merging 2 LinkedLists into third LinkedList in sorted order iteratively
     * @param head1 head of the first LinkedList
     * @param head2 head of the second LinkedList
     * @return head of the Merged LinkedList
     * Time complexity - O(n + m), where n and m are sizes respectively
     * Space complexity - O(1)
     */
    public Node merge2ListsI(Node head1, Node head2) {
        Node head = new Node();
        Node current = head;
        while (head1 != null && head2 != null) {
            if (head1.getData() >= head2.getData()) {
                current.setNext(head2);
                head2 = head2.getNext();
            } else {
                current.setNext(head1);
                head1 = head1.getNext();
            }
            current = current.getNext();
        }
        return head;
    }

}
