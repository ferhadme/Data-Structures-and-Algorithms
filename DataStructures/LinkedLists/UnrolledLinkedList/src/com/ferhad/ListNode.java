package com.ferhad;

import java.util.List;

public class ListNode<T> {
    private T data;
    private List<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getNext() {
        return next;
    }

    public void setNext(List<T> next) {
        this.next = next;
    }

}
