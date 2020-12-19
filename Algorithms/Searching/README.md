# Searching Algorithms

### Linear Search
Linear Search is searching algorithm for finding specific element in the list by traversing whole list until searched element is found.

```
Time Complexity - O(n). Because, in the worst case(list not contain searched element), whole list should be traversed.
```

***Refer to the implementation of Linear Search: [Linear Search](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Searching/src/com/ferhad/LinearSearch.java 
'LinearSearch.java file')***

### Binary Search 
Binary Search is the most efficient searching algorithm. But it works only for sorted lists.

Binary Search performs the search operation by repeatedly dividing the search interval in half. The idea is to begin with an interval covering the whole array. If the value of 
the search key is less than the item in the middle of the interval, narrow the interval to the lower half. Otherwise narrow it to the upper half. Repeatedly check until the 
value is found or the interval is empty.

```
Time Complexity - O(logn). Because, the size of the array is decreased 2 times in each iteration(or call)
```

***Refer to the implementation of Binary Search: [Binary Search](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Searching/src/com/ferhad/BinarySearch.java 
'BinarySearch.java file')***

### Ternary Search
Ternary Search is similar to the Binary Search algorithm but rather than dividing the array into two parts, it divides the array into three equal parts.

```
Time Complexity - O(log3(n)). Because, the size of the array is decreased 3 times in each iteration(or call)
```

***Refer to the implementation of Ternary Search: [Ternary Search](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/Algorithms/Searching/src/com/ferhad/TernarySearch.java 
'TernarySearch.java file')***

### Comparison between Binary and Ternary Search
From the first look, it seems the ternary search does less number of comparisons as it makes Log3n recursive calls, but binary search makes Log2n recursive calls.

If we write recursive formulas for both algorithms, it can be seen Binary Search is more efficient than Ternary Search:

```
T(n) = T(n/2) + 2, Binary Search
T(n) = T(n/3) + 4, Ternary Search
```

<br/>

**Additional Note: It can be seen, there is no combination of sub parts after dividing. That's why, Binary and Ternary Search are not 'divide and conquer' algorithms. They are 'decrease and conquer' 
algorithms**

**Additional Note 2: Ternary Search Algorithm works for 'size > 3'. That's why it can throw Exception at runtime for accessing out of bound**
