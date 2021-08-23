package com.vikydroid.mylib.oldIntel.practice.practice5.stack;

public class QueueUsingStack<T> {
    public static void main(String[] args) {
        int[] arr = {13, 5, 6, 7, 8};

        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (s1.isEmpty()) {
                s1.push(new Node<>(arr[i]));
            } else {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(new Node<>(arr[i]));
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }
        while (!s1.isEmpty()) {
            System.out.println(s1.pop());
        }

        Stack<Integer> s3 = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            s3.push(new Node<>(arr[i]));
        }

    }
}

