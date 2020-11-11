package com.ferhad;

public class Main {

    public static void main(String[] args) {
        var bos = new BalanceOfSymbols();
        String pattern = "{[a('uuiui')sa''{asas''''}]}"; // true pattern
        System.out.println(bos.isValidSymbolPattern(pattern));

        // =============================================================================================================

        var ipp = new InfixPostfixPrefix();
        String expression = "1 + 2 + 4 * 8 / (4 - 3) - 9";
        System.out.println(ipp.calculate(expression)); // 26.0

    }
}
