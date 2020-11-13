# Stack implementation by using LinkedList
In [Implementation with static array](https://github.com/ferhad2207/Data-Structures-and-Algorithms/tree/master/DataStructures/Stacks/FixedSizeStack "Stack implementation by using static array"), Main problem is non-flexible size. So size of the Stack must be defined when it is created. And exception will occur(of course) if new element is pushed into **full Stack**

### LinkedList approach
**The other way of implementing Stacks is by using LinkedLists.**

Push operation is implemented by inserting an element at the beginning of the list (**beginning, because of using Singly LinkedList for memory efficiency and time complexity in accessing beginning of the list. That's why Push gives O(1) in this way**).

Pop operation is implemented by deleting an element from the beginning of the list (**for the same reason**)

### Performance
```
Space Complexity - O(n) for push operations
```

```
Push - O(1)
Pop - O(1)
Peek - O(1)
```
