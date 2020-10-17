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

public class CircularLinkedList<T> {
    private ListNode<T> tail;
    private int length; // by default 0

    // Add data to the head of the list
    public void addToHead(T data) {
        ListNode<T> node = new ListNode<T>(data);
        if (tail == null) { //first data is added
            tail = node;
            tail.setNext(tail);
        } else { // data exists in the list
            node.setNext(tail.getNext());
            tail.setNext(node);
        }
        length++;
    }

    // Add data to the tail of the list
    public void addToTail(T data) {
        addToHead(data);
        tail = tail.getNext();
    }

    // Return data at head of the list
    public T peek() {
        return tail.getNext().getData();
    }

    // Return data at tail of the list
    public T tailPeek() {
        return tail.getData();
    }

    // Return and remove head of the list
    public T removeFromHead() {
        ListNode<T> temp = tail.getNext(); // head of the list
        if (isEmpty())
            return null;
        if (tail == tail.getNext()) {
            tail = null;
        } else {
            tail.setNext(temp.getNext());
            temp.setNext(null);
        }
        length--;
        return temp.getData();
    }

    // Return and remove tail of the list
    public T removeFromTail() {
        if (isEmpty())
            return null;
        ListNode<T> temp = tail;
        ListNode<T> finger = tail;
        while (finger.getNext() != tail) {
            finger = finger.getNext();
        }

        if (finger == tail) {
            tail = null;
        } else {
            finger.setNext(tail.getNext());
            tail = finger;
        }
        length--;
        return temp.getData();
    }

    public T remove(T data) {
        if (isEmpty())
            return null;
        ListNode<T> finger = tail.getNext();
        ListNode<T> previous = tail;
        for (int i = 0; i < length && finger.getData() != data; i++) {
            previous = finger;
            finger = finger.getNext();
        }
        if (finger.getData() == data) {
            if (tail == tail.getNext())
                tail = null;
            else {
                if (finger == tail)
                    tail = previous;
                previous.setNext(previous.getNext().getNext());
            }
            finger.setNext(null);
            length--;
            return finger.getData();
        }
        return null;
    }

    // Return true if list is empty
    public boolean isEmpty() {
        return tail == null;
    }

    // Return true if list contains data
    public boolean contains(T data) {
        if (tail == null)
            return false;
        ListNode<T> finger = tail;
        while (finger.getNext() != tail && finger.getData() != data) {
            finger = finger.getNext();
        }
        return finger.getData() == data;
    }

    //

    public int length() {
        return length;
    }

    // Clear all data from the list
    public void clear() {
        tail = null;
        length = 0;
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
        ListNode<T> temp = tail.getNext();

        while (temp != tail) {
            result += ", " + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }
}
