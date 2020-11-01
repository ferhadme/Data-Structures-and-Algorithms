package com.ferhad;

import java.util.Hashtable;

/**
 * We can find Node from the end easily in the specified position if we know length of this LinkedList
 * This class represents different methods with different approaches for finding specific Node from end if
 * length is unknown
 */
public class NthNodeFromEnd {

    /**
     * This solution needs two scans: one for finding the length of the list and the other for
     * finding (M – n + 1)th node from the beginning.
     * @param head head of the LinkedList
     * @param position position from the end
     * @return Node in the specified position
     * Time complexity = O(2n) for 2 scans => O(n)
     * Space complexity = O(1)
     */
    public Node findNthNodeBruteForce(Node head, int position) {
        Node temp = head;
        int length = 0;

        if (temp != null) {
            length++;
            while (temp.getNext() != null) {
                length++;
                temp = temp.getNext();
            }
        } else {
            return null;
        }

        int positionFromBeginning = length - position - 1; // 1 for length
        if (positionFromBeginning < 0) // check index
            throw new IndexOutOfBoundsException();
        temp = head;

        for (int i = 0; i < positionFromBeginning; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * Above solution needs 2 scans, it can be solved only 1 scan with using HashTable
     * Traverse the complete list(for creating HashTable, with position and Node in this position), count the length
     * Since we already know the length of the list, it is just a matter of returning (M - n+ 1)th key value from the hash table.
     * @param head head of the LinkedList
     * @param position position from the end
     * @return Node in the specified position
     */
    public Node findNthNodeHashTable(Node head, int position) {
        Hashtable<Integer, Node> positions = new Hashtable<>();
        int length = 0;
        Node temp = head;
        if (temp != null) {
            length++;
            while (temp.getNext() != null) {
                positions.put(length - 1, temp); // length - 1 is position of each Node
                length++;
                temp = temp.getNext();
            }
        } else {
            return null;
        }

        int positionFromBeginning = length - position - 1;
        if (positionFromBeginning < 0) // check index
            throw new IndexOutOfBoundsException();

        return positions.get(positionFromBeginning);
    }

}
