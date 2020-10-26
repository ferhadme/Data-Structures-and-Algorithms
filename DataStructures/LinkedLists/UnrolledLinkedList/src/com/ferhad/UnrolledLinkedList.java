package com.ferhad;

import java.io.Serializable;
import java.util.*;

/*
           ***Representation of the Unrolled LinkedList***

      FIRST BLOCK             SECOND BLOCK            THIRD BLOCK
      ListNode-1              ListNode-2              ListNode-3
    |-- -- -- -- |          |-- -- -- -- |          |-- -- -- -- |
     [p1 p2 p3 p4]           [p1 p2 p3 p4]           [p1 p2 p3 p4]
    |            |          |            |          |            |
    |            |  ----->  |            |  ----->  |            |
    |            |          |            |          |            |
    |-- -- -- -- |          |-- -- -- -- |          |-- -- -- -- |

    p1, p2, p3, p4 are indexes of an array.
    Each block represents particular Node of the LinkedList
 */


/**
 * @author Ferhad Mehdizade
 * Implementation of Unrolled LinkedList
 * @param <E> the type of elements in this list
 */

public class UnrolledLinkedList<E> extends AbstractList<E> implements List<E>, Serializable {
    private final int nodeCapacity; // the maximum number of elements that can be stored in a single node
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
     * Constructor for none-specified nodeCapacity that creates List with 16 nodeCapacity by default
     */
    public UnrolledLinkedList() {
        this(16);
    }

    /**
     * @return size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return true if list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check list contains specific object or not
     * @param o searched object
     * @return true if list contains object
     */
    @Override
    public boolean contains(Object o) {
        return (indexOf(o) != -1);
    }

