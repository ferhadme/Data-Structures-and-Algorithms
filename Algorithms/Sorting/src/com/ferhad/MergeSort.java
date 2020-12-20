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
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, arr.length);
    }

    /**
     * Divides array to left and right sub arrays until there are no more sub arrays can be divided,
     * then merges these sub arrays using merge function. Sorting happens in merge process
     * @param arr array
     * @param end end of the sub array
     */
    private static void mergeSort(int[] arr, int end) {
        if (end < 2)
            return;

        int middle = end / 2; // pivot
        int[] left = new int[middle];
        int[] right = new int[end - middle];

        for (int i = 0; i < middle; i++)
            left[i] = arr[i];
        for (int i = middle; i < end; i++)
            right[i - middle] = arr[i];

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
     */
    private static void merge(int[] arr, int[] left, int[] right, int endL, int endR) {
        int i = 0, j = 0, k = 0;
        while (i < endL && j < endR) {
            if (left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        // for remaining elements of sub arrays
        while (i < endL)
            arr[k++] = left[i++];
        while (j < endR)
            arr[k++] = right[j++];

    }

}
