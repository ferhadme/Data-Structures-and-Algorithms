package com.ferhad;

public class Main {

    public static void main(String[] args) {
        // Testing Stack class...
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(12);
        int topElem = stack.peek();
        int removedElem = stack.pop();
        boolean isEmpty = stack.isEmpty();
        boolean contains5 = stack.contains(5);
        int size = stack.size();
        String stackStr = stack.toString();
    }
}