    /**
     * Finds index of the specific Object in the List
     * @param o searched Object
     * @return index of the Object
     */
    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    /**
     * ULLIterator is class which implements ListIterator Interface for moving forward and backward in List
     * @return new instance of ULLIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new ULLIterator(firstNode, 0, 0);
    }

    /**
     * Inserts new element E to the end of the list
     * @param e new element
     * @return true insertion process is completed successfully, otherwise false
     */
    @Override
    public boolean add(E e) {
        insertIntoNode(lastNode, lastNode.numElements, e); // insert to the end(index of numElements)
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list
     * @param o searched Object
     * @return true if searched object is found and removed
     */
    public boolean remove(Object o) {

        int index = 0;
        ListNode<E> node = firstNode;
        // if object is null, delete last element of the list
        if (o == null) {
            while (node != null) {
                for (int ptr = 0; ptr < node.numElements; ptr++) {
                    if (node.elements[ptr] == null) {
                        removeFromNode(node, ptr);
                        return true;
                    }
                }
                index += node.numElements;
                node = node.next;
            }
        } else { // otherwise, find object and delete it
            while (node != null) {
                for (int ptr = 0; ptr < node.numElements; ptr++) {
                    if (o.equals(node.elements[ptr])) {
                        removeFromNode(node, ptr);
                        return true;
                    }
                }
                index += node.numElements;
                node = node.next;
            }
        }
        return false;

    }

    /**
     * Removes all of the elements from this list
     */
    @Override
    public void clear() {
        ListNode<E> node = firstNode.next;
        while (node != null) {
            ListNode<E> temp = node.next;
            node.next = null;
            node.previous = null;
            node.elements = null;
            node = temp;
        }
        lastNode = firstNode; // setting reference of the last node the the first node
        for (int ptr = 0; ptr < firstNode.numElements; ptr++) {
            firstNode.elements[ptr] = null;
        }
        /*
        making firstNode as:
            |--|
            |__| --> inside this we have only array as [n], where n is nodeCapacity
         */
        firstNode.numElements = 0;
        firstNode.next = null;
        size = 0;
    }
    //-----------------------------------------------------------------------

    /**
     * finding node in the specified index
     * @param index index of an element
     * @return 2 sized array which one of them is searched Node, and the other is index of element in array(not in the
     * list)
     */
    private Object[] findNode(int index) {
        int p = 0;
        ListNode<E> node;

        // efficient way for finding specific element
        if (size - index > index) {
            // scan through beginning to the last node
            node = firstNode;
            while (p <= index - node.numElements) {
                p += node.numElements;
                node = node.next;
            }
        } else {
            // scan through last to the beginning node
            node = lastNode;
            p = size;
            while ((p -= node.numElements) > index) {
                node = node.previous;
            }
        }
        return new Object[] {node, p};
    }

    /**
     * return the element at the specified position in the list
     * @param index index of an element
     * @return element in the specified index
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<E> node;
        int p = 0;
        if (size - index > index) {
            node = firstNode;
            while (p <= index - node.numElements) {
                p += node.numElements;
                node = node.next;
            }
        } else {
            node = lastNode;
            p = size;
            while ((p -= node.numElements) > index) {
                node = node.previous;
            }
        }
        return (E) node.elements[index - p];
    }

    /**
     * set value of the element in the specified position to the new value
     * @param index index of the specified element which is needed to modified
     * @param element element in the specified index
     * @return element which is set to new value
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E el = null;
        ListNode<E> node;
        int p = 0;
        if (size - index > index) {
            node = firstNode;
            while (p <= index - node.numElements) {
                p += node.numElements;
                node = node.next;
            }
        } else {
            node = lastNode;
            p = size;
            while ((p -= node.numElements) > index) {
                node = node.previous;
            }
        }
        el = (E) node.elements[index - p];
        node.elements[index - p] = element;
        return el;
    }

    /**
     * Insert the specified element at the specified position in the list
     * @param index index in the list which element will inserted
     * @param element inserted element
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<E> node;
        int p = 0;
        if (size - index > index) {
            node = firstNode;
            while (p <= index - node.numElements) {
                p += node.numElements;
                node = node.next;
            }
        } else {
            node = lastNode;
            p = size;
            while ((p -= node.numElements) > index) {
                node = node.previous;
            }
        }
        insertIntoNode(node, index - p, element);
    }

    /**
     * Remove the element in the specified index
     * @param index specified index of an element which will remove
     * @return removed element
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E element = null;
        ListNode<E> node;
        int p = 0;
        if (size - index > index) {
            node = firstNode;
            while (p <= index - node.numElements) {
                p += node.numElements;
                node = node.next;
            }
        } else {
            node = lastNode;
            p = size;
            while ((p -= node.numElements) > index) {
                node = node.previous;
            }
        }
        element = (E) node.elements[index - p];
        removeFromNode(node, index - p);
        return element;
    }

    /**
     * private class for Node of the List
     * @param <T> data type of the element
     */
    private class ListNode<T> {
        ListNode<T> next; // next node of the specific node
        ListNode<T> previous; // previous node of the specific node
        int numElements; // number of elements in the array in the specific ListNode
        Object[] elements; // elements which is kept in an array

        ListNode() {
            numElements = 0;
            elements = new Object[nodeCapacity]; // initialize length of elements with nodeCapacity
        }
    }

    /**
     * private Unrolled LinkedList Iterator class for iterating in particular block
     */
    private class ULLIterator implements ListIterator<E> {
        ListNode<E> currentNode; // current node
        int ptr; // index for array in the specific ListNode
        int index; // index for all elements in the list
        private int expectedModCount; // counts how many times list has been structurally modified
        ULLIterator(ListNode<E> node, int ptr, int index) {
            this.currentNode = node;
            this.ptr = ptr;
            this.index = index;
            this.expectedModCount = modCount;
        }

        /**
         * Defines is there element in next of the current node
         * @return true if there is an element in the next
         */
        @Override
        public boolean hasNext() {
            return index < size - 1;
        }

        /**
         * Goes to the next element
         * @return the next element
         */
        @Override
        public E next() {
            ptr++;
            if (ptr >= currentNode.numElements) {
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                    ptr = 0;
                } else {
                    throw new NoSuchElementException();
                }
            }
            index++;
            checkForModification();
            return (E) currentNode.elements[ptr];
        }

        /**
         * Defines is there element in previous of the current node
         * @return true if there is an element in the previous
         */
        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        /**
         * Goes to the previous element
         * @return the previous element
         */
        @Override
        public E previous() {
            ptr--;
            if (ptr < 0) {
                if (currentNode.previous != null) {
                    currentNode = currentNode.previous;
                    ptr = currentNode.numElements - 1;
                } else {
                    throw new NoSuchElementException();
                }
            }
            index--;
            checkForModification();
            return (E) currentNode.elements[ptr];
        }

        /**
         *
         * @throws ConcurrentModificationException if our expected modCount is different from modCount which is
         * inherited from superclass for counts how many times the list structurally modified
         */
        private void checkForModification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }

