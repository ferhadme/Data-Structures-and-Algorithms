package com.ferhad;

public class Main {

    public static void main(String[] args) {
        BalanceOfSymbols bos = new BalanceOfSymbols();
        String pattern = "{[a('uuiui')sa''{asas''''}]}"; // true pattern
        System.out.println(bos.isValidSymbolPattern(pattern));

    }
}
