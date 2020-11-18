package com.ferhad;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Ferhad Mehdizade
 *
 * Designing a stack such that getMinimum( ) should be O(1)
 */
public class SpecificStack {
    private Stack<Integer> s = new Stack<>(); // main stack to store minimum element
    private int min; // minimum element of the Stack

    /**
     * Pushes data to the Stack
     * @param data inserted data
     */
    public void push(int data) {
        if (s.isEmpty()) {
            s.push(data);
            min = data;
        } else if (data > min) {
            s.push(data);
        } else {
            s.push(data * 2 - min);
            min = data;
        }
    }

    /**
     * Removes top element from the Stack
     * @param data top data
     */
    public void pop(int data) {
        if (s.isEmpty()) {
            throw new EmptyStackException();
        }
        int top = s.peek();
        if (top < min) {
            min = 2 * min - top;
        }
        s.pop();
    }

    /**
     * @return minimum element of the Stack
     */
    public int getMinimum() {
        return min;
    }

    /**
     * @return String representation of the Main Stack
     */
    @Override
    public String toString() {
        return s.toString();
    }
}
