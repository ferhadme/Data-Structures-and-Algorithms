package com.ferhad;

public class Node<T> {
    private T data;
    private T left;
    private T right;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public T getRight() {
        return right;
    }

    public void setRight(T right) {
        this.right = right;
    }

}
