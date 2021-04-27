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
    public void mergeSortTest() {
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

    @Test
    public void selectionSortTest() {
        Person[] actualPersons = new Person[] {
                farhad, namiq, cemil, emin
        };
        Person[] expectedPersons = new Person[] {
                cemil, emin, farhad, namiq
        };
        SelectionSort.selectionSort(actualPersons);
        assertArrayEquals(actualPersons, expectedPersons);
    }

    @Test
    public void countingSortTest() {
        int[] actualArr = new int[] {5, 4, 3, 2, 1};
        int[] expectedArr = new int[] {1, 2, 3, 4, 5};
        int[] sortedArr = CountingSort.countingSort(actualArr, 5);
        assertArrayEquals(sortedArr, expectedArr);
    }

    @Test
    public void insertionSortTest() {
        Person[] actualPersons = new Person[] {
                farhad, namiq, cemil, emin
        };
        Person[] expectedPersons = new Person[] {
                cemil, emin, farhad, namiq
        };
        InsertionSort.insertionSort(actualPersons);
        assertArrayEquals(actualPersons, expectedPersons);
    }

    @Test
    public void bogoSortTest() {
        Person[] actualPersons = new Person[] {
                farhad, namiq, cemil, emin
        };
        Person[] expectedPersons = new Person[] {
                cemil, emin, farhad, namiq
        };
        BogoSort.bogoSort(actualPersons);
        assertArrayEquals(actualPersons, expectedPersons);
    }
}
