package com.ferhad;

import java.util.*;

/**
 * @author Ferhad Mehdizade
 *
 * Basic Mathematics Set operations
 * Union, Intersection, Difference of 2 sets
 * @param <T> Type of an element
 */
public class SetCalculator<T extends Comparable<T>> {
    private Object[] set1;
    private Object[] set2;

    /**
     * Initializes sets with specified arrays
     * @param set1 first set
     * @param set2 second set
     */
    public void initializeSets(Object[] set1, Object[] set2) {
        this.set1 = set1;
        this.set2 = set2;
    }

    /**
     * Casts Object element to specified Generic type
     * @param index index of an element in specified set
     * @param set specified set
     * @return generic type of an element
     */
    private T getElementFromSet(int index, Object[] set) {
        return (T) set[index];
    }

    /**
     * Calculates union of 2 sets
     * @return union of 2 sets
     */
    public List<T> union() {
        Map<T, Integer> duplicateChecker = new HashMap<>();
        List<T> union = new ArrayList<>();
        Object[] largeSet;
        int length;
        if (set1.length > set2.length) { // set1 is large array
            largeSet = set1;
            length = set2.length;
        } else { // set2 is large array
            largeSet = set2;
            length = set1.length;
        }

        for (int i = 0; i < length; i++) {
            T elem1 = getElementFromSet(i, set1);
            T elem2 = getElementFromSet(i, set2);
            if (!duplicateChecker.containsKey(elem1)) {
                union.add(elem1);
                duplicateChecker.put(elem1, i);
            }
            if (!duplicateChecker.containsKey(elem2)) {
                union.add(elem2);
                duplicateChecker.put(elem2, i);
            }
        }

        for (int i = length; i < largeSet.length; i++) {
            T elem = getElementFromSet(i, largeSet);
            if (!duplicateChecker.containsKey(elem)) {
                union.add(elem);
                duplicateChecker.put(elem, i);
            }
        }
        Collections.sort(union);

        return union;
    }

    /**
     * Calculates intersection of 2 sets
     * @return intersection of 2 sets
     */
    public List<T> intersection() {
        Map<T, Integer> firstList = new HashMap<>();
        List<T> intersection = new ArrayList<>();
        Object[] smallArr;
        Object[] largeArr; // for reducing number of iterations for better time and space complexity

        if (set1.length > set2.length) {
            smallArr = set2;
            largeArr = set1;
        } else {
            smallArr = set1;
            largeArr = set2;
        }

        for (int i = 0; i < smallArr.length; i++) {
            T elem = getElementFromSet(i, smallArr);
            if (!firstList.containsKey(elem)) {
                firstList.put(elem, i);
            }
        }

        for (int i = 0; i < largeArr.length; i++) {
            T elem = getElementFromSet(i, largeArr);
            if (firstList.containsKey(elem)) {
                intersection.add(elem);
            }
        }
        Collections.sort(intersection);

        return intersection;
    }

    /**
     * Private method for calculating difference of 2 specified sets
     * @param set1P first set parameter
     * @param set2P second set parameter
     * @return difference of sets
     */
    private List<T> difference(Object[] set1P, Object[] set2P) {
        Map<T, Integer> secondList = new HashMap<>();
        List<T> difference = new ArrayList<>();
        for (int i = 0; i < set2P.length; i++) {
            secondList.put(getElementFromSet(i, set2P), i);
        }
        for (int i = 0; i < set1P.length; i++) {
            T elem = getElementFromSet(i, set1P);
            if (!secondList.containsKey(elem)) {
                difference.add(elem);
            }
        }

        return difference;
    }

    /**
     * Calculates difference of first and second set
     * @return difference of first and second set (A/B)
     */
    public List<T> difference1_2() {
        return difference(set1, set2);
    }

    /**
     * Calculates difference of second and first set
     * @return difference of second and first set (B/A)
     */
    public List<T> difference2_1() {
        return difference(set2, set1);
    }

}
