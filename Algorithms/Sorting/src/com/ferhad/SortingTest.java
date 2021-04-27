package com.ferhad;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Unit tests for Sorting Algorithms
 */
public class SortingTest {
    @Test
    public void mergesortTest() {
        Person farhad = new Person("Farhad", 18);
        Person namiq = new Person("Namiq", 24);
        Person cemil = new Person("Cemil", 34);
        Person emin = new Person("Emin", 12);
        Person[] actualPersons = new Person[] {
                farhad, namiq, cemil, emin
        };
        Person[] expectedPersons = new Person[] {
                cemil, emin, farhad, namiq
        };
        MergeSort.mergeSort(actualPersons);
        assertArrayEquals(actualPersons, expectedPersons);
    }
    
}
