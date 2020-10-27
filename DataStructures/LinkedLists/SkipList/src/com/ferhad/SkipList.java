package com.ferhad;

import java.util.Random;

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
    private double probability;

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
            head = new Node(null, null, level, null, null);

        Node current = head;
        Node last = null;

        while (current != null) {
            if (current.next == null || current.next.key.compareTo(key) > 0) {
                if (level > current.level) {
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
}