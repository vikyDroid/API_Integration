package com.vikydroid.mylib.oldIntel.practice.practice5.stack;

public class Stack<T> {
    Node<T> head;

    void add(Node<T> node) {
        if (head == null) {
            head = node;
            return;
        }
        Node<T> temp = head;
        head = node;
        head.next = temp;
    }

    void push(Node<T> node) {
        add(node);
    }

    Node<T> top() {
        return head;
    }

    Node<T> pop() {
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
