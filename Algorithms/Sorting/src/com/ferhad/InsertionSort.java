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
     * @param <T> generic type
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T current = arr[i];
            int j = i - 1;
            while (j >= 0 && current.compareTo(arr[j]) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

}
