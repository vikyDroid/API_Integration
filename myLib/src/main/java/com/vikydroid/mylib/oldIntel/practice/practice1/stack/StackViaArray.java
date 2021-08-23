package com.vikydroid.mylib.oldIntel.practice.practice1.stack;

public class StackViaArray {
    int MAX_CAP = 100;
    int START = -1;
    int[] A = new int[MAX_CAP];
    int head = START;

    void push(int key) {
        A[++head] = key;

    }

    int pop() {
        int popped = Integer.MIN_VALUE;
        if (head >= 0) {
            popped = A[head--];
        }
        return popped;
    }

    int peek() {
        return A[head];
    }

    boolean isEmpty() {
        if (head < 0) {
            System.out.println("Stack is empty");
            return true;
        } else return false;
    }

    void printAll() {
        for (int i = head; i >= 0; i--) {
            System.out.print(A[i] + " ");
        }
    }

    public static void main(String[] args) {
        StackViaArray stack = new StackViaArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.printAll();
        stack.pop();

        stack.push(5);

        System.out.println("");
        stack.printAll();

        stack.pop();
        stack.pop();
        System.out.println();
        stack.printAll();

        System.out.println("\n" + stack.peek());
        System.out.println(stack.isEmpty());
    }
}
