package com.ferhad;

/**
 * @author Ferhad Mehdizade
 */
public class Recursion {

    /**
     *  Towers of Hanoi puzzle (for description of puzzle refer to https://en.wikipedia.org/wiki/Tower_of_Hanoi )
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

    /**
     * Function for checking if array is sorted or not
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

    /**
     * Function for finding factorial of number
     * O(n) time complexity, O(n) space complexity
    */
    public long factorial(int num) {
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
    public int productOfArrElem(int[] arr, int index) {
        if (index == arr.length) {
            return 1;
        }
        return arr[index] * productOfArrElem(arr, ++index);
    }
}
