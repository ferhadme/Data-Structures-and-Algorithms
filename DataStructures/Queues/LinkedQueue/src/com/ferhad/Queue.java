package com.ferhad;

import java.util.NoSuchElementException;

/**
 * @author Ferhad Mehdizade
 *
 * Implementation of Queue Data Structure with LinkedList
 * @param <E> type of an element
 */
public class Queue<E> {
    private Node front;
    private Node rear;
    private int size;

    /**
     * Holds Nodes of Queue
     */
    private class Node {
        Node next;
        E data;

        Node(E data) {
            this.data = data;
        }
    }

    /**
     * Inserts new element into rear of the Queue
     * @param element new element
     */
    public void enQueue(E element) {
        if (rear == null) {
            front = new Node(element);
            rear = front;
        } else {
            Node node = new Node(element);
            rear.next = node;
            rear = node;
        }
        size++;
    }

    /**
     * Removes element from front of the Queue
     * @return
     */
    public E deQueue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        E data = front.data;
        front = front.next;
        size--;
        return data;
    }

    /**
     * Gets front of the Queue
     * @return front element
     */
    public E front() {
        return front.data;
    }

    /**
     * Gets rear of the Queue
     * @return rear element
     */
    public E rear() {
        return rear.data;
    }

    /**
     * Gets size of the Queue
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether Queue is empty or not
     * @return true if Queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether Queue contains specified element or not
     * @param element searched element
     * @return true if Queue contains specified element, false otherwise
     */
    public boolean contains(E element) {
        Node temp = front;
        while (temp != null) {
            if (temp.data.equals(element))
                return true;
            temp = temp.next;
        }
        return false;
    }

    /**
     * String representation of the Queue in the form of [Front, ..., Rear]
     * @return string representation of the Queue
     */
    @Override
    public String toString() {
        if (front == null)
            return "[]";
        String queueRep = "[";
        Node temp = front;
        for (int i = 0; i < size - 1; i++) {
            queueRep += temp.data + ", ";
            temp = temp.next;
        }
        queueRep += temp.data + "]";
        return queueRep;
    }

}
