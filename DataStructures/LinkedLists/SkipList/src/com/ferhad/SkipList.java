package com.ferhad;

import java.util.Random;

/*
                    b y  n e x t
    - - - - - - - - - - - - - - - - - - - - - - -

    Level1 ------------------------------       |   b
                                                |   y
    Level2 ------------------------------       |
                                                |   d
    Level3 ------------------------------       |   o
                                                |   w
    Level4 ------------------------------       |   n

 */

/**
 * @author Ferhad Mehdizade
 * Implementation of SkipList
 * @param <T> Type of key. Comparable interface is used for comparing elements without worrying about its data type
 * @param <U> Type of value
 */

public class SkipList<T extends Comparable<T>, U> {
    /**
     * private class for each Node of the SkipList
     */
    private class Node {
        T key; // key of the Node
        U value; // value of the Node
        long level; // level of the Node in SkipList
        Node next; // next Node of the specific Node
        Node down; // down Node of the specific Node

        /**
         * Constructs Node by initializing its fields
         */
        Node(T key, U value, long level, Node next, Node down) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.next = next;
            this.down = down;
        }
    }

    private Node head; // holds head of the SkipList
    private int size; // size of the list
    private final Random random; // Random object for getting random number in specific situations
    private final double probability; // probability for inserting Node to different level of the SkipList

    /**
     * Constructs SkipList by initializing its fields
     */
    public SkipList() {
        // head should be created when SkipList is created in level 0
        head = new Node(null, null, 0, null, null);
        size = 0;
        random = new Random();
        /* probability of which level should be Node inserted to depends on the SkipList. But like in most situations
        tossing coin is implemented(H or T)
        */
        probability = 0.5;
    }

    /**
     * Method is needed in Insertion process.
     * @return random level that (>=0) and not exceeds size of the SkipList depending on the probability of the event
     */
    public long level() {
        long level = 0;
        while (level <= size && random.nextDouble() < probability) {
            level++;
        }
        return level;
    }

    /**
     * Adds element to the SkipList with key
     * @param key key of an element
     * @param value inserted element
     */
    public void add(T key, U value) {
        long level = level(); // gets random level
        if (level > head.level) // if node is inserted to new level,
            head = new Node(null, null, level, null, head); // head should be created in this level

        Node current = head;
        Node last = null; // Node for setting down reference of specific Nodes at insertion process

        while (current != null) {
            if (current.next == null || current.next.key.compareTo(key) > 0) {
                if (level >= current.level) { // new level
                    // creating new Node in this level, with key, value by setting reference to next of the current Node
                    Node node = new Node(key, value, current.level, current.next, null);
                    if (last != null) {
                        last.down = node; // setting down reference
                    }
                    current.next = node; // setting next reference of the current Node to inserted Node
                    last = node;
                }
                // All above processes repeated by going down until specific situation
                current = current.down;
                continue;
            } else if (current.next.key.equals(key)) {
                current.next.value = value;
            }
            current = current.next; // go to the next
        }
        size++;
    }

    /**
     * Removes element with specified key from the SkipList
     * @param key specific key of an element
     * @return value of removed element
     */
    public U remove(T key) {
        if (!contains(key))
            return null;
        U value = null; // removed value for returning
        Node current = head;

        // scan through SkipList(like insertion), find an element with specified key, and remove it
        while (current != null) {
            if (current.next == null || current.next.key.compareTo(key) >= 0) {
                if (current.next != null && current.next.key.equals(key)) {
                    value = current.next.value;
                    current.next = current.next.next;
                }
                current = current.down;
                continue;
            }
            current = current.next;
        }

        size--;
        return value;
    }

    /**
     * Checks if list contains an element with specified key
     * @param key specific key of an element
     * @return true if list contains an element, otherwise false
     */
    public boolean contains(T key) {
        return get(key) != null;
    }

    /**
     * Gets an element with specified key and returns it
     * @param key specified key of an element
     * @return searched element
     */
    public U get(T key) {
        Node current = head;
        while (current != null) {
            if (current.next == null || current.next.key.compareTo(key) > 0) {
                current = current.down;
                continue;
            } else if (current.next.key.equals(key)) {
                return current.next.value;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * @return size of the SkipList
     */
    public int size() {
        return size;
    }

}
