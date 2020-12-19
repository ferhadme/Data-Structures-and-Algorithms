package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Linear Search Algorithm
 */
public class LinearSearch {

    /**
     * Iterative solution
     * @param arr array
     * @param item searched element in the array
     * @return position of the element in the array, if the element is not found, function returns -1
     */
    public static int linearSearch(int[] arr, int item) {
        for (int i = 0; i < arr.length; i++) {
            if (item == arr[i])
                return i;
        }
        return -1;
    }

    /**
     * Recursive solution
     * @param arr array
     * @param item searched element in the array
     * @param pos position of the element in each recursive call
     * @return position of the element in the array, if the element is not found, function returns -1
     */
    public static int linearSearch(int[] arr, int item, int pos) {
        if (pos == arr.length)
            return -1;
        if (item == arr[pos])
            return pos;

        return linearSearch(arr, item, ++pos);
    }

}
