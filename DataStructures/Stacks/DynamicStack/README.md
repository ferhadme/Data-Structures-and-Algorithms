# Stack implementation by using dynamic array
In [Implementation with static array](https://github.com/ferhad2207/Data-Structures-and-Algorithms/tree/master/DataStructures/Stacks/FixedSizeStack "Stack implementation by using static array")
main problem is not flexible size. So size of the Stack must be defined when it is created. And exception will occur(of course) if new element is pushed into **full Stack**

### Alternative Approach
**Doubling array technique can solve this problem**
Stack can be created initially **size = 10**. And **size can be doubled** when new element is pushed into full Stack. After doubling process, all elements of an old array must be copied
to new doubled array

For Space Complexity, size is decremented 2 times when elements are **size/2 after popping process**

### Performance
```
Space Complexity - O(n) for n pushes
```

```
Time Complexity
Push - O(1) Amortized Analysis
Pop - O(1) Amortized Analysis
Peek - O(1)
```
