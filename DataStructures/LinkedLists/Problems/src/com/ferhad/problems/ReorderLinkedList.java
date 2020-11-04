package com.ferhad.problems;

import com.ferhad.Node;

/**
 * Methods for Reordering LinkedLists
 * N1 -> N2 -> N3 -> N4 -> N5 -> N6 -> N7 becomes
 * N1 -> N7 -> N2 -> N6 -> N3 -> N5 -> N4
 */
public class ReorderLinkedList {

    /**
     * Reorders LinkedList
     * @param head head of the LinkedList
     */
    public void reorderList(Node head) {
        if (head == null)
            return;
        Node slowPtr = head;
        Node fastPtr = head.getNext();
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }
        Node head2 = slowPtr.getNext();
        slowPtr.setNext(null);
        head2 = reverse(head2);
        // alternate...
    }

    /**
     * Alternates 2 LinkedLists
     * @param head1 head of the first LinkedList
     * @param head2 head of the second LinkedList
     */
    private void alternate(Node head1, Node head2) {
        Node pointer = head1;
        head1 = head1.getNext();
        boolean nextList = false;
        while (head1 != null || head2 != null) {
            if ((head2 != null && !nextList) || head1 == null) {
                pointer.setNext(head2);
                head2 = head2.getNext();
                nextList = true;
            } else {
                pointer.setNext(head1);
                head1 = head1.getNext();
                nextList = false;
            }
            pointer = pointer.getNext();
        }

    }

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
