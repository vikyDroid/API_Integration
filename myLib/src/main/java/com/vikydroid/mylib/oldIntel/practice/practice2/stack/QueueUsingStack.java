package com.vikydroid.mylib.oldIntel.practice.practice2.stack;

public class QueueUsingStack {
    Stack stack, temp;

    QueueUsingStack() {
        stack = new Stack();
        temp = new Stack();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.stack.printAll();
        System.out.print("\nItem deque : " + queue.dequeue());
        System.out.print("\nItem deque : " + queue.dequeue());
        System.out.print("\nItem deque : " + queue.dequeue());
        System.out.print("\nItem deque : " + queue.dequeue());

    }

    private void enqueue(int data) {
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(data);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    private int dequeue() {
        return stack.pop();
    }

}
