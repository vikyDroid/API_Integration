package com.vikydroid.mylib.oldIntel.practice.practice6.tree;

public class Node<T> {
    public T data;
    public Node<T> left, right, nextRight;

    public Node(T data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
