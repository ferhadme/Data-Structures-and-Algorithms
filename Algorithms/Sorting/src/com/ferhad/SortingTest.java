package com.ferhad;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Unit tests for Sorting Algorithms
 */
public class SortingTest {
    private static final Person farhad = new Person("Farhad", 18);
    private static final Person namiq = new Person("Namiq", 24);
    private static final Person cemil = new Person("Cemil", 34);
    private static final Person emin = new Person("Emin", 12);

    @Test
    public void mergesortTest() {
        Person[] actualPersons = new Person[] {
                farhad, namiq, cemil, emin
        };
        Person[] expectedPersons = new Person[] {
                cemil, emin, farhad, namiq
        };
        MergeSort.mergeSort(actualPersons);
        assertArrayEquals(actualPersons, expectedPersons);
    }

    @Test
    public void binaryInsertionSortTest() {
        Person[] actualPersons = new Person[] {
                farhad, namiq, cemil, emin
        };
        Person[] expectedPersons = new Person[] {
                cemil, emin, farhad, namiq
        };
        BinaryInsertionSort.binaryInsertionSort(actualPersons);
        assertArrayEquals(actualPersons, expectedPersons);
    }

    @Test
    public void bubbleSortTest() {
        Person[] actualPersons = new Person[] {
                farhad, namiq, cemil, emin
        };
        Person[] expectedPersons = new Person[] {
                cemil, emin, farhad, namiq
        };
        BubbleSort.bubbleSort(actualPersons);
        assertArrayEquals(actualPersons, expectedPersons);
    }
}
