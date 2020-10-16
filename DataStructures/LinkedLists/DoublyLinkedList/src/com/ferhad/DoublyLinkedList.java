package com.ferhad;

import java.util.ArrayList;

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
 * Insertion or deletion of a node takes a bit longer for setting pointers, but finding spesific nodes is fast, because
 *      we can search node in both directions(which is fast).
 */

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

    public void insertAtEnd(int data) {
        if (tail == null) {
            tail = new ListNode(data);
            head = tail;
        } else {
            ListNode node = new ListNode(data);
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        length++;
    }

    public void removeAtBegin() {
        if (head == null)
            return;
        head.getNext().setPrev(null);
        head = head.getNext();
        length--;
    }

    public void removeFromEnd() {
        if (tail == null)
            return;
        tail.getPrev().setNext(null);
        tail = tail.getPrev();
        length--;
    }

    // the most efficient way for searching specific node
    private ListNode findNode(int position) {
        int border = length / 2;
        ListNode temp = null;
        if (position < border) {
            // scan through beginning to position
            temp = head;
            for (int i = 0; i < position; i++)
                temp = temp.getNext();
        } else {
            // scan through end to position
            temp = tail;
            for (int i = length - 1; i > position; i--)
                temp = temp.getPrev();
        }
        return temp;
    }

    public void insert(int position, int data) {
        if (position < 0 || position > length)
            throw new IndexOutOfBoundsException();

        if (position == 0) {
            insertAtBegin(data);
            return;
        } else if (position == length) {
            insertAtEnd(data);
            return;
        }

        ListNode node = new ListNode(data);
        ListNode temp = findNode(position);
        // *<->node <-> temp --*
        temp.getPrev().setNext(node);
        node.setPrev(temp.getPrev());
        node.setNext(temp);
        temp.setPrev(node);
        length++;
    }

    public void remove(int position) {
        if (position < 0 || position >= length)
            throw new IndexOutOfBoundsException();

        if (position == 0) {
            removeAtBegin();
            return;
        } else if (position == length - 1) {
            removeFromEnd();
            return;
        }
        ListNode removedNode = findNode(position);
        removedNode.getPrev().setNext(removedNode.getNext());
        removedNode.getNext().setPrev(removedNode.getPrev());
        removedNode.setPrev(null);
        removedNode.setNext(null);
        length--;
    }

    public int getPosition(int data) {
        ListNode temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.getData() == data)
                return position;
            temp = temp.getNext();
            position++;
        }
        return -1;
    }

    public int get(int position) {
        ArrayList<Integer> list = new ArrayList<>();
        if (position < 0 || position >= length)
            throw new IndexOutOfBoundsException();

        ListNode temp = findNode(position);
        return temp.getData();
    }

    public void set(int position, int data) {
        if (position < 0 || position >= length) {
            throw new IndexOutOfBoundsException();
        }

        ListNode temp = findNode(position);
        temp.setData(data);
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
