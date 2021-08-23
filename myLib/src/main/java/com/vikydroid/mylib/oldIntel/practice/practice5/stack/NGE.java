package com.vikydroid.mylib.oldIntel.practice.practice5.stack;

public class NGE {
    public static void main(String[] args) {
        int[] arr = {13, 7, 6, 12};
        nextGreaterElement(arr);
    }

    private static void nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node<>(arr[i]));
            } else if (stack.top().data > arr[i]) {
                stack.push(new Node<>(arr[i]));
            } else {
                while (!stack.isEmpty() && stack.top().data < arr[i]) {
                    System.out.println(stack.pop().data + " --> " + arr[i]);
                }
                stack.push(new Node<>(arr[i]));
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().data + " --> -1");
        }

    }
}
