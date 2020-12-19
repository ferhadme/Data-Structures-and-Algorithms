package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Binary Search Algorithm
 */
public class BinarySearch {

    /**
     * Iterative solution
     * @param arr array
     * @param item searched element in the array
     * @return position of the element in the array, if the element is not found, function returns -1
     */
    public static int binarySearch(int[] arr, int item) {
        int start = 0;
        int end = arr.length;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (item < arr[middle]) // search in the left half
                end = middle - 1;
            else if (item > arr[middle]) // search in the right half
                start = middle + 1;
            else
                return middle;
        }

        return -1;
    }

    /**
     * Recursive solution
     * @param arr array
     * @param item searched element in the array
     * @param start start of the new sub array
     * @param end end of the new sub array
     * @return position of the element in the array, if the element is not found, function returns -1
     */
    public static int binarySearch(int[] arr, int item, int start, int end) {
        if (start > end)
            return -1;

        int middle = start + (end - start) / 2;
        if (item < arr[middle]) // search in the left half
            return binarySearch(arr, item, start, middle - 1);
        if (item > arr[middle]) // search in the right half
            return binarySearch(arr, item, middle + 1, end);

        return middle;
    }
}
