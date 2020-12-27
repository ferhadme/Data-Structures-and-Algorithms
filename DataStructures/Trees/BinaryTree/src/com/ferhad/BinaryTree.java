package com.ferhad;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {
    private Node<E> root;

    public BinaryTree(E rootData) {
        root = new Node<>(rootData);
    }

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public List<E> inOrderTraverse() {
        List<E> elements = new ArrayList<>();
        inOrderTraverse(root, elements);
        return elements;
    }

    private void inOrderTraverse(Node<E> root, List<E> elements) {
        if (root != null) {
            inOrderTraverse(root.getLeft(), elements);
            elements.add(root.getData());
            inOrderTraverse(root.getRight(), elements);
        }
    }

    public List<E> preOrderTraverse() {
        List<E> elements = new ArrayList<>();
        preOrderTraverse(root, elements);
        return elements;
    }

    private void preOrderTraverse(Node<E> root, List<E> elements) {
        if (root != null) {
            elements.add(root.getData());
            preOrderTraverse(root.getLeft(), elements);
            preOrderTraverse(root.getRight(), elements);
        }
    }

    public List<E> postOrderTraverse() {
        List<E> elements = new ArrayList<>();
        postOrderTraverse(root, elements);
        return elements;
    }

    private void postOrderTraverse(Node<E> root, List<E> elements) {
        if (root != null) {
            postOrderTraverse(root.getLeft(), elements);
            postOrderTraverse(root.getRight(), elements);
            elements.add(root.getData());
        }
    }
}
