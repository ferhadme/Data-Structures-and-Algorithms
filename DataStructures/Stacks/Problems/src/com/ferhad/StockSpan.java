package com.ferhad;

import java.util.Stack;

/**
 * @author Ferhad Mehdizade
 *
 * Stock Span Problem
 * This is a very common problem in stock markets to find the peaks. Spans are used in financial ananlysis
 * Stock span is defined as a number of consecutive days prior to the current day when the price of a stock was less
 * than or equal to the price at current day.
 */
public class StockSpan {
    /**
     * Brute-Force solution
     * @param input stock prices
     * @return span of each day
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public int[] findSpans(int[] input) {
        int[] spans = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            spans[i] = 1;
            for (int j = i - 1; j >= 0 && input[i] >= input[j]; j--) {
                spans[i]++;
            }
        }
        return spans;
    }

    /**
     * Efficient solution by using Stack(as S indicates)
     * @param input stock prices
     * @return span of each day
     * Time Complexity - O(n)
     * Space Complexity - O(n) for Stack
     */
    public int[] findSpansS(int[] input) {
        if (input.length == 0)
            return new int[] {0};

        Stack<Integer> stack = new Stack<>();
        int[] spans = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && input[stack.peek()] <= input[i]) {
                stack.pop();
            }
            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return spans;
    }

}
