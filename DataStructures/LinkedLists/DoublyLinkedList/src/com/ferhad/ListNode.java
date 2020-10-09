package com.ferhad;

public class ListNode {
    private int data;
    private ListNode prev;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode prev, ListNode next) {
        this(data);
        this.prev = prev;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