        /**
         * Increments index when goes to the next element
         * @return new index
         */
        @Override
        public int nextIndex() {
            return (index + 1);
        }

        /**
         * Decrements index when goes to the previous element
         * @return new index
         */
        @Override
        public int previousIndex() {
            return (index - 1);
        }

        /**
         * Removes element
         */
        @Override
        public void remove() {
            checkForModification();
            removeFromNode(currentNode, ptr);
        }

        /**
         * Sets specific element to the new value
         * @param e new value
         */
        @Override
        public void set(E e) {
            checkForModification();
            currentNode.elements[ptr] = e;
        }

        /**
         * Insert new element
         * @param e new element
         */
        @Override
        public void add(E e) {
            checkForModification();
            insertIntoNode(currentNode, ptr + 1, e);
        }
    }

    /**
     * Insert element into specified position of the specific node
     * @param node specified ListNode of the list
     * @param ptr index of the array in the specified ListNode
     * @param element new element
     */
    private void insertIntoNode(ListNode<E> node, int ptr, E element) {
        // If specified ListNode is full, then create new one
        if (node.numElements == nodeCapacity) {
            ListNode<E> newNode = new ListNode<>();
            // Moving the half elements of specific ListNode to the new ListNode
            int elementsToMove = nodeCapacity / 2; // number of elements are moved to the new ListNode
            int startIndex = nodeCapacity - elementsToMove; // find half point to start
            for (int i = 0; i < elementsToMove; i++) {
                newNode.elements[i] = node.elements[startIndex + i];
                node.elements[startIndex + i] = null;
            }
            node.numElements -= elementsToMove;
            newNode.numElements = elementsToMove;
            // insert the new node into the list
            newNode.next = node.next;
            newNode.previous = node;
            if (node.next != null) {
                node.next.previous = newNode;
                node.next = newNode;
            }
            // if node is lastNode, make newNode lastNode
            if (node == lastNode) {
                lastNode = newNode;
            }

            if (ptr > node.numElements) {
                node = newNode;
                ptr -= node.numElements;
            }
        }
        for (int i = node.numElements; i > ptr; i--) {
            node.elements[i] = node.elements[i - 1];
        }
        node.elements[ptr] = element;
        node.numElements++;
        size++;
        modCount++;
    }

    /**
     * Removes element in specified position in specific ListNode
     * @param node specified ListNode which removed element in the this ListNode
     * @param ptr position of element in the array which is in the ListNode
     */
    private void removeFromNode(ListNode<E> node, int ptr) {
        node.numElements--;
        for (int i = ptr; i < node.numElements; i++) {
            node.elements[i] = node.elements[i + 1];
        }
        node.elements[node.numElements] = null;
        if (node.next != null && node.next.numElements + node.numElements <= nodeCapacity) {
            mergeWithNextNode(node);
        } else if (node.previous != null && node.previous.numElements + node.numElements <= nodeCapacity) {
            mergeWithNextNode(node.previous);
        }
        size--;
        modCount++;
    }

    /**
     * Merges specified ListNode to its next node in Deletion process
     * @param node merged node
     */
    private void mergeWithNextNode(ListNode<E> node) {
        ListNode<E> next = node.next;
        for (int i = 0; i < next.numElements; i++) {
            node.elements[node.numElements + i] = next.elements[i];
            next.elements[i] = null;
        }
        node.numElements += next.numElements;
        if (next.next != null) {
            next.next.previous = node;
        }
        node.next = next.next;
        if (next == lastNode) {
            lastNode = node;
        }
    }

    /**
     * @return String representation of the list
     */
    @Override
    public String toString() {
        String list = "{ ";
        ListNode<E> node = firstNode;
        while (node != null) {
            list += "[ ";
            for (int i = 0; i < node.numElements; i++) {
                list += node.elements[i];
                if (i < node.numElements - 1)
                    list += ", ";
            }
            list += " ]";
            if (node != lastNode) {
                list += ", ";
            }
            node = node.next;
        }

        return list + " }";
    }
}

