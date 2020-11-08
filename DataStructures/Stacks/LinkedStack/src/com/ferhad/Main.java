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
        stack1.push(4);
        stack1.push(4);
        stack1.push(4);
        stack1.push(4);
        stack1.push(4);
        stack1.push(4);
        stack1.push(4);
        stack1.push(4);
        System.out.println(stack1);
        stack1.clear();
        System.out.println(stack1);


    }
}
