package com.ferhad;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, arr.length);
    }

    private static void mergeSort(int[] arr, int end) {
        if (end < 2)
            return;

        int middle = end / 2;
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

    private static void merge(int[] arr, int[] left, int[] right, int endL, int endR) {
        int i = 0, j = 0, k = 0;
        while (i < endL && j < endR) {
            if (left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < endL)
            arr[k++] = left[i++];
        while (j < endR)
            arr[k++] = right[j++];

    }

}
