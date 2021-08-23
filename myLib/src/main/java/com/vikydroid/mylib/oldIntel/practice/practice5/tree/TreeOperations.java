package com.vikydroid.mylib.oldIntel.practice.practice5.tree;

public class TreeOperations {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        /*tree.root = new Node<>(1);
        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);
        tree.root.left.left = new Node<>(7);
        tree.root.left.right = new Node<>(6);
        tree.root.right.left = new Node<>(5);
        tree.root.right.right = new Node<>(4);*/
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.right = new Node(6);

        tree.flattenTree(tree.root);
        tree.levelOrder(tree.root);

        /*BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.root = new Node<>(4);
        tree2.root.left = new Node<>(2);
        tree2.root.right = new Node<>(7);
        tree2.root.left.left = new Node<>(1);
        tree2.root.left.right = new Node<>(3);
//        tree2.root.right.left = new Node<>(6);
        tree2.root.right.right = new Node<>(9);

        System.out.println(tree.isIdentical(tree.root, tree2.root));*/

//        tree.preOrder(tree.root);
//        System.out.println();
//        tree.preOrder2(tree.root);


//        String in = "DBEAFC";
//        String pre = "ABDECF";
//        BinaryTree<Character> characterBinaryTree = new BinaryTree<>();
//        characterBinaryTree.levelOrder(createTree(in, pre, 0));
    }





}
