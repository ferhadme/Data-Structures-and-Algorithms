package com.ferhad;

import java.util.Stack;

/**
 * @author Ferhad Mehdizade
 *
 * Infix to Postfix conversion algorithm using Stack Data Structure
 * Computers calculate mathematical expressions in right order using these algorithms
 * Basic version is described in here
 *
 * Firstly, what is infix, prefix, postfix?
 * Infix ==>     (A + B) + (C - D)       ==> We input and understand mathematical expressions in this form
 *
 * But Computers, use prefix and postfix in order to understanding mathematical expressions
 *
 * => (A + B) + (C - D)
 * => +AB(sum of A and B)
 * => ++AB(adding ... to sum of A and B)
 * => -CD(... = subtract D from C)
 * => Finally, Prefix is ==>    ++AB-CD
 *
 * Postfix is easier for conversion. That's why most system uses Postfix
 * => (A + B) + (C - D)
 * => AB+
 * => CD-
 * => Postfix =>    AB+CD-+ (Sum of, A + B and C - D)
 *
 * I use Postfix for conversion and calculating
 *
 * <b> NOTE: ALGORITHM WORKS FOR ONLY SINGLE DIGIT NUMBERS!!! </b>
 */
public class InfixPostfixPrefix {

    /**
     * Asks user to input expression in order to calculating
     * @return result of the expression
     */
    public double calculate(String expression) {
        expression = expression.replace(" ", ""); // removing all spaces from string

        String[] postfixTokens;
        postfixTokens = convertToPostfix(expression);

        return expressionEvaluation(postfixTokens);
    }

    /**
     * Converts expression to Postfix in form of array of String,
     * where each String is Postfix element
     * @param expression expression needed to convert to Postfix
     * @return array of Postfix elements
     * @throws IllegalArgumentException if character is not operand or operator
     */
    private String[] convertToPostfix(String expression) {
        String postfix = "";
        Stack<Character> stackChar = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c != '(' && c != ')' && c != '+' && c != '-' && c != '*' && c != '/' &&
                    !Character.isLetterOrDigit(c)) {
                throw new IllegalArgumentException("Wrong style input");
            }
            if (Character.isLetterOrDigit(c)) // if scanned character is an operand, add it to output
                postfix += c;
            else if (c == '(')
                stackChar.push(c);
            else if (c == ')') {
                while (!stackChar.isEmpty() && stackChar.peek() != '(')
                    postfix += stackChar.pop();
                stackChar.pop(); // pops '('
            } else { // an operator is encountered
                while (!stackChar.isEmpty() && precedence(c) <= precedence(stackChar.peek()))
                    postfix += stackChar.pop();
                stackChar.push(c);
            }
        }

        while (!stackChar.isEmpty()) {
            if (stackChar.peek() == '(')
                throw new IllegalArgumentException("Wrong style input");
            postfix += stackChar.pop();
        }
        return postfix.split("");
    }

    /**
     * Defines precedence of specific operator
     * Precedence of *, / is higher than +, -
     * @param c operator
     * @return precedence of the operator
     */
    private int precedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    /**
     * Calculates Postfix (for example, 123*+5-)
     * Main Algorithm: pop 2 operands from Stack and do operation according to operator when scanning character is the
     * operator through scanning. At the same time if scanned character is operand, push it onto the stack.
     * @param tokens String array that contains Postfix elements sequentially ( ["1", "2", "3", "*", "+", "5", "-"] )
     * @return result of an expression (123*+5- = (2*3)+1-5 = 2)
     */
    private double expressionEvaluation(String[] tokens) {
        Stack<Double> numberContainer = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                double op1 = numberContainer.pop();
                double op2 = numberContainer.pop();
                numberContainer.push(op1 + op2);
            } else if (token.equals("-")) {
                double op1 = numberContainer.pop();
                double op2 = numberContainer.pop();
                numberContainer.push(op2 - op1);
            } else if (token.equals("*")) {
                double op1 = numberContainer.pop();
                double op2 = numberContainer.pop();
                numberContainer.push(op1 * op2);
            } else if (token.equals("/")) {
                double op1 = numberContainer.pop();
                double op2 = numberContainer.pop();
                numberContainer.push(op2 / op1);
            } else {
                numberContainer.push(Double.parseDouble(token));
            }
        }
        return numberContainer.pop(); // result
    }

}
