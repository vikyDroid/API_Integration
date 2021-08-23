package com.vikydroid.mylib.oldIntel.practice.practice2.stack;

import com.vikydroid.mylib.oldIntel.practice.practice2.ll.Node;

public class QueueUsingStackR {
    Stack stack;

    QueueUsingStackR() {
        stack = new Stack();
    }

    //Using Recursion with no extra space
    public int queueUsingStackR(Node node) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        if (node.next == null) {
            return stack.pop();
        }
        int popped = stack.pop();
        int val = queueUsingStackR(node.next);
        stack.push(popped);
        return val;
    }

    public static void main(String[] args) {
        QueueUsingStackR queue = new QueueUsingStackR();
        Stack stack = queue.stack;
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.printAll();
//        System.out.println("\npopped val : " + stack.pop());
        System.out.println("\npopped val : " + queue.queueUsingStackR(stack.head));
        System.out.println("\npopped val : " + queue.queueUsingStackR(stack.head));
        System.out.println("\npopped val : " + queue.queueUsingStackR(stack.head));
        System.out.println("\npopped val : " + queue.queueUsingStackR(stack.head));
        System.out.println("\npopped val : " + queue.queueUsingStackR(stack.head));
        System.out.println("\npopped val : " + queue.queueUsingStackR(stack.head));

    }
}
