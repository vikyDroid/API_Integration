package com.vikydroid.mylib.oldIntel.practice.practice4.dp;

import java.util.Arrays;

public class StairsClimb {
    public static void main(String[] args) {
        int n = 6;
        int m = 2;
        System.out.println(maxWaysR(n, m));
        int[] memo = new int[n + 2];
        Arrays.fill(memo, -1);
        System.out.println(maxWaysMemo(n, m, memo));
        System.out.println(maxWaysDP(n));
        System.out.println(maxWaysDP(n, m));
    }

    private static int maxWaysR(int n, int m) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int ways = 0;
        for (int i = 1; i <= n && i <= m; i++) {
            ways += maxWaysR(n - i, m);
        }
        return ways;
    }

    private static int maxWaysMemo(int n, int m, int[] memo) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (memo[n] != -1) return memo[n];
        int ways = 0;
        for (int i = 1; i <= n && i <= m; i++) {
            ways += maxWaysR(n - i, m);
        }
        memo[n] = ways;
        return ways;
    }

    private static int maxWaysDP(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //Generalized but need to Recheck
    private static int maxWaysDP(int n, int m) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m && j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}
