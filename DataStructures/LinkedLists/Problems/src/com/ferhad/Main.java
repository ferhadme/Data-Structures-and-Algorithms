package com.ferhad;

import com.ferhad.problems.OperationsOnLinkedList;

public class Main {

    public static void main(String[] args) {

        // -------Testing isLinkedListEven() method...--------
        var op = new OperationsOnLinkedList();
        Node head = new Node();
        Node node2 = new Node();
        head.setNext(node2);
        Node node3 = new Node();
        node2.setNext(node3);
        Node node4 = new Node();
        node3.setNext(node4);
        Node node5 = new Node();
        node4.setNext(node5);
        System.out.println(op.isLinkedListEven(head));


    }
}
