package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Binary Insertion Sort Algorithm
 */
public class BinaryInsertionSort {

    /**
     * Places the current element in each iteration at its suitable place in sorted part of array in each pass by using
     * Binary Search Algorithm
     * @param arr array
     *
     * Time Complexity --> O(n) * (O(logn) + O(n)) ==> O(n) * O(n) ==> O(n^2)
     * Almost the same as original Insertion Sort(which uses Linear Search for finding right position) by Time complexity
     * side, but in practise, it is much faster than original Insertion Sort(because of binary search algorithm)
     */
    public static void binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int index = binarySearch(arr, i - 1, current);
            // shifting i --> index
            for (int j = i; j > index; j--) {
                arr[j] = arr[j - 1];
            }
            arr[index] = current;
        }
    }

    /**
     * Doing Binary Search through the array according to given high(or end) position, and calculates right position
     * @param arr array
     * @param high last index of sorted part of the array
     * @param element inserted element
     * @return position of inserted element
     */
    private static int binarySearch(int[] arr, int high, int element) {
        if (element < arr[0])
            return 0;
        int low = 1;
        while (low < high) {
            int middle = low + (low + high) / 2;
            if (element > arr[middle - 1] && element < arr[middle])
                return middle;
            else if (element > arr[middle])
                low = middle + 1;
            else
                high = middle - 1;
        }
        return high + 1;
    }
}
