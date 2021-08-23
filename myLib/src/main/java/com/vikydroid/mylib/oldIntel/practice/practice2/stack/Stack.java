package com.vikydroid.mylib.oldIntel.practice.practice2.stack;


import com.vikydroid.mylib.oldIntel.practice.practice2.ll.Node;

public class Stack {
    Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            return -1;
        }
        Node temp = head;
        head = head.next;
        return temp.data;
    }

    public int top() {
        if (head == null) return -1;
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Stack is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.printAll();
        System.out.println();
        System.out.println("Pooped : " + stack.pop());
        System.out.println("Pooped : " + stack.pop());
        stack.printAll();
    }
}
