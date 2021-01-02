package com.ferhad;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ferhad Mehdizade
 *
 * Binary Tree Functions
 * @param <E>
 */
public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    /**
     * Creates root of the Binary Tree with specified value
     * @param rootData value of the root
     */
    public BinaryTree(E rootData) {
        root = new Node<>(rootData);
    }

    /**
     * Creates Binary Tree with existed specified root
     * @param root root of the Binary Tree
     */
    public BinaryTree(Node<E> root) {
        this.root = root;
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
            inOrderTraverse(root.getLeft(), elements);
            elements.add(root.getData());
            inOrderTraverse(root.getRight(), elements);
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
                current = current.getLeft();
            } else {
                current = stack.pop();
                elements.add(current.getData());
                current = current.getRight();
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
            elements.add(root.getData());
            preOrderTraverse(root.getLeft(), elements);
            preOrderTraverse(root.getRight(), elements);
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
            elements.add(current.getData());
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
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
                elements.add(current.getData());
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                }
                current = current.getLeft();
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
            postOrderTraverse(root.getLeft(), elements);
            postOrderTraverse(root.getRight(), elements);
            elements.add(root.getData());
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
            out.push(current.getData());
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
        }

        while (!out.isEmpty()) {
            elements.add(out.pop());
        }
        return elements;
    }

}
