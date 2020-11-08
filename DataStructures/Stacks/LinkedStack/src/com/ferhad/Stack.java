package com.ferhad;

import java.util.EmptyStackException;

/**
 * @author Ferhad Mehdizade
 *
 * LinkedList Implementation of Stack Data Structure
 * @param <E> Type of element
 */
public class Stack<E> {
    private Element top; // top of the Stack
    private int size;

    /**
     * Initializes size with 0
     */
    public Stack() {
        size = 0;
    }

    /**
     * Checks emptiness of the Stack
     * @return true if Stack is empty, otherwise false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if Stack contains specified element or not
     * @param e specified element
     * @return true if Stack contains the element, otherwise false
     */
    public boolean contains(E e) {
        for (Element temp = top; temp != null; temp = temp.next) {
            if (temp.data.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return size of the Stack
     */
    public int size() {
        return size;
    }

    /**
     * Pushes new element to top of the Stack
     * @param e inserted element
     */
    public void push(E e) {
        if (top == null) {
            top = new Element(e);
        } else {
            Element element = new Element(e);
            Element temp = top;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = element;
        }
        size++;
    }

    /**
     * Removes element from top of the Stack
     * @return popped element
     */
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        Element poppedElement = top;
        Element newTop = top.next;
        top.next = null;
        top = newTop;
        size--;
        return poppedElement.data;
    }

    /**
     * Clears Stack
     * Stack can be cleared by removing reference of the top element too. Java GC will remove elements
     * after dereference process.
     * But this approach is better although time complexity is O(n), where n is the number of elements
     *
     */
    public void clear() {
        if (!isEmpty()) {
            int size = size();
            for (int i = 0; i < size; i++)
                this.pop();
        }

        // -----Another approach-------
        // top = null;
        // size = 0;
    }

    /**
     * Gets top element of the Stack
     * @return top
     */
    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return top.data;
    }

    /**
     * Private class of Stack for linking elements of Stack each other
     */
    private class Element {
        E data;
        Element next;
        Element(E data) {
            this.data = data;
        }
    }

    /**
     * @return string representation of Stack as ["topElement", ..., "bottomElement"]
     */
    @Override
    public String toString() {
        String stackStr = "[";
        Element temp = top;
        while (temp != null) {
            if (temp.next == null) {
                stackStr += temp.data;
            } else {
                stackStr += temp.data + ", ";
            }
            temp = temp.next;
        }
        return stackStr + "]";
    }

}
