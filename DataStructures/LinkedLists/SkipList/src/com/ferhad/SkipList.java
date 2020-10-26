package com.ferhad;

import java.util.Random;

public class SkipList<T extends Comparable<T>, U> {
    private class Node {
        public T key;
        public U value;
        public long level;
        public Node next;
        public Node down;

        public Node(T key, U value, long level, Node next, Node down) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.next = next;
            this.down = down;
        }
    }

    private Node head;
    private Random random;
    private long size;
    private double probability;

    public SkipList() {
        head = new Node(null, null, 0, null, null);
        random = new Random();
        size = 0;
        probability = 0.5;
    }

    private long level() {
        long level = 0;
        while (level <= size && random.nextDouble() < probability) {
            level++;
        }
        return level;
    }
    
}
