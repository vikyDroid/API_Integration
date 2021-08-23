package com.vikydroid.mylib.oldIntel.practice.practice2.stack;

public class MaxStack extends Stack {
    public int max;

    @Override
    public void push(int data) {
        int val = data;
//        if (val)


        super.push(val);

    }

    @Override
    public int pop() {
        return super.pop();

    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 64};
        int n = arr.length;
        MaxStack maxStack = new MaxStack();
        for (int i = 0; i < n; i++) {
            maxStack.push(arr[i]);
        }
        maxStack.printAll();
        while (!maxStack.isEmpty()) {

        }

    }
}
