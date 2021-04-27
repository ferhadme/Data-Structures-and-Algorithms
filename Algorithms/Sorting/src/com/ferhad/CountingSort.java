package com.ferhad;

/**
 * @author Ferhad Mehdizade
 *
 * Counting Sort Algorithm
 * Note 1: Counting Sort Algorithm is not general purpose sorting algorithm
 * it is for (elements --> 0..k), where k should be defined in the function call
 *
 * Note 2: Counting sorting isn't implemented with generic. Becuases as noted in Note 1
 * counting sort is good for arrays like (0..k)
 */
public class CountingSort {

    /**
     * Places each element from actual array to new array with indices in the c array(comes from count(...) function)
     * @param arr array
     * @param k range of the array
     * @return new sorted array from actual array
     */
    public static int[] countingSort(int[] arr, int k) {
        int[] c = count(arr, k);
        int[] sortedArr = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            sortedArr[c[current] - 1] = current;
            c[current]--;
        }

        return sortedArr;
    }

    /**
     * Counts elements of the actual array and put the number of each elements in the array to corresponding indices
     * Then apply kind of window algorithm, that sums each element with previous one(except first element). This is for
     * correct indexing in the sorted array
     * @param arr array
     * @param k range of the array
     * @return array that keeps indices for sorting process
     */
    private static int[] count(int[] arr, int k) {
        int[] c = new int[k + 1];
        for (int i : arr)
            c[i]++;
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        return c;
    }

}
