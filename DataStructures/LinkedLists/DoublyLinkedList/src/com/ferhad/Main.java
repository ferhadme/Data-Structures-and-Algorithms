package com.ferhad;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(5);
        list.insertAtEnd(3);
        list.insertAtEnd(1);
        list.insertAtEnd(3);
        list.insertAtEnd(9);
        System.out.println(list);
        System.out.println(list.getPosition(3));

    }
}
