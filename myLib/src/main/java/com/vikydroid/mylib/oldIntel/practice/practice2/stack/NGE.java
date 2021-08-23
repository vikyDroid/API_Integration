package com.vikydroid.mylib.oldIntel.practice.practice2.stack;

public class NGE {
    public void nextGreater(int[] arr) {
        int n = arr.length;
        if (n == 0) return;
        Stack stack = new Stack();
        stack.push(arr[0]);
        for (int i = 1; i < n; i++) {
            int next = arr[i];
            while (!stack.isEmpty() && next > stack.top()) {
                System.out.println(stack.pop() + "  -- " + next);
            }
            stack.push(next);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + "  -- " + -1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        new NGE().nextGreater(arr);
    }
}
