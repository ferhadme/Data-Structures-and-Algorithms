package com.ferhad;

/**
 * @author Ferhad Mehdizade
 * Implementation of Singly LinkedList
 */

public class LinkedList<T> {
    private ListNode<T> head; // It holds the head of the list
    private int length; // by default 0

    public T getHead() {
        return head.getData();
    }

    public void insertAtBegin(T data) {
        ListNode<T> node = new ListNode<>(data);
        node.setNext(head);
        head = node;
        length++;
    }

    public void insertAtEnd(T data) {
        ListNode<T> node = new ListNode<>(data);
        if (head == null) {
            head = node;
        } else {
            ListNode<T> p,q;
            for (p = head;(q = p.getNext()) != null; p = q); // finding the last node of the LinkedList (p)
            p.setNext(node);
        }
        length++;
    }

    public ListNode<T> removeAtBegin() {
        ListNode<T> node = head;
        if (node != null) {
            head = node.getNext();
            node.setNext(null);
            length--;
        }
        return node;
    }

    public ListNode<T> removeFromEnd() {
        if (head == null) {
            return null;
        }

        ListNode<T> p = head, q = null, next = head.getNext();
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

    public void removeMatched(ListNode<T> node) {
        if (head == null) {
            return;
        }
        if (node.equals(head)) {
            head = head.getNext();
            length--;
            return;
        }

        ListNode<T> p = head, q = null;
        while ((q = p.getNext()) != null) {
            if (node.equals(q)) {
                p.setNext(q.getNext());
                length--;
                return;
            }
            p = q;
        }
    }

    private ListNode<T> findNode(int position) {
        ListNode<T> temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public void insert(int position, T data) {
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
        ListNode<T> temp = findNode(position);
        ListNode<T> newNode = new ListNode<>(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);

        length++;
    }

    public void remove(int position) {
        if (position < 0 || position >= length) {
            throw new IndexOutOfBoundsException();
        }

        if (position == 0) {
            head = head.getNext();
        } else {
            ListNode<T> temp = findNode(position);
            temp.setNext(temp.getNext().getNext());
        }
        length--;
    }

    public int length() {
        return length;
    }

    public T get(int position) {
        if (position < 0 || position >= length) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> temp = findNode(position).getNext();
        return temp.getData();
    }

    public void set(int position, T data) {
        ListNode<T> temp = findNode(position).getNext();
        temp.setData(data);
    }


    public int getPosition(T data) {
        int position = 0;
        ListNode<T> temp = head;
        while (temp != null) {
            if (data.equals(temp.getData())) {
                return position;
            }
            position++;
            temp = temp.getNext();
        }
        // there is no position with this data, return -1;
        return -1;
    }

    // method for reversing LinkedList
    public void reverse() {
        ListNode<T> currentNode = head;
        ListNode<T> forwardNode = null;
        ListNode<T> previousNode = null;
        // traversing linked list until there is no more element
        while (currentNode.getNext() != null) {
            forwardNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = forwardNode;
        }
        head = currentNode;
        head.setNext(previousNode);
    }

    // String representation of this collection, in the form ["str1", "str2", ...].
    @Override
    public String toString() {
        String result = "[";
        ListNode<T> temp = null;
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
