package com.vikydroid.mylib.oldIntel.practice.practice5.dp;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
