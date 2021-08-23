package com.vikydroid.mylib.oldIntel.practice.practice1.node;

public class NodeDll {
    public int data;
    public NodeDll prev;
    public NodeDll next;

    NodeDll(int data) {
        this.data = data;
        prev = next = null;
    }
}
