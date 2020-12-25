package com.ferhad;

import java.util.NoSuchElementException;

/**
 * @author Ferhad Mehdizade
 *
 * Implementation of Queue Data Structure using Circular Array
 * @param <E> Type of an element
 */
public class Queue<E> {
    private static final int CAPACITY;
    static {
        CAPACITY = 16; // default size for fixed size Queue
    }
    private final Object[] elements; // elements of Queue
    private int size; // size of Queue
    private int front; // front of Queue
    private int rear; // rear of Queue
    private final int capacity; // optional capacity

    /**
     * Initializes capacity with default capacity(16)
     */
    public Queue() {
        elements = new Object[CAPACITY];
        capacity = CAPACITY;
    }

    /**
     * Initializes capacity with optional capacity
     * @param capacity optional capacity
     */
    public Queue(int capacity) {
        elements = new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * Gets elements by casting Object element to specific type
     * @param index index of an element in actual array
     * @return element with specific type
     */
    private E getElement(int index) {
        return (E) elements[index];
    }

    /**
     * Enqueues new element to the Queue
     * @param elem inserted element
     */
    public void enQueue(E elem) {
        if (size == capacity)
            throw new IllegalStateException("Queue is full");
        elements[rear++] = elem;
        rear %= capacity; // for providing circular array logic
        size++;
    }

    /**
     * Dequeues element from Queue
     * @return removed element from Queue
     */
    public E deQueue() {
        if (size == 0)
            throw new NoSuchElementException("Queue is empty");
        E data = getElement(front % capacity);
        elements[front++] = null;
        front %= capacity;
        size--;
        return data;
    }

    /**
     * Gets front(or first) element of the Queue
     * @return front element
     */
    public E getFront() {
        return getElement(front);
    }

    /**
     * Gets rear(or last) element of the Queue
     * @return rear element
     */
    public E getRear() {
        return getElement(rear - 1);
    }

    /**
     * @return size of the Queue
     */
    public int size() {
        return size;
    }

    /**
     * Defines emptiness of Queue
     * @return true if Queue is empty, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Defines fullness of Queue
     * @return true if Queue is full, otherwise false
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Checks whether Queue contains element or not
     * @param elem element
     * @return true if Queue contains specified element, false otherwise
     */
    public boolean contains(E elem) {
        for (Object element : elements) {
            if (element.equals(elem))
                return true;
        }
        return false;
    }

    /**
     * @return String representation of the Queue in the form [FirstElement, ..., LastElement]
     */
    @Override
    public String toString() {
        String queueRep = "[";
        int i; // needed for the last element
        for (i = 0; i < size - 1; i++) {
            queueRep += elements[(front + i) % capacity] + ", ";
        }
        queueRep += elements[(front + i) % capacity] + "]";
        return queueRep;
    }
}
