package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Implementation of Circular LinkedList     
 */

public class CircularLinkedList<T> {
    private ListNode<T> tail; // holds tail of the list
    private int length; // by default 0

    /**
     * Add data to the head of the list
     * @param data inserted data
     */
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

    /**
     * Add data to the tail of the list
     * @param data inserted data
     */
    public void addToTail(T data) {
        addToHead(data);
        tail = tail.getNext();
    }

    /**
     * @return data at head of the list
     */
    public T peek() {
        return tail.getNext().getData();
    }

    /**
     * @return data at tail of the list
     */
    public T tailPeek() {
        return tail.getData();
    }

    /**
     * remove head of the list
     * @return removed data
     */
    public T removeFromHead() {
        ListNode<T> temp = tail.getNext(); // head of the list
        if (isEmpty()) // there is no data to removed
            return null;
        if (tail == tail.getNext()) { // list consists of only tail
            tail = null;
        } else { // remove the data after tail
            tail.setNext(temp.getNext());
            temp.setNext(null);
        }
        length--;
        return temp.getData();
    }

    /**
     * remove tail of the list
     * @return removed data
     */
    public T removeFromTail() {
        if (isEmpty()) // there is no data to removed
            return null;

        // removing
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

    /**
     * remove the first data from the list that equals to searched data
     * @param data data
     * @return removed data. Returns the first data which equals to searched data, otherwise -1
     */
    public T remove(T data) {
        if (isEmpty()) // there is no data to removed
            return null;

        // removing
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

    /**
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return tail == null;
    }

    /**
     * @param data searched data
     * @return true if list contains searched data
     */
    public boolean contains(T data) {
        if (tail == null)
            return false;
        ListNode<T> finger = tail;
        while (finger.getNext() != tail && finger.getData() != data) {
            finger = finger.getNext();
        }
        return finger.getData() == data;
    }

    /**
     * @return length of the list
     */
    public int length() {
        return length;
    }

    /**
     * Clear all data from the list
     */
    public void clear() {
        tail = null;
        length = 0;
    }

    /**
     * @return String representation of the list in the form ["str1", "str2", ..., "strn"]
     * But, because of Circular LinkedList, we represent list as [tail, head, secondElement, ..., nthElement]
     */
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
