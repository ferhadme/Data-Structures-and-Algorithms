package com.ferhad;

public class Main {

    public static void main(String[] args) {
	    Queue<Integer> queue = new Queue<>();
	    queue.enQueue(1);
	    queue.enQueue(2);
	    queue.enQueue(3);
	    queue.enQueue(4);
	    queue.enQueue(5);
        System.out.println(queue);
        queue.deQueue();
		System.out.println(queue);
		System.out.println(queue.front());
		System.out.println(queue.rear());
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.contains(4));
		System.out.println(queue.contains(10));
    }
}
