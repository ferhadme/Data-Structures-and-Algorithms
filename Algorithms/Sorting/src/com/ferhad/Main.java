package com.ferhad;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        Person[] people = new Person[] {
//                new Person("Farhad", 18),
//                new Person("Cemil", 20),
//                new Person("Namiq", 54),
//                new Person("Emin", 31)
//        };
//        BinaryInsertionSort.binaryInsertionSort(people);
//        System.out.println(Arrays.toString(people));
//
        Integer[] nums = new Integer[] {
                3, 1, 4, 2
        };
        BinaryInsertionSort.binaryInsertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}


