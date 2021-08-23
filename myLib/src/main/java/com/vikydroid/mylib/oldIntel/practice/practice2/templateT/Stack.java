package com.vikydroid.mylib.oldIntel.practice.practice2.templateT;

public class Stack<T> {
    Node<T> head;

    public void push(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }

    public void add(T data) {
        push(data);
    }

    public void delete() {
        pop();
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        Node<T> temp = head;
        head = head.next;
        return temp.data;
    }

    public T top() {
        if (head == null) return null;
        return head.data;
    }

    public T peek() {
        return top();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Stack is empty");
            return;
        }
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
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
