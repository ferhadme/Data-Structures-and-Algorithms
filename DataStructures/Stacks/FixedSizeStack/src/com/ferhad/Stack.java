package com.ferhad;

import java.util.NoSuchElementException;

/**
 * @author Ferhad Mehdizade
 *
 * Implementation of fixed size Stack Data Structure
 * @param <E> Type of element
 */
public class Stack<E> {
    private static final int CAPACITY = 10; // default capacity
    private final int capacity;
    private final Object[] elements;
    private int top; // index of top element

    /**
     * Constructs elements array with specified capacity, initialize top -1 for empty Stack
     * @param capacity capacity of the Stack
     */
    public Stack(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
        top = -1;
    }

    /**
     * Constructs elements array with default capacity value(10)
     */
    public Stack() {
        this(CAPACITY);
    }

    /**
     * Gets element in the specified index from elements array
     * For casting Objects to specified type
     * @param index index of the element
     * @return element in the specified index
     */
    private E getElement(int index) {
        return (E) elements[index];
    }

    /**
     * Returns size of the elements array
     * @return size
     */
    public int size() {
        return top + 1;
    }

    /**
     * Checks emptiness of Stack
     * @return true if Stack is empty, otherwise false
     */
    public boolean isEmpty() {
        return top < 0;
    }

    /**
     * Checks Stack contains specified element or not
     * @param e searched element
     * @return true if Stack contains specified element, otherwise false
     */
    public boolean contains(E e) {
        for (int i = 0; i < size(); i++) {
            if (e.equals(getElement(i)))
                return true;
        }
        return false;
    }

    /**
     * Pushes new element to the Stack
     * @param e inserted element
     */
    public void push(E e) {
        if (size() == capacity)
            throw new IndexOutOfBoundsException();
        elements[++top] = e;
    }

    /**
     * Removes the top element from the Stack
     * @return removed element
     */
    public E pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        E element = getElement(top);
        elements[top--] = null;
        return element;
    }

    /**
     * Gets the top element of the Stack
     * @return top element
     */
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return getElement(top);
    }

    /**
     * @return string representation of the Stack as [ "bottomElement", ..., "topElement" ]
     */
    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        String stack = "[";
        for (int i = 0; i < top; i++) {
            stack += getElement(i) + ", ";
        }
        stack += getElement(top) + "]";
        return stack;
    }

}