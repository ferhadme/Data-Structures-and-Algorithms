package com.ferhad;

/**
 * @author Ferhad Mehdizade
 */
public class Recursion {

    /**
     *  Towers of Hanoi puzzle (for description of puzzle refer to https://en.wikipedia.org/wiki/Tower_of_Hanoi )
    */
    public static void towersOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk from rod " + fromRod + " to rod " + toRod);
            return;
        }
        towersOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk from rod " + fromRod + " to rod " + toRod);
        towersOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

    /**
     * Function for checking if array is sorted or not
     * @param arr Array
     * @param index Index of elements of Array. Index should be 0 while function is calling.
     * @return true or false according to Array is sorted or not.
    */
    public static boolean isArrayInSortedOrder(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] <= arr[index + 1] && isArrayInSortedOrder(arr, index + 1);
    }

    /**
     * Function for finding factorial of number
    */
    public static long factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    /**
     * Calculates product of all elements of array
     * In first call of function, index should be 0(represents first element)
     * @param arr Array
     * @param index index of an element
     * @return product
     */
    public static int productOfArrElem(int[] arr, int index) {
        if (index == arr.length) {
            return 1;
        }
        return arr[index] * productOfArrElem(arr, ++index);
    }

    /**
     * Checks string is palindrome or not
     * @param word string
     * @return true if string is palindrome, otherwise false
     */
    public static boolean isPalindrome(String word) {
        if (word.length() == 1)
            return true;
        if (word.charAt(0) != word.charAt(word.length() - 1))
            return false;

        return isPalindrome(word.substring(1, word.length() - 1));
    }

    /**
     * Finds nth number of Fibonacci series
     * @param n index of series
     * @return number in nth index
     */
    public static int fibonacci(int n) {
        if (n <= 2)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Gets number of the Pascal Triangle according to column and row
     * @param column column of the Pascal Triangle
     * @param row row of the Pascal Triangle
     * @return number
     */
    public static int pascalTriangle(int column, int row) {
        if (row == 1 || row == column)
            return 1;
        return pascalTriangle(column - 1, row - 1) + pascalTriangle(column - 1, row);
    }

    /**
     * Euclid's algorithm for finding GCD of two numbers
     * @param a first number
     * @param b second number
     * @return GCD of the numbers
     */
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

}
