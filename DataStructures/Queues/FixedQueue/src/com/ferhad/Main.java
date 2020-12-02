package com.ferhad;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(87);
        queue.enQueue(12);
        queue.enQueue(23);
        // [2, 3, 4, 87, 12, 23]

        queue.deQueue(); // 2
        queue.deQueue(); // 3
        // [4, 87, 12, 23]

        System.out.println(queue.getFront()); // 4
        System.out.println(queue.getRear()); // 23
        System.out.println(queue);

        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.isFull()); // false

        System.out.println(queue.size()); // 4
    }
}
