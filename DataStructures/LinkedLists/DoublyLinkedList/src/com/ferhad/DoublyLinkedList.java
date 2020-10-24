package com.ferhad;

/**
 * @author Ferhad Mehdizade
 * Implementation of Doubly LinkedList
 */

public class DoublyLinkedList<T> {
    private ListNode<T> head; // holds the head of the list
    private ListNode<T> tail; // holds the tail of the list
    private int length; // by default 0

    /**
     * @return get the head of the list
     */
    public T getHead() {
        return head.getData();
    }

    /**
     * @return get the tail of the list
     */
    public T getTail() {
        return tail.getData();
    }

    /**
     * insert new data to head of the list
     * @param data inserted data
     */
    public void insertAtBegin(T data) {
        if (head == null) { // list is empty, just create new head/tail
            head = new ListNode<T>(data);
            tail = head;
        } else { // inserting
            ListNode<T> node = new ListNode<>(data);
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        length++;
    }

    /**
     * insert new data to end of the list(after tail)
     * @param data inserted data
     */
    public void insertAtEnd(T data) {
        if (tail == null) { // list is empty, just create new head/tail
            tail = new ListNode<T>(data);
            head = tail;
        } else { // inserting
            ListNode<T> node = new ListNode<>(data);
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
        length++;
    }

    /**
     * remove from head of the list
     */
    public void removeAtBegin() {
        if (head == null) // there is no element to removed
            return;
        // removing
        head.getNext().setPrev(null);
        head = head.getNext();
        length--;
    }

    /**
     * remove from tail of the list
     */
    public void removeFromEnd() {
        if (tail == null) // there is no element to removed
            return;
        // removing
        tail.getPrev().setNext(null);
        tail = tail.getPrev();
        length--;
    }

    /**
     * the most efficient way for searching specific node
     * @param position position of the Node
     * @return searched Node
     */
    private ListNode<T> findNode(int position) {
        int border = length / 2; // finding middle Node of the list
        ListNode<T> temp = null; // variable for keeping reference of searched Node
        if (position < border) {
            // scan through beginning to position
            temp = head;
            for (int i = 0; i < position; i++)
                temp = temp.getNext();
        } else {
            // scan through end to position
            temp = tail;
            for (int i = length - 1; i > position; i--)
                temp = temp.getPrev();
        }
        return temp;
    }

    /**
     * insert new data to the specific position
     * @param position position of the data
     * @param data inserted data
     */
    public void insert(int position, T data) {
        if (position < 0 || position > length) // check for index
            throw new IndexOutOfBoundsException();

        if (position == 0) { // insert to the head
            insertAtBegin(data);
            return;
        } else if (position == length) { // insert to the tail
            insertAtEnd(data);
            return;
        }

        // inserting
        ListNode<T> node = new ListNode<>(data);
        ListNode<T> temp = findNode(position);
        // *<->node <-> temp --*
        temp.getPrev().setNext(node);
        node.setPrev(temp.getPrev());
        node.setNext(temp);
        temp.setPrev(node);
        length++;
    }

    /**
     * remove data from specific position
     * @param position position of the removed data
     */
    public void remove(int position) {
        if (position < 0 || position >= length) // check for index
            throw new IndexOutOfBoundsException();

        if (position == 0) { // remove from head
            removeAtBegin();
            return;
        } else if (position == length - 1) { // remove from tail
            removeFromEnd();
            return;
        }
        // removing
        ListNode<T> removedNode = findNode(position);
        removedNode.getPrev().setNext(removedNode.getNext());
        removedNode.getNext().setPrev(removedNode.getPrev());
        removedNode.setPrev(null);
        removedNode.setNext(null);
        length--;
    }

    /**
     * get position of the specific data
     * @param data data in the position
     * @return position of the searched data. Returns first data that equals to @param data, otherwise -1
     */
    public int getPosition(T data) {
        ListNode temp = head;
        int position = 0;
        while (temp != null) { // iterate over and find position
            if (temp.getData().equals(data))
                return position;
            temp = temp.getNext();
            position++;
        }
        // there is no position with this data
        return -1;
    }

    /**
     * get data in the specific position
     * @param position position of the data
     * @return data
     */
    public T get(int position) {
        if (position < 0 || position >= length) // check for index
            throw new IndexOutOfBoundsException();

        ListNode<T> temp = findNode(position); // find node and return its data
        return temp.getData();
    }

    /**
     * set data in the specific position to the new value
     * @param position position of the data
     * @param data new value
     */
    public void set(int position, T data) {
        if (position < 0 || position >= length) { // check for index
            throw new IndexOutOfBoundsException();
        }

        ListNode<T> temp = findNode(position); // find node and set its data to the new value
        temp.setData(data);
    }

    /**
     * reverse the list
     */
    public void reverse() {
        ListNode<T> currentNode = head;
        ListNode<T> temp = null;

        while (currentNode != null) {
            temp = currentNode.getNext();
            currentNode.setNext(currentNode.getPrev());
            currentNode.setPrev(temp);
            currentNode = currentNode.getPrev();
        }
        temp = head;
        head = tail;
        tail = temp;
    }

    /**
     * @return length of the list
     */
    public int length() {
        return length;
    }

    /**
     * @return Representation of list in the form ["str1", "str2", "str3", .., "strn"]
     */
    @Override
    public String toString() {
        String result = "[";
        ListNode<T> temp = null;
        if (head != null) {
            result += head.getData();
            temp = head.getNext();
        }
        while (temp != null) {
            result += ", " + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    /**
     * clear all nodes of the list
     */
    public void clearList() {
        head = null;
        tail = null;
        length = 0;
    }

}
