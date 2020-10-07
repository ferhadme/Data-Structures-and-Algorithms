package com.ferhad;

public class Main {

    public static void main(String[] args) {
        // Testing LinkedList class...

        LinkedList myLinkedList = new LinkedList();
        myLinkedList.insertAtEnd(5);
        myLinkedList.insertAtEnd(3);
        myLinkedList.insertAtEnd(2);
        // [5, 3, 2]
        myLinkedList.insertAtBegin(0);
        // [0, 5, 3, 2]
        myLinkedList.insert(10, 5);
        // [0, 5, 3, 2, 10]
        myLinkedList.removeAtBegin();
        // [5, 3, 2, 10]
        myLinkedList.removeFromEnd();
        // [5, 3, 2]
        myLinkedList.remove(1);
        // [5, 2]
        int positionOf5 = myLinkedList.getPosition(5); // returning position of 5
        int headOfList = myLinkedList.getHead(); // returning data of head
        myLinkedList.clearList();
        // []

        String listStr = myLinkedList.toString(); // String representation of LinkedList ([str1, str2, ...])

    }
}
