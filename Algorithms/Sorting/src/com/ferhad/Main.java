package com.ferhad;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = scan.nextInt();

        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));





    }
}
