package com.ferhad;

import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class SetCalculator<T extends Comparable<T>> {
    private Object[] set1;
    private Object[] set2;

    public void initializeSets(Object[] set1, Object[] set2) {
        this.set1 = set1;
        this.set2 = set2;
    }

    private T getElementFromSet(int index, Object[] set) {
        return (T) set[index];
    }

    public List<T> union() {
        Hashtable<T, Integer> duplicateChecker = new Hashtable<>();
        List<T> union = new LinkedList<>();
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

    public List<T> intersection() {
        Hashtable<T, Integer> firstList = new Hashtable<>();
        List<T> intersection = new LinkedList<>();
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


}
