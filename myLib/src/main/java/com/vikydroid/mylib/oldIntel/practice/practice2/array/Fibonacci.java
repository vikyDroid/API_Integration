package com.vikydroid.mylib.oldIntel.practice.practice2.array;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.println(new Fibonacci().fibonacci(i));
        }
    }

    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
