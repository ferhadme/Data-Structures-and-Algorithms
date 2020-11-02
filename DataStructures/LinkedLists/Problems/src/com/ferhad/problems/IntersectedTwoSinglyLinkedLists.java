package com.ferhad.problems;

import com.ferhad.Node;

import java.util.Hashtable;
import java.util.Stack;

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
     * Time complexity - O(n + m), where n for creating HashTable, and m for scanning the second list
     * Space complexity - O(n) for creating HashTable
     */
    public Node findIntersectedNodeHT(Node head1, Node head2) {
        Hashtable<Node, Integer> nodeAddresses = new Hashtable<>();
        int i = 0; // just for counter
        while (head1 != null) {
            nodeAddresses.put(head1, i);
            i++;
            head1 = head1.getNext();
        }

        while (head2 != null) {
            if (nodeAddresses.containsKey(head2)) {
                i = nodeAddresses.get(head2); // intersection is happen in i(th) Node
                return head2;
            }
            head2 = head2.getNext();
        }
        // there is no intersected Node
        return null;
    }

    /**
     * Finds intersected Node using Stacks(S indicates Stack)
     * @param head1 head of the first Singly LinkedList
     * @param head2 head of the second Singly LinkedList
     * @return intersected Node
     * Time complexity - O(m + n) for scanning 2 times
     * Space complexity - O(m + n) for creating 2 Stacks
     */
    public Node findIntersectedNodeS(Node head1, Node head2) {
        Stack<Node> nodeAddresses1 = new Stack<>();
        Stack<Node> nodeAddresses2 = new Stack<>();
        int counter = 0;
        while (head1 != null && head2 != null) {
            nodeAddresses1.push(head1);
            nodeAddresses2.push(head2);
            head1 = head1.getNext();
            head2 = head2.getNext();
            counter++;
        }

        for (int i = 0; i < counter; i++) {
            if (nodeAddresses1.peek().equals(nodeAddresses2.peek()))
                return nodeAddresses1.peek();
            nodeAddresses1.pop();
            nodeAddresses2.pop();
        }
        // there is no intersected Node
        return null;
    }

    /**
     * Finds intersected Node efficiently without any built-in Data Structure
     * @param head1 head of the first Singly LinkedList
     * @param head2 head of the second Singly LinkedList
     * @return intersected Node
     */
    public Node findIntersectedNodeE(Node head1, Node head2) {
        int length1 = 0;
        int length2 = 0;
        // p is just for naming
        Node head1P = head1;
        Node head2P = head2;

        while (head1P != null) {
            length1++;
            head1P = head1P.getNext();
        }
        while (head2P != null) {
            length2++;
            head2P = head2P.getNext();
        }

        int diff;
        if (length1 < length2) {
            head1P = head2;
            head2P = head1;
            diff = length2 - length1;
        } else {
            head1P = head1;
            head2P = head2;
            diff = length1 - length2;
        }

        for (int i = 0; i < diff; i++)
            head1P = head1P.getNext();

        while (head1P != null && head2P != null) {
            if (head1P.equals(head2P))
                return head1P;
            head1P = head1P.getNext();
            head2P = head2P.getNext();
        }
        // there is no intersected Node
        return null;
    }

}
