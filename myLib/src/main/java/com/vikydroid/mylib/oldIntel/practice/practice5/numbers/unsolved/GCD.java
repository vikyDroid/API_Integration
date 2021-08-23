package com.vikydroid.mylib.oldIntel.practice.practice5.numbers.unsolved;

public class GCD {
    public static void main(String[] args) {
        int x = 36;
        int y = 60;
        System.out.println(gcd(x, y));
    }

    private static int gcd(int x, int y) {
        if (x == 0)
            return y;
        if (y == 0) return x;
        if (x == y) return x;
        if (x>y)return gcd(x-y, y);
        else return gcd(x, y-x);
    }
}
