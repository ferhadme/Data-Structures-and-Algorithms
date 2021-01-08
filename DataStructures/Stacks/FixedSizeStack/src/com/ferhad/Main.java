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
        boolean isFull = stack.isFull();
        boolean contains5 = stack.contains(5);
        int size = stack.size();
        String stackStr = stack.toString();


        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);
        stack1.push(9);
        stack1.push(10);
        stack1.pop();
        System.out.println(stack1);
        stack1.clear();
        System.out.println(stack1);

    }
}
