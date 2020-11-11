package com.ferhad;

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
    
}
