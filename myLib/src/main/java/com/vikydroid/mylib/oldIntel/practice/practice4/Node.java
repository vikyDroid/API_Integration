package com.vikydroid.mylib.oldIntel.practice.practice4;

class Tree {
    Node root;

    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int data) {
            this.data = data;
        }
    }
}