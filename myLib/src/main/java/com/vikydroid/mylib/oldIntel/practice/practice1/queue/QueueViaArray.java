package com.vikydroid.mylib.oldIntel.practice.practice1.queue;

public class QueueViaArray {
    int MAX_CAP = 10;
    int[] A = new int[MAX_CAP];
    int front, rear, size;

    QueueViaArray() {
        front = size = 0;
        rear = MAX_CAP - 1;
    }

    void enqueue(int key) {
        if (!isFull()) {
            rear = (rear + 1) % MAX_CAP;
            A[rear] = key;
            size++;
        }
    }

    int dequeue() {
        int popped = Integer.MIN_VALUE;
        if (!isEmpty()) {
            popped = A[front];
            front = (front + 1) % MAX_CAP;
            size--;
        }
        return popped;
    }

    boolean isFull() {
        if (size == MAX_CAP) {
            System.out.println("Queue is full");
            return true;
        } else {
            return false;
        }
    }

    boolean isEmpty() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return true;
        } else {
            return false;
        }
    }

    void printAll() {
        int temp = front;
        while (temp <= rear) {
            System.out.print(A[temp] + " ");
            temp = (temp + 1) % MAX_CAP;
        }
    }

    public static void main(String[] args) {
        QueueViaArray queue = new QueueViaArray();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printAll();

        System.out.println("\n"+queue.dequeue()+": Pooped");
        System.out.println();
        queue.printAll();

        System.out.println("\n"+queue.dequeue()+": Pooped");
        System.out.println();
        queue.printAll();
    }
}
