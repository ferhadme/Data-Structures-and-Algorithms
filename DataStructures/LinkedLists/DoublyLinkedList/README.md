# Doubly LinkedList
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Doubly-linked-list.svg/610px-Doubly-linked-list.svg.png" />
<br/>
<br/>

### How to use memory efficiently with Doubly LinkedList?

**As I pointed** in [Class of implementation of Doubly LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/DoublyLinkedList/src/com/ferhad/DoublyLinkedList.java "DoublyLinkedList.java class") although [Doubly LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/DoublyLinkedList/src/com/ferhad/DoublyLinkedList.java "Doubly LinkedList class") is very efficient in searching spesific node because of its previous and next pointer, **it is not very good at memory**. Because [ListNode](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/DoublyLinkedList/src/com/ferhad/ListNode.java "ListNode.java class") holds both previous and next pointer.

So how we can apply different approach?

Let's look at my technique in [ListNode class](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/DoublyLinkedList/src/com/ferhad/ListNode.java "ListNode.java class")

```java
public class ListNode {
  private int data;
  private ListNode previous;
  private ListNode next;
  // ...
}
```

Then let's look at another implementation which I learned from one of my favourite books on Data Structures & Algorithms ([Data Structures & Algorithms made easy in Java](https://www.amazon.com/Data-Structures-Algorithms-Made-Easy/dp/1468101277 "Data Structures & Algorithms made easy in Java on Amazon")).

```java
public class ListNode {
  private int data;
  private ListNode ptrdiff;
}
```

In this piece of code **ptrdiff** node points to both previous and next node. **ptrdiff** is *pointer difference*. The pointer difference is calculated by this formula:

<div align="center">
  ptrdiff = pointer to previous node ⊕ pointer to next node
</div>

**NOTE: ⊕ is XOR (in java syntax is ^). ([XOR logical operation](https://en.wikipedia.org/wiki/Exclusive_or "XOR in Wikipedia"))**

For example if we have list like NULL<-A<->B<->C<->D<->E<->F->NULL 

node A is **⊕ of NULL and B**,

node C is **⊕ of B and D**,

node F is **⊕ of E and NULL** etc.

Main point in here is that: How we can get previous and next node from only ⊕?

Let's assume that we at node C and want to move node B. We know that
C’s ptrdiff is defined as B ⊕ D. If we want to move to B, performing ⊕ on C’s ptrdiff with D
would give B.

<div align="center">
  (B ⊕ D) ⊕ D = B (since D ⊕ D = 0 and B ⊕ 0 = B)
</div>

Similarly, if we want to move to node D,

<div align="center">
  (B ⊕ D) ⊕ B = D (since B ⊕ B = 0 and D ⊕ 0 = D)
</div>

A memory-efficient implementation of a doubly linked list is possible with minimal
compromising of timing efficiency. But if we consider everything, the best approach is [this implementation of Doubly LinkedList](https://github.com/ferhad2207/Data-Structures-and-Algorithms/blob/master/DataStructures/LinkedLists/DoublyLinkedList/src/com/ferhad/DoublyLinkedList.java "DoublyLinkedList.java class")
