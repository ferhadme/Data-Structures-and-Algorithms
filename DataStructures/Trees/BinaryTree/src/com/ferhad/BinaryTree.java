package com.ferhad;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ferhad Mehdizade
 *
 * Implementation of Binary Search Tree Data Structure
 * @param <E> Type of an element
 */
public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    /**
     * Creates root of the BST with specified value
     * @param rootData value of the root
     */
    public BinaryTree(E rootData) {
        root = new Node<>(rootData);
    }

    /**
     * Creates BST with existed specified root
     * @param root root of the BST
     */
    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Inserts new data into the BST
     * @param data inserted data
     */
    public void insert(E data) {
        if (contains(data))
            throw new IllegalArgumentException("Duplicate is not allowed");
        if (root == null) {
            root = new Node<>(data);
        } else {
            Node<E> current = root;
            Node<E> parent = current;
            while (current != null) {
                parent = current;
                if (data.compareTo(current.data) < 0)
                    current = current.left;
                else
                    current = current.right;
            }
            if (data.compareTo(parent.data) < 0)
                parent.left = new Node<>(data);
            else
                parent.right = new Node<>(data);
        }
    }

    /**
     * Inserts new data into the BST by using recursive method
     * @param data inserted data
     */
    public void insertR(E data) {
        if (contains(data))
            throw new IllegalArgumentException("Duplicate is not allowed");
        else
            root = insertR(data, root);
    }

    /**
     * Recursive method for inserting new data into the BST
     * @param data inserted data
     * @param node next node(left/right) of the previous node for each recursive call
     * @return next node(left/right) of the previous node
     */
    private Node<E> insertR(E data, Node<E> node) {
        if (node == null)
            return new Node<>(data);
        if (data.compareTo(node.data) < 0)
            node.left = insertR(data, node.left);
        else
            node.right = insertR(data, node.right);
        return node;
    }

    /**
     * Checks BST contains specified data or not
     * @param data searched data
     * @return true if BST contains searched data
     */
    public boolean contains(E data) {
        if (root == null)
            return false;
        Node<E> current = root;
        while (current != null) {
            if (data.compareTo(current.data) < 0)
                current = current.left;
            else if (data.compareTo(current.data) > 0)
                current = current.right;
            else
                return true;
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Traverse Methods
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Inorder traverse
     * @return list of the elements in the inorder traverse
     */
    public List<E> inOrderTraverse() {
        List<E> elements = new ArrayList<>();
        inOrderTraverse(root, elements);
        return elements;
    }

    /**
     * Recursive method for inorder traverse
     * @param root root of the Tree
     * @param elements list of the elements in the inorder traverse
     */
    private void inOrderTraverse(Node<E> root, List<E> elements) {
        if (root != null) {
            inOrderTraverse(root.left, elements);
            elements.add(root.data);
            inOrderTraverse(root.right, elements);
        }
    }

    /**
     * Iterative solution for inorder traverse
     * @return list of the elements in the inorder traverse
     */
    public List<E> inOrderTraverseI() {
        List<E> elements = new ArrayList<>();
        Stack<Node<E>> stack = new Stack<>();
        Node<E> current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                elements.add(current.data);
                current = current.right;
            }
        }
        return elements;
    }

    /**
     * Preorder traverse
     * @return list of the elements in the preorder traverse
     */
    public List<E> preOrderTraverse() {
        List<E> elements = new ArrayList<>();
        preOrderTraverse(root, elements);
        return elements;
    }

    /**
     * Recursive method for preorder traverse
     * @param root root of the Tree
     * @param elements list of the elements in the preorder traverse
     */
    private void preOrderTraverse(Node<E> root, List<E> elements) {
        if (root != null) {
            elements.add(root.data);
            preOrderTraverse(root.left, elements);
            preOrderTraverse(root.right, elements);
        }
    }

    /**
     * Iterative solution for preorder traverse
     * @return list of the elements in the preorder traverse
     */
    public List<E> preOrderTraverseI() {
        List<E> elements = new ArrayList<>();
        if (root == null)
            return elements;
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> current = stack.pop();
            elements.add(current.data);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return elements;
    }

    /**
     * Second iterative solution for preorder traverse
     * @return list of the elements in the preorder traverse
     */
    public List<E> preOrderTraverseI2() {
        List<E> elements = new ArrayList<>();
        if (root == null)
            return elements;
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);
        Node<E> current = root;
        while (!stack.isEmpty()) {
            if (current != null) {
                elements.add(current.data);
                if (current.right != null) {
                    stack.push(current.right);
                }
                current = current.left;
            } else {
                current = stack.pop();
            }
        }
        return elements;
    }

    /**
     * Postorder traverse
     * @return list of the elements in the postorder traverse
     */
    public List<E> postOrderTraverse() {
        List<E> elements = new ArrayList<>();
        postOrderTraverse(root, elements);
        return elements;
    }

    /**
     * Recursive method for postorder traverse
     * @param root root of the Tree
     * @param elements list of the elements in the postorder traverse
     */
    private void postOrderTraverse(Node<E> root, List<E> elements) {
        if (root != null) {
            postOrderTraverse(root.left, elements);
            postOrderTraverse(root.right, elements);
            elements.add(root.data);
        }
    }

    /**
     * Iterative solution for postorder traverse
     * @return list of the elements in the postorder traverse
     */
    public List<E> postOrderTraverseI() {
        List<E> elements = new ArrayList<>();
        if (root == null)
            return elements;
        Stack<Node<E>> stack = new Stack<>();
        Stack<E> out = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> current = stack.pop();
            out.push(current.data);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        while (!out.isEmpty()) {
            elements.add(out.pop());
        }
        return elements;
    }

    /**
     * Class for Nodes of Binary Tree
     * @param <E> Type of an element
     */
    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
        }
    }
}

// TODO: 1/4/2021 Implement remove() function
// TODO: 1/4/2021 Implement balancing system after each inserting