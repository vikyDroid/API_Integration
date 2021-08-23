package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

import java.util.Arrays;

public class StairsClimb {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(numWaysR(n));

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        System.out.println(numWaysMemoization(n, memo));
        System.out.println(numWaysDP(n));


        int m = 4;
        System.out.println(numWaysGeneralisedR(n, m));

        int[] arr = {1, 3, 5};
        System.out.println(numWaysGeneralisedR2(n, arr));
        System.out.println(numWaysGeneralisedDP(n, arr));
    }

    private static int numWaysR(int n) {
        if (n == 0 || n == 1) return 1;
        return numWaysR(n - 1) + numWaysR(n - 2);
    }

    private static int numWaysMemoization(int n, int[] memo) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = numWaysMemoization(n - 1, memo) + numWaysMemoization(n - 2, memo);
        memo[n] = res;
        return res;
    }

    private static int numWaysDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int numWaysGeneralisedR(int n, int m) {
        if (n == 0) return 1;
        int res = 0;
        for (int i = 1; i <= m; i++) {
            if (n - i >= 0)
                res += numWaysGeneralisedR(n - i, m);
        }
        return res;
    }

    private static int numWaysGeneralisedR2(int n, int[] m) {
        if (n == 0) return 1;
        int res = 0;
        for (int value : m) {
            if (n - value >= 0)
                res += numWaysGeneralisedR2(n - value, m);
        }
        return res;
    }

    private static int numWaysGeneralisedDP(int n, int[] m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < m.length; j++) {
                if (i - m[j] >= 0)
                    sum += dp[i - m[j]];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
