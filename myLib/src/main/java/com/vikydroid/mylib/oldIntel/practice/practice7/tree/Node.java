package com.vikydroid.mylib.oldIntel.practice.practice7.tree;

public class Node<T> {
    T data;
    Node<T> left, right;

    Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
