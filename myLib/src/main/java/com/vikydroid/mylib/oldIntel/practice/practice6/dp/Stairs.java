package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

public class Stairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climb(n));
        System.out.println(climbT(n));
    }

    private static int climb(int n) {
        if (n == 0 || n == 1) return n;
//        if (n == 2) return 2;
        return climb(n - 1) + climb(n - 2);
    }

    private static int climbT(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
