package com.vikydroid.mylib.oldIntel.practice.practice7.tree;

public class BTreeOperations {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.root = new Node<>(1);
        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);
        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);
//        tree.root.right.right.left = new Node<>(10);
        tree.root.right.left.right = new Node<>(8);
//        tree.root.right.left.right.left = new Node<>(20);
        tree.root.right.right.right = new Node<>(9);


        tree.printBoundary(tree.root);
    }
}
