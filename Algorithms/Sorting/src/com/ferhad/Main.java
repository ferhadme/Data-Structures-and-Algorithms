package com.ferhad;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// TESTING...
public class Main {

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int size = scan.nextInt();
//        Integer[] arr = new Integer[size];
//        for (int i = 0; i < size; i++)
//            arr[i] = scan.nextInt();

//        shuffle(arr);
//
//        BubbleSort.bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        shuffle(arr);
//
//        InsertionSort.insertionSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        shuffle(arr);
//
//        BinaryInsertionSort.binaryInsertionSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        shuffle(arr);
//
//        SelectionSort.selectionSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        shuffle(arr);

//        MergeSort.mergeSort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(arr[0].byteValue());

//        String[] strarr = new String[] {
//                "D", "C", "B", "A"
//        };
//        MergeSort.mergeSort(strarr);
//        System.out.println(Arrays.toString(strarr));

        Person[] persons = new Person[] {
                new Person("Farhad", 18),
                new Person("Namiq", 20),
                new Person("Emin", 35),
                new Person("Cemil", 64)
        };
        MergeSort.mergeSort(persons);
        System.out.println(Arrays.toString(persons));

//        shuffle(arr);
//
//        QuickSort.quickSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        shuffle(arr);
//
//        int[] sortedArr = CountingSort.countingSort(arr, 5); // my input array is range(0..5)
//        System.out.println(Arrays.toString(sortedArr));
//
//        shuffle(arr);
//        BogoSort.bogoSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * Shuffles elements of the array.
     * @param arr array
     */
    private static void shuffle(Integer[] arr) {
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


