package com.ferhad;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(65);
        stack.pop();
//        System.out.println(stack.peek());
//        System.out.println(stack);
//        System.out.println(stack.contains(65));
//        System.out.println(stack.size());

        stack.pop();
        stack.pop();
//        System.out.println(stack);
//        System.out.println(stack.isEmpty());

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);
        stack1.pop();
        System.out.println(stack1);
        stack1.clear();
        System.out.println(stack1);


    }
}
