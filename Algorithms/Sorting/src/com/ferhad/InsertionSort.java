package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Insertion Sort Algorithm
 */
public class InsertionSort {

    /**
     * Places the current element in each iteration at its suitable place in sorted part of array in each pass
     * @param arr array
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

}
