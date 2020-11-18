package com.ferhad;

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
            int span = 1;
            int j = i - 1;
            while (j >= 0 && input[i] >= input[j]) {
                span++;
                j--;
            }
            spans[i] = span;
        }
        return spans;
    }


}
