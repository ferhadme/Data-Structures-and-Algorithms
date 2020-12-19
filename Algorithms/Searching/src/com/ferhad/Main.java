package com.ferhad;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = scan.nextInt();
        int item = scan.nextInt();

        System.out.println(LinearSearch.linearSearch(arr, item));
        System.out.println(LinearSearch.linearSearch(arr, item, 0));
        System.out.println(BinarySearch.binarySearch(arr, item));
        System.out.println(BinarySearch.binarySearch(arr, item, 0, arr.length));
    }
}
