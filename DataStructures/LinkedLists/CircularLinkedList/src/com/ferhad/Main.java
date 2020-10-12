package com.ferhad;

public class Main {

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addToHead(2);
//        System.out.println(list);
        list.addToHead(1);
//        System.out.println(list);
        list.addToHead(3);
//        System.out.println(list);
        list.addToHead(43);
//        System.out.println(list);
        list.addToHead(123);
//        System.out.println(list);
        list.addToTail(33333);
//        System.out.println(list);
        list.addToTail(11111);
        list.removeFromHead();
        list.removeFromHead();
        list.removeFromTail();
        System.out.println(list);
        list.remove(33333);
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.contains(3));
        System.out.println(list.peek());
        System.out.println(list.tailPeek());
    }
}
