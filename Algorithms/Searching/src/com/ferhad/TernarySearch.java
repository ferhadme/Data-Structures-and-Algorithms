package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Ternary Search Algorithm
 */
public class TernarySearch {

    /**
     * Iterative solution
     * @param arr array
     * @param item searched element in the array
     * @return position of the element in the array, if the element is not found, function returns -1
     */
    public static int ternarySearch(int[] arr, int item) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid1 = start + (end - start) / 3;
            int mid2 = end - (end - start) / 3;
            if (item == arr[mid1])
                return mid1;
            else if (item < arr[mid1])
                end = --mid1;
            else if (item == arr[mid2])
                return mid2;
            else if (item > arr[mid2])
                start = ++mid1;
            else {
                start = ++mid1;
                end = --mid2;
            }
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
    public static int ternarySearch(int[] arr, int item, int start, int end) {
        if (start > end)
            return -1;

        int mid1 = start + (end - start) / 3;
        int mid2 = end - (end - start) / 3;

        if (item == arr[mid1])
            return mid1;
        if (item < arr[mid1])
            return ternarySearch(arr, item, start, --mid1);
        if (item == arr[mid2])
            return mid2;
        if (item > arr[mid2])
            return ternarySearch(arr, item, ++mid2, end);

        return ternarySearch(arr, item, ++mid1, --mid2);
    }
}
