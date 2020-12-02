package com.ferhad;

public class Main {

    public static void main(String[] args) {
        // Testing LinkedList class...

        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.insertAtEnd(5);
        myLinkedList.insertAtEnd(3);
        myLinkedList.insertAtEnd(2);
        // [5, 3, 2]
        myLinkedList.insertAtBegin(0);
        // [0, 5, 3, 2]
        myLinkedList.insert(2, 10);
        // [0, 5, 10, 3, 2]
        myLinkedList.removeAtBegin();
        // [5, 10, 3, 2]
        myLinkedList.reverse();
        // [2, 3, 10, 5]
        myLinkedList.reverse();
        // [5, 10, 3, 2]
        myLinkedList.removeFromEnd();
        // [5, 10, 3]
        myLinkedList.set(1, 11);
        // [5, 11, 3]
        myLinkedList.remove(1);
        // [5, 3]
        int data = myLinkedList.get(1); // returning data at the position 1 (2)
        int dataFromEnd = myLinkedList.getFromEnd(1); // returning data at the position from the end of the List
        int positionOf5 = myLinkedList.getPosition(5); // returning position of 5
        int headOfList = myLinkedList.getHead(); // returning data of head
        myLinkedList.clearList();
        // []

        String listStr = myLinkedList.toString(); // String representation of LinkedList ([str1, str2, ...])
        myLinkedList.printFromEnd(); // Displays LinkedList from end


        // Testing additional methods...
        LinkedList<Integer> list1 = new LinkedList<>();
        // inserting
        list1.insertAtEnd(1);
        list1.insertAtEnd(3);
        list1.insertAtEnd(5);
        // cloning
        LinkedList<Integer> clonedList1 = list1.clone();
        System.out.println(list1 + "\n" + clonedList1 + "\n************************************************");
        // merging
        LinkedList<Integer> mergedList = list1.merge(clonedList1);
        System.out.println(list1 + "\n" + clonedList1 + "\n" + mergedList);


    }
}
