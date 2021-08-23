package com.vikydroid.mylib.oldIntel.practice.practice7.numbers;

public class HCF {
    public static void main(String[] args) {
        int x = 98, y = 56;
        System.out.println(hcf(x, y));
    }

    private static int hcf(int x, int y) {
        if (x == 0) return y;
        if (y == 0) return x;
        if (x > y) return hcf(x - y, y);
        else return hcf(x, y - x);
    }
}
