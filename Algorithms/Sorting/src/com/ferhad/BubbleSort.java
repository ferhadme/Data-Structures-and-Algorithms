package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Bubble Sort Algorithm
 */
public class BubbleSort {

    /**
     * Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order
     * @param arr array
     * @param <T> generic type
     */
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        while (n > 1) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            n--;
        }
    }

}
