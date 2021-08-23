package com.vikydroid.mylib.oldIntel.practice.practice5.numbers;

public class SquareRoot {
    public static void main(String[] args) {
        int x = 5;

        squareRoot(x);
    }

    private static void squareRoot(int x) {
        for (int i = 1; i <= x / 2 +1; i++) {
            int prod = i * i;
            if (prod == x) {
                System.out.println(i);
                return;
            } else if (prod > x) {
                System.out.println(i - 1);
                return;
            }
        }
        System.out.println(0);
    }
}
