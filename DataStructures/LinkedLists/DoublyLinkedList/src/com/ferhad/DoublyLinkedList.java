package com.ferhad;

/**
 * @author Ferhad Mehdizade
 * Implementation of Doubly LinkedList
 * Insert O(n) (in case of inserting to beginning time complexity is O(1))
 * Delete O(n) (in case of deleting from beginning time complexity is O(1))
 * Access O(n)
 * Search O(n)
 * Good for insertion and deletion process as the Singly LinkedList. But the advantage of a doubly linked list (also
        called two – way linked list) is that given a node in the list, we can navigate in both directions.
 * But each node requires an extra pointer, requiring more space
 * Insertion or deletion of a node takes a bit longer
 */

public class DoublyLinkedList {
    private ListNode head; // holds the head of the list
    private int length; // by default 0

    public ListNode getHead() {
        return head;
    }

    public void insertAtBegin(int data) {
        if (head == null) { // list is empty, create new head
            head = new ListNode(data);
        } else {
            ListNode node = new ListNode(data);
            // linking head and the next of the head to each other
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        length++;
    }

    public void insertAtEnd(int data) {
        if (head == null) { // list is empty, create new head
            insertAtBegin(data);
            return;
        }
        ListNode node = new ListNode(data);
        // finding tail of the list
        ListNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        // linking tail and the previous of the tail to each other
        temp.setNext(node);
        node.setPrev(temp);
        length++;
    }

    public void insert(int data, int position) {
        // checking position
        if (position <= 0 || head == null) {
            insertAtBegin(data);
            return;
        } else if (position >= length) {
            insertAtEnd(data);
            return;
        }

        ListNode node = new ListNode(data);
        ListNode temp = head;
        // finding the node in the position and inserting
        for (int i = 0; i < position - 1; i++) {
            temp = temp.getNext();
        }
        node.setNext(temp.getNext());
        node.setPrev(temp);
        // checking nullability of the next of the node
        if (node.getNext() != null) {
            node.getNext().setPrev(node);
        }
        temp.setNext(node);
        length++;
    }

    public void removeAtBegin() {
        if (head != null) {
            head = head.getNext();
            length--;
        }
    }

    public void removeFromEnd() {
        if (head != null) {
            ListNode temp = head;
            // finding the node
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            // if temp equals to the head, then the list consists of only head
            if (temp.equals(head)) {
                removeAtBegin();
            } else { // remove links of temp to previous and next node
                temp.getPrev().setNext(null);
                temp.setPrev(null);
                length--;
            }
        }
    }

    public void remove(int position) {
        // checking positions
        if (position <= 0 || head == null) {
            removeAtBegin();
            return;
        } else if (position >= length - 1) {
            removeFromEnd();
            return;
        }
        ListNode temp = head;
        // finding the node in the position and removing
        for (int i = 0; i <= position - 1; i++) {
            temp = temp.getNext();
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        temp.setPrev(null);
        temp.setNext(null);
        length--;
    }

    // remove specific ListNode
    public void removeMatched(ListNode node) {
        if (head == null) {
            return;
        }
        if (node.equals(head)) {
            head = head.getNext();
            length--;
            return;
        }

        ListNode p = head, q = null;
        while ((q = p.getNext()) != null) {
            if (node.equals(q)) {
                p.setNext(q.getNext());
                length--;
                return;
            }
            p = q;
        }
    }

    public int get(int position) {
        // return something like Integer.MIN_VALUE for wrong position
        if (position < 0 || position >= length) {
            return Integer.MIN_VALUE;
        }
        // find the node in the position and return data of this node
        ListNode temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public int getPosition(int data) {
        int position = 0;
        ListNode temp = head;
        while (temp != null) {
            if (temp.getData() == data) {
                return position;
            }
            position++;
            temp = temp.getNext();
        }
        return -1;
    }

    public int length() {
        return length;
    }

    // Representation of list in the form ["str1", "str2", "str3", .., "strn"]
    @Override
    public String toString() {
        String result = "[";
        ListNode temp = null;
        if (head != null) {
            result += head.getData();
            temp = head.getNext();
        }
        while (temp != null) {
            result += ", " + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    // clear all nodes of the list
    public void clearList() {
        head = null;
        length = 0;
    }
}
