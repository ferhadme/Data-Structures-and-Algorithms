package com.ferhad;

/**
 * @author Ferhad Mehdizade
 * Implementation of LinkedList
 */

public class LinkedList {
    private ListNode head; // It holds the head of the list
    private int length;

    public LinkedList() {
        this.length = 0;
    }

    public synchronized ListNode getHead() {
        return head;
    }

    public synchronized void insertAtBegin(ListNode node) {
        node.setNext(head);
        head = node;
        length++;
    }

    public synchronized void insertAtEnd(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode p,q;
            for (p = head;(q = p.getNext()) != null; p = q); // finding the last node of the LinkedList (p)
            p.setNext(node);
        }
        length++;
    }

    public void insert(int data, int position) {
        if (position < 0) {
            position = 0;
        } else if (position > length) {
            position = length;
        }

        if (head == null) {
            head = new ListNode(data);
        } else if (position == 0) {
            ListNode temp = new ListNode(data);
            temp.setNext(head);
            head = temp;
        } else {
            ListNode temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.getNext();
            }
            ListNode newNode = new ListNode(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }

        length++;
    }

    public synchronized ListNode removeAtBegin() {
        ListNode node = head;
        if (node != null) {
            head = node.getNext();
            node.setNext(null);
            length--;
        }
        return node;
    }

    public synchronized ListNode removeFromEnd() {
        if (head == null) {
            return null;
        }

        ListNode p = head, q = null, next = head.getNext();
        if (next == null) {
            head = null;
            length--;
            return p;
        }

        while ((next = p.getNext()) != null) {
            q = p;
            p = next;
        }
        assert q != null;
        q.setNext(null);
        length--;

        return p;
    }

    public synchronized void removeMatched(ListNode node) {
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

    public void remove(int position) {
        if (position < 0) {
            position = 0;
        } else if (position >= length) {
            position = length - 1;
        }

        if (head == null) {
            return;
        } else if (position == 0) {
            head = head.getNext();
        } else {
            ListNode temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        length--;
    }
}
