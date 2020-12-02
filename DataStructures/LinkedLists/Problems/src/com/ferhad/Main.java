package com.ferhad;

import com.ferhad.problems.OperationsOnLinkedList;

public class Main {

    public static void main(String[] args) {

        // -------Testing methods...--------
//        Node head = new Node();
//        Node node2 = new Node();
//        head.setNext(node2);
//        Node node3 = new Node();
//        node2.setNext(node3);
//        Node node4 = new Node();
//        node3.setNext(node4);
//        Node node5 = new Node();
//        node4.setNext(node5);
        // head -> node2 -> node3 -> node4 -> node5


        // Testing evenOddNumbers() method...
        Node head = new Node(); head.setData(1);
        Node node2 = new Node(); node2.setData(2); head.setNext(node2);
        Node node3 = new Node(); node3.setData(3); node2.setNext(node3);
        Node node4 = new Node(); node4.setData(4); node3.setNext(node4);
        Node node5 = new Node(); node5.setData(5); node4.setNext(node5);
        Node node6 = new Node(); node6.setData(6); node5.setNext(node6);
        printList(head);
        var op = new OperationsOnLinkedList();
        head = op.evenOddNumbers(head);
        printList(head);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.println();
    }
}
