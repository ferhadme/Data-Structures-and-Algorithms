package com.ferhad;

import java.util.Stack;

/**
 * @author Ferhad Mehdizade
 *
 * Sorting Stack in asceding order
 * Time Complexity - O(n^2)
 * Space Complexity - O(n) for Stack
 */
public class Sorting {
    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sortedStack.isEmpty() && temp < sortedStack.peek()) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }
}
