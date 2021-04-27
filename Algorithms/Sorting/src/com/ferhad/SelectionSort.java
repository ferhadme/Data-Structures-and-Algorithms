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
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
