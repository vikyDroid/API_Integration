package com.vikydroid.mylib.oldIntel.practice.practice5.ll;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + "-->" + next;
    }
}
