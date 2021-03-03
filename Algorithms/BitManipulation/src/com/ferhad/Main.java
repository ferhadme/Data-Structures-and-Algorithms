package com.ferhad;

public class Main {

    public static void main(String[] args) {
        /*System.out.println(Addition.add("0", "0").equals("0"));
        System.out.println(Addition.add("0", "1").equals("1"));
        System.out.println(Addition.add("1", "0").equals("1"));
        System.out.println(Addition.add("1", "1").equals("10"));
        System.out.println(Addition.add("10", "10").equals("100"));
        System.out.println(Addition.add("11", "111").equals("1010"));
        System.out.println(Addition.add("1011101", "101010").equals("10000111"));
        System.out.println(Addition.add("10", "11").equals("101"));
        System.out.println(Addition.add("11", "11").equals("110"));
        System.out.println(Addition.add("11100", "10101").equals("110001"));
        System.out.println(Addition.add("1010011", "10101").equals("1101000"));
        System.out.println(Addition.add("1001", "1001001").equals("1010010"));
        System.out.println(Addition.add("1010", "10010101").equals("10011111"));
        System.out.println(Addition.add("100111111111", "101001").equals("101000101000"));
*/

/*
        System.out.println(addBinary("0", "0").equals("0"));
        System.out.println(addBinary("0", "1").equals("1"));
        System.out.println(addBinary("1", "0").equals("1"));
        System.out.println(addBinary("1", "1").equals("10"));
        System.out.println(addBinary("10", "10").equals("100"));
        System.out.println(addBinary("11", "111").equals("1010"));
        System.out.println(addBinary("1011101", "101010").equals("10000111"));
        System.out.println(addBinary("10", "11").equals("101"));
        System.out.println(addBinary("11", "11").equals("110"));
        System.out.println(addBinary("11100", "10101").equals("110001"));
        System.out.println(addBinary("1010011", "10101").equals("1101000"));
        System.out.println(addBinary("1001", "1001001").equals("1010010"));
        System.out.println(addBinary("1010", "10010101").equals("10011111"));
        System.out.println(addBinary("100111111111", "101001").equals("101000101000"));
*/

    }

    /*
    static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int s = 0;

        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);
            result.insert(0, (char) (s % 2 + '0'));
            s /= 2;
            i--; j--;
        }
        return result.toString();
    }
     */


}
