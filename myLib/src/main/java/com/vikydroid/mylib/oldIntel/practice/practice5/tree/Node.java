package com.vikydroid.mylib.oldIntel.practice.practice5.tree;

public class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    Node(T data) {
        this.data = data;
        left = right = null;
    }
}
