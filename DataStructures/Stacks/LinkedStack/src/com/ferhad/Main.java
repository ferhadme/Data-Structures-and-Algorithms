package com.ferhad;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(65);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.contains(65));
        System.out.println(stack.size());

        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.isEmpty());

    }
}
