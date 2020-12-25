# Queue implementation by using Circular Array
The most basic implementation of Queue Data Structure

### Circular Array Logic
Queue shouldn't be implemented with static array as [Stack](https://github.com/ferhad2207/Data-Structures-and-Algorithms/tree/master/DataStructures/Stacks/FixedSizeStack "Stack implementation using static array").

***Static Array Approach***

If we think static array as queue, enqueue processes will be okay. When new element is inserted to the Queue, it simply adds it to end of the array. *But, dequeue processes won't be
efficient*, because of wasted slots. That means, initial slots of an array will be empty, after dequeue processes. That's why implementing Queue with static array is inefficient approach.

<p align="center"> 
  <img src="https://www.tutorialandexample.com/wp-content/uploads/2020/05/Queue-in-DS-1.jpg" width="500" height="325" />
</p>

<br />

***Circular Array Approacy***

The most efficient approach to implementing Queue Data Structure is using data structures that can be treated as circular. Array also can be implemented as circular. 
That means, we treat the last element and the first array elements as contiguous. With this representation, if there are any free slots at the beginning, the rear pointer can easily 
go to its next free slot.

<p align="center">
  <img src="https://scanftree.com/Data_Structure/circularqueues.png" width="500" height="325" />
</p>

### Performance

```
Space Complexity - O(n) for n sized Array
```

```
Time Complexity
enQueue() - O(1)
deQueue() - O(1)
getFront() - O(1)
getRear() - O(1)
isEmpty() - O(1)
isFull() - O(1)
size() - O(1)
contains() - O(n)
```

### Limitations
The maximum size of the Queue should be defined before creating and can't be changed. Trying to *EnQueue* a new element into full Queue causes exception.

For Queue implementation with flexible size ***refer to:***

***[Implementation of Queue with LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/tree/master/DataStructures/Queues/LinkedQueue 'Go to the LinkedQueue')***

