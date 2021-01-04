package com.ferhad;

public class Main {

    public static void main(String[] args) {
        // Building Tree
        BinaryTree<Integer> binaryTree = new BinaryTree<>(10);
        binaryTree.insert(6);
        binaryTree.insert(15);
        binaryTree.insert(4);
        binaryTree.insert(8);
        binaryTree.insert(12);
        binaryTree.insert(20);

        System.out.println(binaryTree.contains(8)); // true
        System.out.println(binaryTree.contains(100)); // false

        // Inorder Traversals
        System.out.println(binaryTree.inOrderTraverse());
        System.out.println("======================================");

        // Preorder Traversals
        System.out.println(binaryTree.preOrderTraverse());
        System.out.println("======================================");

        // Postorder Traversals
        System.out.println(binaryTree.postOrderTraverse());
        System.out.println("======================================");

    }

}

/*
Tree Representation
        10
      /    \
    6       15
   / \     / \
  4   8   12   20

Inorder Traversal --> 4, 6, 8, 10, 12, 15, 20
Preorder Traversal --> 10, 6, 4, 8, 15, 12, 20
Postorder Traversal --> 4, 8, 6, 12, 20, 15, 10
 */