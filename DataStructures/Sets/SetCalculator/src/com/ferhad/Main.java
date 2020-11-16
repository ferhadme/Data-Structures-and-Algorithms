package com.ferhad;

public class Main {

    public static void main(String[] args) {
        // Testing...
        SetCalculator<Integer> setC = new SetCalculator<>();
        setC.initializeSets(new Object[] {1, 1, 2, 3, 4}, new Object[] {5, 1, 6, 7, 8, 9, 2, 2});
        System.out.println(setC.union());
        System.out.println(setC.intersection());
        System.out.println(setC.difference1_2());
        System.out.println(setC.difference2_1());
    }
}
