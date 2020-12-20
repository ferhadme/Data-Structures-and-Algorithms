package com.ferhad;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Testing...
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = scan.nextInt();

        shuffle(arr);

        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        shuffle(arr);

        InsertionSort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        shuffle(arr);

        SelectionSort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        shuffle(arr);

        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        shuffle(arr);

        QuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Shuffles elements of the array.
     * @param arr array
     */
    private static void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int index1 = rand.nextInt(arr.length);
            int index2 = rand.nextInt(arr.length);
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }
}


