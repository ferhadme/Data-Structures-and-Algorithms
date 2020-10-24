package com.ferhad;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;

/**
 * @author Ferhad Mehdizade
 */

public class UnrolledLinkedList<E> extends AbstractList<E> implements List<E>, Serializable {
    private int nodeCapacity; // the maximum number of elements that can be stored in a single node
    private int size; // the current size of the list
    private ListNode<E> firstNode; // the first node of the list
    private ListNode<E> lastNode; // the last node of the list

    /**
     * Constructs an empty list with the specified capacity
     * @param nodeCapacity capacity of the node
     * @throws IllegalArgumentException if @param nodeCapacity is less than 8
     */
    public UnrolledLinkedList(int nodeCapacity) {
        if (nodeCapacity < 8)
            throw new IllegalArgumentException("nodeCapacity < 8");
        this.nodeCapacity = nodeCapacity;
        firstNode = new ListNode<>();
        lastNode = firstNode;
    }

    /**
     * Constructor for none-specified nodeCapacity that creates List with 16 nodeCapacity
     */
    public UnrolledLinkedList() {
        this(16);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }


}
