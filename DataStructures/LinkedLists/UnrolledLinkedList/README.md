# Unrolled LinkedList
**An unrolled linked list is a variation on the linked list which stores multiple elements in each node. It can dramatically increase cache performance, while decreasing the memory overhead associated with storing list metadata such as references. It is related to the B-tree.**

One of the biggest advantages of linked lists over arrays is that inserting an element at any
location takes only O(1) time. However, it takes O(n) to search for an element in a linked list.
There is a simple variation of the singly linked list called [Unrolled LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/UnrolledLinkedList/src/com/ferhad/UnrolledLinkedList.java "Implementation of Unrolled LinkedList").

[Unrolled LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/UnrolledLinkedList/src/com/ferhad/UnrolledLinkedList.java "Implementation of Unrolled LinkedList") stores multiple elements in each node (let us call it a block for our
convenience). In each block, [Circular LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/CircularLinkedList/src/com/ferhad/CircularLinkedList.java "Implementation of Circular LinkedList") is used to connect all nodes.

  <img src="https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/UnrolledLinkedList/UnrolledLinkedList.jpg" align="center"/>
  
As we see, if we have **n** elements in List, we should have at most **√n** elements in each block. In image shown above, we have **12** elements. How should we group these elements?

```
  n = 12,
  √n = 3,...
```

So we should create **3** blocks for **12** elements.

### Searching an element in [Unrolled LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/UnrolledLinkedList/src/com/ferhad/UnrolledLinkedList.java "Implementation of Unrolled LinkedList")
We can find *n(th)* element in **O(√n)**: Because,

1. It takes *O(√n)* ***to find particular block*** since we may find it by going through no more than *√n* blocks.
2. ***To find particular node in each block*** also takes *O(√n)* since there are no more than *√n* nodes in each block

### Shift operation in Insertion and Deletion process
Each shift operation, which includes *removing a node from the tail of the circular linkedlist in a block* and *inserting a node to the head of the circular linkedlist in the block* after 
takes only **O(1)**. The total time complexity of an insertion operation for unrolled linked lists is therefore **O(√n)**.

### Performance
[Unrolled LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/UnrolledLinkedList/src/com/ferhad/UnrolledLinkedList.java "Implementation of Unrolled LinkedList") is very efficient at both speed and memory side.

**See implementation of the** [Unrolled LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/UnrolledLinkedList/src/com/ferhad/UnrolledLinkedList.java "Implementation of Unrolled LinkedList")

**See** [UML representation of the project](https://drive.google.com/file/d/1Tkg_s7hORO8tBZhdNN2vn4CMqbKJWj44/view?usp=sharing "UML representation by Ferhad Mehdizade")
