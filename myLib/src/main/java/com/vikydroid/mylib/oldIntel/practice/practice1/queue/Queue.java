package com.vikydroid.mylib.oldIntel.practice.practice1.queue;

import com.vikydroid.mylib.oldIntel.practice.practice1.node.Node;

public class Queue {
    Node front, rear;

    Queue() {
        front = rear = null;
    }

    void enqueue(int key) {
        Node newNode = new Node(key);
        if (rear == null) {
            front = rear = newNode;
        } else {
//            newNode.next = rear.next;
//            rear = newNode;
            rear.next = newNode;
            rear = newNode;
        }
    }

    int dequeue() {
        int popped = Integer.MIN_VALUE;

        if (!isEmpty()) {
            popped = front.data;
            front = front.next;
        }
        return popped;
    }

    boolean isEmpty() {
        if (front == null) {
            System.out.println("Q is empty");
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printAll();

        System.out.println("\n" + queue.dequeue() + ": Pooped");
        System.out.println();
        queue.printAll();

        System.out.println("\n" + queue.dequeue() + ": Pooped");
        System.out.println();
        queue.printAll();
    }

    private void printAll() {
        if (!isEmpty()) {
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }
}