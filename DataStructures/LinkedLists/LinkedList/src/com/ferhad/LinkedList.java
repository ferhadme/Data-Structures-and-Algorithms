package com.ferhad;

/**
 * @author Ferhad Mehdizade
 * Implementation of Singly LinkedList
 * Insert O(n) (in case of inserting to beginning time complexity is O(1))
 * Delete O(n) (in case of deleting from beginning time complexity is O(1))
 * Access O(n)
 * Search O(n)
 * Good for insertion and deletion process.
 */

public class LinkedList {
    private ListNode head; // It holds the head of the list
    private int length; // by default 0

    public int getHead() {
        return head.getData();
    }

    public void insertAtBegin(int data) {
        ListNode node = new ListNode(data);
        node.setNext(head);
        head = node;
        length++;
    }

    public void insertAtEnd(int data) {
        ListNode node = new ListNode(data);
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
        if (position < 0 || position > length) {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            insertAtBegin(data);
            return;
        } else if (position == length) {
            insertAtEnd(data);
            return;
        }
        ListNode temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.getNext();
        }
        ListNode newNode = new ListNode(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);

        length++;
    }

    public ListNode removeAtBegin() {
        ListNode node = head;
        if (node != null) {
            head = node.getNext();
            node.setNext(null);
            length--;
        }
        return node;
    }

    public ListNode removeFromEnd() {
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

    public void remove(int position) {
        if (position < 0 || position >= length) {
            throw new IndexOutOfBoundsException();
        }

        if (head == null) {
            return;
        } else if (position == 0) {
            head = head.getNext();
        } else {
            ListNode temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        length--;
    }

    public int length() {
        return length;
    }

    public int get(int position) {
        if (position < 0 || position >= length) {
            return Integer.MIN_VALUE;
        }
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
            if (data == temp.getData()) {
                return position;
            }
            position++;
            temp = temp.getNext();
        }

        // there is no position with this data, return -1;
        return -1;
    }

    // String representation of this collection, in the form ["str1", "str2", ...].
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

    // Remove all data from LinkedList
    public void clearList() {
        head = null;
        length = 0;
    }

}
