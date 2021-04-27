package com.ferhad;

import java.util.Arrays;

/**
 * @author Ferhad Mehdizade
 *
 * Binary Insertion Sort Algorithm
 */
public class BinaryInsertionSort {

    /**
     * Places the current element in each iteration at its suitable place in sorted part of array in each pass by using
     * Binary Search Algorithm
     * @param arr array
     * @param <T> generic type
     *
     * Time Complexity --> O(n) * (O(logn) + O(n)) ==> O(n) * O(n) ==> O(n^2)
     * Almost the same as original Insertion Sort(which uses Linear Search for finding right position) by Time complexity
     * side, but in practise, it is much faster than original Insertion Sort(because of binary search algorithm)
     */
    public static <T extends Comparable<T>> void binaryInsertionSort(T[] arr) { // [3, 1, 4, 2]
//        for (int i = 1; i < arr.length; i++) {
//            T current = arr[i];
//            int index = binarySearch(arr, i, current);
//            System.out.println(index);
//            // shifting i --> index
//            for (int j = i; j > index; j--) {
//                arr[j] = arr[j - 1];
//            }
//            arr[index] = current;
//            System.out.println(Arrays.toString(arr));
//        }
    }

    /**
     * Doing Binary Search through the array according to given high(or end) position, and calculates right position
     * @param arr array
     * @param high last index of sorted part of the array
     * @param element inserted element
     * @param <T> generic type
     * @return position of inserted element
     */
    private static <T extends Comparable<T>> int binarySearch(T[] arr, int high, T element) {
//        if (high <= 1) {
//            return high;
//        }
//
//        int low = 0;
//        while (low < high) {
//            int middle = low + (low + high) / 2;
//            // element is between x, y
//            if (element.compareTo(arr[middle - 1]) > 0 && element.compareTo(arr[middle]) < 0) {
//                return middle;
//            } else if (element.compareTo(arr[middle]) > 0) {
//                low = middle + 1;
//            } else {
//                high = middle - 1;
//            }
//        }
//        return high;
        return 0;
    }
}
