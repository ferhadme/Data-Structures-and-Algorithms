package com.ferhad.problems;

import com.ferhad.Node;

import java.util.Hashtable;

/**
 * @author Ferhad Mehdizade
 *
 * Find intersection point of 2 Singly LinkedLists with knowing only heads of these lists.
 * Number of Nodes in each Lists before they intersect is unknown
 *
 * [] -> [] -> [] -> [] ->|
 *                        |
 *             [] -> [] ->->-> [X] -> [] -> []
 *
 * [], (->, |), [X]  represents Node, Pointers and Searched Node respectively
 */
public class IntersectedTwoSinglyLinkedLists {

    /**
     * Brute-Force approach
     * Comparing Nodes of the first List with Nodes of the second List
     * @param head1 head of the first Singly LinkedList
     * @param head2 head of the second Singly LinkedList
     * @return intersected Node
     * Time Complexity - O(mn), where m and n are sizes of the 2 LinkedLists
     * Space Complexity - O(1)
     */
    public Node findIntersectedNode(Node head1, Node head2) {
        while (head1 != null) {
            while (head2 != null) {
                if (head1.getNext() == head2.getNext()) {
                    return head1.getNext();
                }
                head2 = head2.getNext();
            }
            head1 = head1.getNext();
        }
        // there is no intersected Node
        return null;
    }

    /**
     * Finds intersected Node using HashTable(HT indicates HashTable)
     * @param head1 head of the first Singly LinkedList
     * @param head2 head of the second Singly LinkedList
     * @return intersected Node
     * Time complexity - O(n) + O(m), where n for creating HashTable, and m for scanning the second list
     * Space complexity - O(n) for creating HashTable
     */
    public Node findIntersectedNodeHT(Node head1, Node head2) {
        Hashtable<Node, Integer> nodeRecords = new Hashtable<>();
        int i = 0; // just for counter
        while (head1 != null) {
            nodeRecords.put(head1, i);
            i++;
            head1 = head1.getNext();
        }

        while (head2 != null) {
            if (nodeRecords.containsKey(head2)) {
                i = nodeRecords.get(head2); // intersection is happen in i(th) Node
                return head2;
            }
            head2 = head2.getNext();
        }
        // there is no intersected Node
        return null;
    }
}
