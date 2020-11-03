package com.ferhad;

/**
 * @author Ferhad Mehdizade
 * Implementation of Singly LinkedList
 */

public class LinkedList<T> {
    private ListNode<T> head; // It holds the head of the list
    private int length; // by default 0

    /**
     * @return head of the list
     */
    public T getHead() {
        return head.getData();
    }

    /**
     * insert new data to head of the list
     * @param data inserted data
     */
    public void insertAtBegin(T data) {
        ListNode<T> node = new ListNode<>(data);
        node.setNext(head);
        head = node; // inserted node is new head of the list
        length++;
    }

    /**
     * insert new data to end of the list(after the tail)
     * @param data inserted data
     */
    public void insertAtEnd(T data) {
        ListNode<T> node = new ListNode<>(data);
        if (head == null) { // if list is empty, inserting to the head and tail is the same thing
            head = node;
        } else {
            ListNode<T> p,q;
            for (p = head;(q = p.getNext()) != null; p = q); // finding the last node of the LinkedList (p)
            p.setNext(node);
        }
        length++;
    }

    /**
     * remove the data from head of the list
     * @return removed data
     */
    public ListNode<T> removeAtBegin() {
        ListNode<T> node = head;
        if (node != null) { // if head is null, we needn't remove anything
            head = node.getNext();
            node.setNext(null);
            length--;
        }
        return node;
    }

    /**
     * remove data from end of the list(removing tail)
     * @return removed data
     */
    public ListNode<T> removeFromEnd() {
        if (head == null) { // if head is null, we needn't remove anything
            return null;
        }

        ListNode<T> p = head, q = null, next = head.getNext(); // variables for finding tail and
        // the previous element of the tail

        if (next == null) { // list consists of only head
            head = null; // we need to remove head
            length--;
            return p;
        }

        while ((next = p.getNext()) != null) { // otherwise, find the tail and previous element of the tail
            q = p;
            p = next;
        }
        assert q != null;
        q.setNext(null); // remove the tail
        length--;

        return p;
    }

    /**
     * method for removed exactly needed node which has the same reference with @param node
     * @param node removed Node
     */
    public void removeMatched(ListNode<T> node) {
        if (head == null) { // list is empty
            return;
        }
        if (node.equals(head)) { // removing the head
            head = head.getNext();
            length--;
            return;
        }

        ListNode<T> p = head, q = null;
        while ((q = p.getNext()) != null) { // find the specific node for removing
            if (node.equals(q)) { // node is found, remove it
                p.setNext(q.getNext());
                length--;
                return;
            }
            p = q;
        }
    }

    /**
     * Getting reference of needed Node for doing operation it
     * @param position position of the data
     * @return node in the @param position
     */
    private ListNode<T> findNode(int position) {
        ListNode<T> temp = head;
        for (int i = 0; i < position - 1; i++) { // iterate over the list until finding needed node
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * insert new data to specific position
     * @param position position of the data
     * @param data inserted data
     */
    public void insert(int position, T data) {
        if (position < 0 || position > length) { // check for index
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) { // insert to the head
            insertAtBegin(data);
            return;
        } else if (position == length) { // insert to the tail
            insertAtEnd(data);
            return;
        }

        // inserting
        ListNode<T> temp = findNode(position);
        ListNode<T> newNode = new ListNode<>(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);

        length++;
    }

    /**
     * remove specific data from @param position
     * @param position position of the data
     */
    public void remove(int position) {
        if (position < 0 || position >= length) { // check for index
            throw new IndexOutOfBoundsException();
        }

        if (position == 0) { // remove the head
            removeAtBegin();
        } else { // remove node in the position
            ListNode<T> temp = findNode(position);
            temp.setNext(temp.getNext().getNext());
            length--;
        }
    }

    /**
     * @return length of the list
     */
    public int length() {
        return length;
    }

    /**
     * get data in the specific position
     * @param position position of the data
     * @return data
     */
    public T get(int position) {
        if (position < 0 || position >= length) { // check for index
            throw new IndexOutOfBoundsException();
        }

        // find node and return it
        ListNode<T> temp = findNode(position).getNext();
        return temp.getData();
    }

    /**
     * get data in the position from the end of the List
     * @param position position from end
     * @return data in the specified position
     */
    public T getFromEnd(int position) {
        if (position < 0 || position >= length) { // check for index
            throw new IndexOutOfBoundsException();
        }

        return findNode(length - position).getData();
    }

    /**
     * set data to the new value in the specific position
     * @param position position of the data
     * @param data new value
     */
    public void set(int position, T data) {
        // find node and set it to the new value
        ListNode<T> temp = findNode(position).getNext();
        temp.setData(data);
    }

    /**
     * get position of the specific data
     * @param data data in the position
     * @return index of the data. Returns the first data that equal to @param data, otherwise -1
     */
    public int getPosition(T data) {
        int position = 0;
        ListNode<T> temp = head;
        while (temp != null) { // iterate over the list and find the position
            if (data.equals(temp.getData())) {
                return position;
            }
            position++;
            temp = temp.getNext();
        }
        // there is no position with this data, return -1;
        return -1;
    }

    /**
     * reverse the list
     */
    public void reverse() {
        ListNode<T> currentNode = head;
        ListNode<T> forwardNode = null;
        ListNode<T> previousNode = null;
        // traversing linked list until there is no more element
        while (currentNode.getNext() != null) {
            forwardNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = forwardNode;
        }
        head = currentNode;
        head.setNext(previousNode);
    }

    /**
     * Clones this LinkedList to new created LinkedList
     * @return reference of new clone LinkedList
     */
    public LinkedList<T> clone() {
        LinkedList<T> cloneLinkedList = new LinkedList<>();
        ListNode<T> temp = head;
        while (temp != null) {
            cloneLinkedList.insertAtEnd(temp.getData());
            temp = temp.getNext();
        }
        return cloneLinkedList;
    }

    public boolean merge(LinkedList<T> mergedList) {
        if (mergedList.head == null)
            return false;
        ListNode<T> temp = mergedList.head;
        while (temp != null) {
            this.insertAtEnd(temp.getData());
            temp = temp.getNext();
        }
        return true;
    }

    /**
     * @return string representation of this collection, in the form ["str1", "str2", ...].
     */
    @Override
    public String toString() {
        String result = "[";
        ListNode<T> temp = null;
        if (head != null) {
            result += head.getData();
            temp = head.getNext();
        }
        while (temp != null) {
            result += ", " + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    /**
     * Displays LinkedList from the end
     */
    public void printFromEnd() {
        System.out.print("[");
        printFromEnd(head);
        System.out.println("]");
    }

    /**
     * Helper method for printing LinkedList from end recursively
     * Main method is printFromEnd()
     * @param head
     */
    private void printFromEnd(ListNode<T> head) {
        if (head == null)
            return;
        printFromEnd(head.getNext());
        System.out.print(head.getData() + ", ");
    }

    /**
     * Remove all data from LinkedList
     */
    public void clearList() {
        head = null;
        length = 0;
    }

}
