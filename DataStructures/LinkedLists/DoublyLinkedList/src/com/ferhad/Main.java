package com.ferhad;

public class Main {

    public static void main(String[] args) {
//        // Testing DoublyLinkedList class...
//
//        DoublyLinkedList list = new DoublyLinkedList();
//        list.insertAtEnd(5);
//        list.insertAtEnd(3);
//        list.insertAtEnd(1);
//        // [5, 3, 1]
//        list.insertAtBegin(11);
//        // [11, 5, 3, 1]
//        list.insert(33, 2);
//        // [11, 5, 33, 3, 1]
//        list.removeAtBegin();
//        // [5, 33, 3, 1]
//        list.removeFromEnd();
//        // [5, 33, 3]
//        list.remove(1);
//        // [5, 33]
//        list.length(); //  2
//        list.get(1); // 33
//        list.getPosition(33); // 1
//        list.getHead(); // 5
//        list.clearList();
//        // []
//
//        System.out.println(list);
//        // []

        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtBegin(4);
        list.insertAtBegin(2);
        list.insertAtBegin(12);
        list.insertAtBegin(5);
        list.insertAtBegin(111);
        list.insertAtBegin(1212);
        list.insertAtEnd(33);
        list.insertAtEnd(45);
        list.insertAtEnd(98);
        list.insertAtEnd(67);
//        System.out.println(list);
//        System.out.println(list.length());
//        System.out.println(list.getHead());
//        System.out.println(list.getTail());
        list.removeAtBegin();
        list.removeAtBegin();
        list.removeAtBegin();
//        System.out.println(list);
//        System.out.println(list.length());
//        System.out.println(list.getHead());
//        System.out.println(list.getTail());
        list.removeFromEnd();
        list.removeFromEnd();
        list.removeFromEnd();
        System.out.println(list);
//        System.out.println(list.length());
//        System.out.println(list.getHead());
//        System.out.println(list.getTail());

        System.out.println(list.findNode(0).getData());
        System.out.println(list.findNode(1).getData());
        System.out.println(list.findNode(2).getData());
        System.out.println(list.findNode(3).getData());









    }
}
