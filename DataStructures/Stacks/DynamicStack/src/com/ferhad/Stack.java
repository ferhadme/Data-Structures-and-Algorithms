package com.ferhad;

import java.util.EmptyStackException;

/**
 * @author Ferhad Mehdizade
 *
 * Implementation of Dynamic sized Stack
 * @param <E> Type of an element
 */
public class Stack<E> {
    private static final int CAPACITY = 10;
    private int capacity;
    private int top; // top of the Stack
    Object[] elements;

    /**
     * Constructs Stack by initializing capacity with default value(10)
     */
    public Stack() {
        capacity = CAPACITY;
        elements = new Object[capacity];
        top = -1;
    }

    /**
     * Gets object in the specified index from elements array
     * For casting Objects to specified Type
     * @param index specified index
     * @return element in the index
     */
    private E getElement(int index) {
        return (E) elements[index];
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
     * Gets size of the Stack
     * @return the size
     */
    public int size() {
        return top + 1;
    }

    /**
     * Expands Stack if capacity is full after pushing process
     */
    private void expand() {
        capacity *= 2;
        copy(elements, capacity);
    }

    /**
     * Shrinks Stack to 1/2 size after pop operation if elements are less than capacity / 2
     */
    private void shrink() {
        capacity /= 2;
        copy(elements, capacity);
    }

    /**
     * Changes Stack to new Stack with specified capacity
     * @param src main Stack
     * @param capacity new capacity
     */
    private void copy(Object[] src, int capacity) {
        Object[] dest = new Object[capacity];
        System.arraycopy(src, 0, dest, 0, size());
        elements = dest;
    }

    /**
     * Pushes element to top of the Stack
     * @param e inserted element
     */
    public void push(E e) {
        if (size() == capacity)
            expand();
        elements[++top] = e;
    }

    /**
     * Removes element from top of the Stack
     * @return removed element
     */
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        E removedElem = getElement(top);
        elements[top--] = null;
        if (size() == capacity / 2 && capacity > CAPACITY)
            shrink();
        return removedElem;
    }

    /**
     * Clears Stack
     */
    public void clear() {
        if (!isEmpty()) {
            int size = size();
            for (int i = 0; i < size; i++)
                this.pop();
        }
    }

    /**
     * Gets top element of the Stack
     * @return top element
     */
    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return getElement(top);
    }

    /**
     * @return string representation of the Stack as ["bottomElement", ..., "topElement"]
     */
    @Override
    public String toString() {
        if (isEmpty())
            return "[]";
        StringBuilder stackStr = new StringBuilder("[");
        for (int i = 0; i < top; i++) {
            stackStr.append(getElement(i)).append(", ");
        }
        stackStr.append(getElement(top)).append("]");
        return stackStr.toString();
    }

}
