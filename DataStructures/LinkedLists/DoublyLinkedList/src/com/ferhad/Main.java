package com.ferhad;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtBegin(5);
        list.insertAtBegin(3);
        list.insertAtBegin(3);
        list.insertAtBegin(3);
        System.out.println(list.toString());
    }
}
