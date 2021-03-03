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
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        while (n > 1) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            n--;
        }
    }

}
