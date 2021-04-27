package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Merge Sort Algorithm
 */
public class MergeSort {

    /**
     * Function calls recursive merge sort
     * @param arr array
     * @param <T> generic type
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr, arr.length);
    }

    /**
     * Divides array to left and right sub arrays until there are no more sub arrays can be divided,
     * then merges these sub arrays using merge function. Sorting happens in merge process
     * @param arr array
     * @param end end of the sub array
     */
    private static void mergeSort(Object[] arr, int end) {
        if (end < 2) {
            return;
        }

        int middle = end / 2; // pivot
        Object[] left = new Object[middle];
        Object[] right = new Object[end - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }
        for (int i = middle; i < end; i++) {
            right[i - middle] = arr[i];
        }

        mergeSort(left, middle);
        mergeSort(right, end - middle);

        merge(arr, left, right, middle, end - middle);
    }

    /**
     * Merges left and right array into actual array by sorting
     * @param arr array
     * @param left left part of array
     * @param right right part of array
     * @param endL end index of left array
     * @param endR end index of right array
     * @param <T> generic type
     */
    private static <T extends Comparable<T>> void merge(Object[] arr, Object[] left, Object[] right, int endL, int endR) {
        int i = 0, j = 0, k = 0;
        while (i < endL && j < endR) {
            if (((T) left[i]).compareTo((T) right[j]) < 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < endL) {
            arr[k++] = left[i++];
        }
        while (j < endR) {
            arr[k++] = right[j++];
        }
    }

}
