package com.vikydroid.mylib.oldIntel.practice.practice2.tree;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
