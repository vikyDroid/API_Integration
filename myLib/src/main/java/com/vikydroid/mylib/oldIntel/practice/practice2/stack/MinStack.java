package com.vikydroid.mylib.oldIntel.practice.practice2.stack;

public class MinStack extends Stack {
    int min = Integer.MIN_VALUE;


    @Override
    public void push(int data) {
        if (isEmpty()) {
            min = data;
            super.push(data);
            return;
        }
        if (data < min) {
            super.push(2 * data - min);
            min = data;
        } else {
            super.push(data);
        }
        System.out.println("Inserted : " + data);
    }


    @Override
    public int pop() {
        if (isEmpty()) return -1;
        int popped = super.pop();
        System.out.print("Item in stack : " + popped + " ");
        int data;
        if (popped < min) {
            data = min;
            min = 2 * min - popped;
        } else {
            data = popped;
        }
        return data;
    }

    public static void main(String[] args) {
//        int[] arr = {16, 15, 29, 19, 18};
        int[] arr = {3, 5, 2, 1, 1, -1};
        int n = arr.length;
        MinStack minStack = new MinStack();
        for (int i = 0; i < n; i++) {
            minStack.push(arr[i]);
        }

        System.out.println("Minimum at start ===>" + minStack.min);
        while (!minStack.isEmpty()) {
            print(minStack);
        }

    }

    private static void print(MinStack minStack) {
        System.out.println();
        minStack.printAll();
        System.out.println();
        System.out.println(" " + minStack.pop() + " " + minStack.min);
    }

}
