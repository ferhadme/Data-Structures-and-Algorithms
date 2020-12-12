# SkipList
<img src="https://www.osa.fu-berlin.de/bioinformatics_msc/en/_media/bild_beispielaufgabe_i1/Skip_list.png" />

**The skip list is a probabilistic data structure that is built upon the general idea of a linked list. The skip list uses probability to build subsequent layers of linked lists upon an original linked list. Each additional layer of links contains fewer elements, but no new elements.**

### Why use SkipList?
**Insertion** and **Deletion** are very fast, O(1) in the [LinkedLists](https://github.com/ferhad2207/Data-Structures-and-Algorithms/tree/master/DataStructures/LinkedLists "LinkedLists"). But, searching specific node for **insertion** or **deletion** process takes O(n) in the worst case. So, we need fast searching technique like **Binary Search in sorted Array**, or **Binary Tree** which takes O(logn) for finding specific element. How it can be done in the LinkedList?

### Solution is SkipList
The idea is simple. We create multiple layers, which is called **level**, so we can skip multiple nodes for accessing specific nodes. For example;

As shown image above, If 9(key) is the searched node, searching from 1(key) to 9(key) is not needed. Searching starts from top level, go through until if **key of the next node** of the current node isn't greater than **key of the current node**. If greater then go down. Process is repeated until specific node is found.

Searching specific node takes O(logn) in the SkipList.  

### How level is created in insertion?
Level is created probabilistically. I use 1/2 probability (Like Head and Tail in tossing coin. **See** [level() method of the SkipList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/SkipList/src/com/ferhad/SkipList.java "Implementation of the SkipList") ). 

### Insertion
We will start from highest level in the list and compare key of next node of the current node with the key to be inserted. Basic idea is If
 - Key of next node is less than key to be inserted then we keep on moving forward on the same level
 - Key of next node is greater than the key to be inserted then we do insertion in this position, and make the same process for each level of the element.

### Deletion
Deletion of an element key is preceded by locating element in the Skip list using above mentioned search algorithm. Once the element is located, rearrangement of pointers is done to remove element form list just like we do in singly linked list. We start from lowest level and do rearrangement until next of an element is not key.

### Performance

```             
  Searching - O(logn)   O(n)
  Insertion - O(logn)   O(n)
  Deletion  - O(logn)   O(n)
  
The same time complexity because of O(1) insertion and deletion process.
```

**See** [Implementation of the SkipList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/SkipList/src/com/ferhad/SkipList.java "Implementation of the SkipList") for more detail.
