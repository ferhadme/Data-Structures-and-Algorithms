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

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
