package com.vikydroid.mylib.oldIntel.practice.practice2.ll;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + ""/*+ "->" + next*/;
    }
}
