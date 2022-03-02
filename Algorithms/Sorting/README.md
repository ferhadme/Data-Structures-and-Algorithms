# In-Place Sorting Algorithms
Sorts the list only by modifying the order of the elements within the list.
### Bubble Sort Algorithm
Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

***Refer to the implementation of [Bubble Sort](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Sorting/src/com/ferhad/BubbleSort.java 'BubbleSort.java file')***

<br/>

### Insertion Sort Algorithm
Starts iterating from the second element of array till last element and for every element insert at its correct position in the subarray before it.

***Refer to the implementation of [Insertion Sort](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Sorting/src/com/ferhad/InsertionSort.java 'InsertionSort.java file')***

<br/>

### Binary Insertion Sort Algorithm
Almost, the same algorithm as original Insertion Sort(which uses [Linear Search Algorithm](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Searching/src/com/ferhad/LinearSearch.java 'LinearSearch.java file') for finding the right position), but this one uses [Binary Search Algorithm](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Searching/src/com/ferhad/BinarySearch.java 'BinarySearch.java file') for finding the right position. Binary Insertion Sort is faster than original Insertion Sort because of binary search.

***Refer to the implementation of [Binary Insertion Sort](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Sorting/src/com/ferhad/BinaryInsertionSort.java 'BinaryInsertionSort.java file')***

<br/>

### Selection Sort Algorithm
Sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. 

The algorithm maintains two subarrays in a given array.
- The subarray which is already sorted.
- Remaining subarray which is unsorted.

***Refer to the implementation of [Selection Sort](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Sorting/src/com/ferhad/SelectionSort.java 'SelectionSort.java file')***

<br/>

```
Time Complexities

Bubble Sort - Ω(n), Θ(n^2), O(n^2)
Insertion Sort - Ω(n), Θ(n^2), O(n^2)
Binary Insertion Sort - Ω(n), Θ(n^2), O(n^2) (Average is still Θ(n^2))
Selection Sort - Ω(n^2), Θ(n^2), O(n^2)
```

```
Space Complexities

Bubble Sort - O(1)
Insertion Sort - O(1)
Selection Sort - O(1)
```

<br/>

# Divide and Conquer Sorting Algorithms
A divide and conquer algorithm is a strategy of solving a large problem by breaking the problem into smaller sub-problems, solving the sub-problems, and combining them to get the desired output.
Merge Sort and Quick Sort based on divide and conquer technique
### Merge Sort Algorithm
Merge sort is a stable divide-and-conquer algorithm based on the idea of breaking down a list into several sub-lists until each sublist consists of a single element and merging those sublists in a manner that results into a sorted list

***Refer to the implementation of [Merge Sort in Java](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Sorting/src/com/ferhad/MergeSort.java 'MergeSort.java file')***
***Refer to the implementation of [Merge Sort in C](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Sorting/src/com/ferhad/merge_sort.c 'merge_sort.c file')***

<br />

### Quick Sort Algorithm
Works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.
The sub-arrays are then sorted recursively. This can be done in-place, requiring small additional amounts of memory to perform the sorting.

Selection of 'pivot' is very important thing, that makes sorting faster, or slower. Pivot usually is selected, in 4 ways:
- First element as pivot
- Last element as pivot
- Median element as pivot
- Random element(in each sub sorting) as pivot

I use last element as pivot in the implementation. ***Refer to the implementation of [Quick Sort](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Sorting/src/com/ferhad/QuickSort.java 'QuickSort.java file')***

<br />

```
Time Complexities

Merge Sort - Ω(n*logn), Θ(n*logn), O(n*logn)
Quick Sort - Ω(n*logn), Θ(n*logn), O(n^2)
```

Time Complexity Analyze of Merge Sort and Quick Sort can be done with Master Theorem

```
Space Complexities

Merge Sort - O(n)
Quick Sort - O(n*logn)
```

<br />

# Additional Sorting Algorithms
### Counting Sort
Counting Sort is not general purpose sorting algorithm. Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be
sorted. This sorting technique is based on keys between a specific range. It works by counting the number of objects having distinct key values (kind of hashing). Then doing
some arithmetic to calculate the position of each object in the output sequence.

My counting sort works for only 0..k range input **yet**. But it can be extended to use with negative values. The main point should be considered here is counting sort
must be used if the range of input values isn't greater than the number of values to be sorted

***Refer to the implementation of [Counting Sort](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Sorting/src/com/ferhad/CountingSort.java 'CountingSort.java file')***

<br />

```
Time Complexity
Counting Sort - Ω(n+k), Θ(n+k), O(n+k)
```

```
Space Complexity
Counting Sort - O(k)
```

<br />

### BogoSort
Bogosort (also known as permutation sort, stupid sort, slowsort, random sort, monkey sort, bobosort or shuffle sort) is a highly inefficient sorting algorithm based on the generate and test paradigm. The function successively generates permutations of its input until it finds one that is sorted.

***Refer to the implementation of [BogoSort](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Sorting/src/com/ferhad/BogoSort.java 'BogoSort.java file')***

```
There is no any exact Time or Space complexity for Bogo Sort. But, Θ(n · n!) can be considered.
```




