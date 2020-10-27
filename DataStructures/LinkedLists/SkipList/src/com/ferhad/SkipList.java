package com.ferhad;

import java.util.Random;

/**
 *
 * @param <T>
 * @param <U>
 */

public class SkipList<T extends Comparable<T>, U> {
    /**
     * private class for each Node of the SkipList
     */
    private class Node {
        T key;
        U value;
        long level;
        Node next;
        Node down;

        Node(T key, U value, long level, Node next, Node down) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.next = next;
            this.down = down;
        }
    }

    private Node head;
    private int size;
    private Random random;
    private final double probability;

    public SkipList() {
        head = new Node(null, null, 0, null, null);
        size = 0;
        random = new Random();
        probability = 1/2;
    }

    public long level() {
        long level = 0;
        while (level <= size && random.nextDouble() < probability) {
            level++;
        }
        return level;
    }

    public void add(T key, U value) {
        long level = level();
        if (level > head.level)
            head = new Node(null, null, level, null, head);

        Node current = head;
        Node last = null;

        while (current != null) {
            if (current.next == null || current.next.key.compareTo(key) > 0) {
                if (level >= current.level) {
                    Node node = new Node(key, value, current.level, current.next, null);
                    if (last != null) {
                        last.down = node;
                    }
                    current.next = node;
                    last = node;
                }
                current = current.down;
                continue;
            } else if (current.next.key.equals(key)) {
                current.next.value = value;
            }
            current = current.next;
        }
        size++;
    }

    public U remove(T key) {
        U value = null;
        Node current = head;
        boolean successfulDeletion = false;
        while (current != null) {
            if (current.next == null || current.next.key.compareTo(key) >= 0) {
                if (current.next != null && current.next.key.equals(key)) {
                    value = current.next.value;
                    current.next = current.next.next;
                    successfulDeletion = true;
                }
                current = current.down;
                continue;
            }
            current = current.next;
        }

        if (successfulDeletion)
            size--;
        return value;
    }

    public boolean contains(T key) {
        return get(key) != null;
    }

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

    public int size() {
        return size;
    }
}
