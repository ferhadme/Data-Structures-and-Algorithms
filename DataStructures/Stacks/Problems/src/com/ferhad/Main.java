package com.ferhad;

public class Main {

    public static void main(String[] args) {
/*
        var bos = new BalanceOfSymbols();
        String pattern = "{[a('uuiui')sa''{asas''''}]}"; // true pattern
        System.out.println(bos.isValidSymbolPattern(pattern));
*/
        // =============================================================================================================
/*
        var ipp = new InfixPostfixPrefix();
        String expression = "1 + 2 + 4 * 8 / (4 - 3) - 9";
        System.out.println(ipp.calculate(expression)); // 26.0
*/
        // =============================================================================================================

        var stack = new SpecificStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(6);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.getMaximum());
        System.out.println(stack.getMinimum());

    }
}
