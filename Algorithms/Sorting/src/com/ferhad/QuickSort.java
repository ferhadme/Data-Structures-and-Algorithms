package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Quick Sort Algorithm
 */
public class QuickSort {

    /**
     * Function calls recursive quick sort
     * @param arr array
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Defines partition index in each partition(...) call. Repeat the same process, for left and right part of index.
     * Sorting happens in partition(...) function.
     * @param arr array
     * @param begin begin index of the sub array
     * @param end end index of the sub array
     */
    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partition = partition(arr, begin, end);

            quickSort(arr, begin, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }

    /**
     * Defines pivot in the array between begin and end indices. I take last element as pivot for simplicity
     * Then basically, takes smaller elements than pivot to the left side, and larger elements to the right side
     * @param arr array
     * @param begin begin index of the sub array
     * @param end end index of the sub array
     * @return new partition index which indicates this element is in the correct place, do the same process for left
     * and right side
     */
    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;

        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }

}