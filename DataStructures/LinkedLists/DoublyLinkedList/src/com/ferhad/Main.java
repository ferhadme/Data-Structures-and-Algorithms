package com.ferhad;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtBegin(5);
        list.insertAtBegin(3);
        list.insertAtBegin(3);
        list.insertAtBegin(3);
        list.insertAtEnd(11);
        list.insert(33, 3);
        list.removeAtBegin();
        list.removeFromEnd();
        System.out.println(list.length());
        System.out.println(list);

    }
}
