package com.ferhad;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Building Tree
        var node1 = new Node<>(1);
        var node2 = new Node<>(2);
        var node3 = new Node<>(3);
        node1.setLeft(node2);
        node1.setRight(node3);
        var node4 = new Node<>(4);
        var node5 = new Node<>(5);
        node2.setLeft(node4);
        node2.setRight(node5);
        var node6 = new Node<>(6);
        var node7 = new Node<>(7);
        node3.setLeft(node6);
        node3.setRight(node7);

        var binaryTree = new BinaryTree<>(node1);
        List<Integer> inOrder = binaryTree.inOrderTraverse();
        System.out.println(inOrder);

        List<Integer> preOrder = binaryTree.preOrderTraverse();
        System.out.println(preOrder);

        List<Integer> postOrder = binaryTree.postOrderTraverse();
        System.out.println(postOrder);

    }

}

/*
Tree Representation
        1
      /   \
    2       3
   / \     / \
  4   5   6   7

Inorder Traversal --> 4, 2, 5, 1, 6, 3, 7
Preorder Traversal --> 1, 2, 4, 5, 3, 6, 7
Postorder Traversal --> 4, 5, 2, 6, 7, 3, 1
 */