package com.ferhad;

/**
 * @author Ferhad Mehdizade
 * Any function which calls itself is called recursive.
 */

public class Recursion {

    /* Towers of Hanoi puzzle (for description of puzzle refer to https://en.wikipedia.org/wiki/Tower_of_Hanoi )
     * Algorithm:
     * Move the top n-1 disks from Source to Auxiliary tower;
     * Move n^th disk from Source to Destination tower;
     * Move the n-1 disks from Auxiliary tower to Destination tower;
     * Transferring the top n-1 disks from Source to Auxiliary tower can again be thought of as a fresh problem and can
     * be solved in the same manner.
    */
    public void towersOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk from rod " + fromRod + " to rod " + toRod);
            return;
        }
        // Move top n-1 disks from A to B, using C as auxiliary
        towersOfHanoi(n - 1, fromRod, auxRod, toRod);

        // Move remaining disks from A to C
        System.out.println("Move disk from rod " + fromRod + " to rod " + toRod);

        // Move n-1 disks from B to C using A as auxiliary
        towersOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

    /** Function for checking if array is sorted or not
     * @param arr Array
     * @param index Index of elements of Array. Index should be 0 while function is calling.
     * @return true or false according to Array is sorted or not.
     * O(n) time complexity, and O(n) space complexity for recursive stack space
    */
    public boolean isArrayInSortedOrder(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] <= arr[index + 1] && isArrayInSortedOrder(arr, index + 1);
    }

    /* Function for finding factorial of number
     * O(n) time complexity, O(n) space complexity
    */
    public long factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
