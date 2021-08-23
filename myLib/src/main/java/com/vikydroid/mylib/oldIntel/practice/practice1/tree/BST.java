package com.vikydroid.mylib.oldIntel.practice.practice1.tree;

public class BST {
    Node root;

    public Node insert(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else if (data <= root.data) {
            insert(root.left, data);
        } else {
            insert(root.right, data);
        }
        return root;
    }

    public void printAll(Node root) {
        if (root != null) {
            System.out.println(root.data);
            printAll(root.left);
            printAll(root.right);
        }
    }

    public static void main(String[] args) {

        BST bst = new BST();
        bst.root = bst.insert(bst.root, 10);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 50);
        bst.printAll(bst.root);
    }
}
