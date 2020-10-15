package com.ferhad;

/**
 * @author Ferhad Mehdizade
 * Implementation of Doubly LinkedList
 * Insert O(n) (in case of inserting to beginning and end time complexity is O(1))
 * Delete O(n) (in case of deleting from beginning and end time complexity is O(1))
 * Access O(n)
 * Search O(n)
 * Good for insertion and deletion process as the Singly LinkedList. But the advantage of a doubly linked list (also
        called two – way linked list) is that given a node in the list, we can navigate in both directions.
 * But each node requires an extra pointer, requiring more space
 * Insertion or deletion of a node takes a bit longer
 */
// getHead(), getTail(), insertAtBegin(), insertAtEnd(), insert(int data, int position), removeAtBegin(),
    // removeFromEnd(), remove(int data, int position), getPosition(int data), get(int data), length(), toString(), clearList()
public class DoublyLinkedList {
    private ListNode head; // holds the head of the list
    private ListNode tail; // holds the tail of the list
    private int length; // by default 0

    public int getHead() {
        return head.getData();
    }

    public int getTail() {
        return tail.getData();
    }

    public void insertAtBegin(int data) {
        if (head == null) {
            head = new ListNode(data);
            tail = head;
        } else {
            ListNode node = new ListNode(data);
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        length++;
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
        tail = null;
        length = 0;
    }
}
