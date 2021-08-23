package com.vikydroid.mylib.oldIntel.practice.practice4;

public class NumberFunctions {
    public static void main(String[] args) {
        int x = 20;
        int y = 28;
        System.out.println(GCD(x, y));
    }

    private static int sqrt(int x) {
        for (int i = 1; i <= x / 2; i++) {
            int prod = i * i;
            if (prod == x) return i;
            if (prod > x) return i - 1;
        }
        return 0;
    }

    static int GCD(int x, int y) {
        if (y == 0) {
            return x;
        } else return GCD(y, x % y);

    }
}
