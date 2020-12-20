package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Selection Sort Algorithm
 */
public class SelectionSort {

    /**
     * Finds minimum element in unsorted sub array(after current index), then swaps this min element with current element
     * @param arr array
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
