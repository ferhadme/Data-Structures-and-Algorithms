package com.ferhad;

import java.util.EmptyStackException;

/**
 * @author Ferhad Mehdizade
 *
 * Implementing 2 Stacks at the same time using 1 Array
 * [Stack1 X Stack2]    ==>     X indicates middle of the array
 * @param <T> Type of an element
 */
public class ArrayWithTwoStacks<T> {
    private Object[] elements;
    private int top1; // top of the first Stack
    private int top2; // top of the second Stack
    private int size;

    /**
     * Initializes fields
     * @param size size of the array which holds 2 Stacks. Odd number size is recommended
     */
    public ArrayWithTwoStacks(int size) {
        elements = new Object[size];
        top1 = -1;
        top2 = size;
    }

    /**
     * Casts Object element to specified Generic type
     * @param index index of an element in the array
     * @return generic type of an element
     */
    private T getElement(int index) {
        return (T) elements[index];
    }

    /**
     * Checks specified Stack is empty or not
     * @param stackId Id of the Stack
     * @return true if specified Stack is empty, otherwise false
     */
    public boolean isEmpty(int stackId) {
        if (stackId == 1)
            return top1 == -1;
        if (stackId == 2)
            return top2 == elements.length;
        return true;
    }

    /**
     * @return size of 2 Stacks in array, not array itself
     */
    public int size() {
        return size;
    }

    /**
     * Pushes new element into specified Stack
     * @param stackId Id of the Stack
     * @param data data of inserted element
     */
    public void push(int stackId, T data) {
        if (stackId == 1 && top1 == elements.length / 2 - 1)
            throw new StackOverflowError();
        if (stackId == 2 && top2 == elements.length / 2 + 1)
            throw new StackOverflowError();

        if (stackId == 1) {
            elements[++top1] = data;
        } else if (stackId == 2) {
            elements[--top2] = data;
        } else return;
        size++;
    }

    /**
     * Pops element from specified Stack
     * @param stackId Id of the Stack
     * @return removed element
     */
    public T pop(int stackId) {
        if (isEmpty(stackId))
            throw new EmptyStackException();
        T removedElem = null;
        if (stackId == 1) {
            removedElem = getElement(top1);
            elements[top1--] = null;
        } else if (stackId == 2) {
            removedElem = getElement(top2);
            elements[top2++] = null;
        }
        size--;
        return removedElem;
    }

    /**
     * Returns top element of specified Stack
     * @param stackId Id of the Stack
     * @return top element
     */
    public T peek(int stackId) {
        if (isEmpty(stackId))
            throw new EmptyStackException();
        if (stackId == 1) {
            return getElement(top1);
        } else if (stackId == 2) {
            return getElement(top2);
        }
        return null;
    }

    /**
     * @return String representation of the Stacks in 2 lines in the form of;
     * [bottomElement, ..., topElement]
     * [bottomElement, ..., topElement]
     */
    @Override
    public String toString() {
        String stackStr = "[";
        int counter = 0;

        // first stack
        while (elements[counter] != null) {
            stackStr += elements[counter];
            counter++;
            if (elements[counter] != null)
                stackStr += ", ";
        }
        stackStr += "]\n[";
        counter = elements.length - 1;

        // second stack
        while (elements[counter] != null) {
            stackStr += elements[counter];
            counter--;
            if (elements[counter] != null)
                stackStr += ", ";
        }

        return stackStr + "]";
    }

}
