package com.ferhad;

import java.util.Scanner;
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
 */
public class InfixPostfixPrefix {

    public double calculate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the expression for calculating(+, -, *, / are allowed): ");
        String expression = scan.nextLine();
        scan.close();
        expression = expression.replace(" ", ""); // removing all spaces from string
        
        return 0;
    }

    /**
     * Calculating Postfix (for example, 123*+5-)
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
                numberContainer.push(op1 - op2);
            } else if (token.equals("*")) {
                double op1 = numberContainer.pop();
                double op2 = numberContainer.pop();
                numberContainer.push(op1 * op2);
            } else if (token.equals("/")) {
                double op1 = numberContainer.pop();
                double op2 = numberContainer.pop();
                numberContainer.push(op1 / op2);
            } else {
                numberContainer.push(Double.parseDouble(token));
            }
        }
        return numberContainer.pop(); // result
    }

}
