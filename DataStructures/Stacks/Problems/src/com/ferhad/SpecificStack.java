package com.ferhad;

import java.util.Stack;

/**
 * @author Ferhad Mehdizade
 *
 * Designing a stack such that getMinimum( ) and getMaximum( ) should be O(1)
 * @param <E> Type of an element
 */
public class SpecificStack<E extends Comparable<E>> extends Stack<E> {
    private E min;
    private E max;

    @Override
    public E push(E item) {
        if (isEmpty()) {
            min = item;
            max = item;
        } else if (item.compareTo(max) >= 0)
            max = item;
        else if (item.compareTo(min) <= 0)
            min = item;
        return super.push(item);
    }

    public E getMinimum() {
        return min;
    }

    public E getMaximum() {
        return max;
    }

}
