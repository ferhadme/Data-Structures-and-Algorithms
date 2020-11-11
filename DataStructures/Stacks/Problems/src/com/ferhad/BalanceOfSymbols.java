package com.ferhad;

import java.util.Stack;

/**
 * @author Ferhad Mehdizade
 *
 * Stacks can be used to check whether the given expression has balanced symbols
 * This algorithm is very useful in compilers
 * Characters such as (, {, [ can be checked is closed with ), }, ] or not, after a lot of text patterns
 * if (isEmpty()) { System.out.println("It is empty"); }    ==>     Valid pattern
 * if (isEmpty() { System.out.println("It is empty); }      ==>     Invalid pattern(compiler gives error)
 */
public class BalanceOfSymbols {

    /**
     * Checks if pattern is valid or not
     * @param pattern input
     * @return true if pattern is valid, otherwise false
     * Time complexity - O(n) for scanning each character of the input
     * Space complexity - O(n) for Stack
     */
    public static boolean isValidSymbolPattern(String pattern) {
        if (pattern == null || pattern.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        boolean checker = false; // false when character like ", ' opened, true when closed

        for (int i = 0; i < pattern.length(); i++) {
            char character = pattern.charAt(i);
            if (character != '{' && character != '}' && character != '[' && character != ']' &&
                    character != '(' && character != ')' && character != '\'' && character != '\"') {
                continue;
            }

            if ((character == '\'' || character == '\"') && !checker) {
                stack.push(character);
                checker = true; // character is pushed
            }
            else if (character == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else return false;
            }
            else if (character == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else return false;
            }
            else if (character == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else return false;
            }
            else if (character == '\'') {
                if (!stack.isEmpty() && stack.peek() == '\'') {
                    stack.pop();
                    checker = false;
                }
                else return false;
            }
            else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }

    /*
        NOTE: Check cases can be increased for other symbols like
        <></>, **, ``, and etc. Algorithm will be the same
     */

}
