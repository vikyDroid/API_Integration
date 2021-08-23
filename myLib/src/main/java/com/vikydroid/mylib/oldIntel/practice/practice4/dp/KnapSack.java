package com.vikydroid.mylib.oldIntel.practice.practice4.dp;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(maxProfitR(val, wt, n, W));
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        System.out.println(maxProfitMemo(val, wt, n, W, memo));
        System.out.println(maxProfitDP(val, wt, W));

    }

    private static int maxProfitR(int[] val, int[] wt, int n, int W) {
        if (n <= 0 || W == 0) return 0;
        int profit = maxProfitR(val, wt, n - 1, W);
        if (wt[n - 1] > W)
            return profit;
        return Math.max(profit,
                val[n - 1] + maxProfitR(val, wt, n - 1, W - wt[n - 1]));
    }

    private static int maxProfitMemo(int[] val, int[] wt, int n, int W, int[] memo) {
        if (n <= 0 || W == 0) return 0;
        if (memo[n - 1] != -1) {
            return memo[n - 1];
        }
        int profit = maxProfitR(val, wt, n - 1, W);
        if (wt[n - 1] > W) {
            memo[n - 1] = profit;
            return profit;
        }
        int max = Math.max(profit,
                val[n - 1] + maxProfitR(val, wt, n - 1, W - wt[n - 1]));
        memo[n - 1] = max;
        return max;
    }

    private static int maxProfitDP(int[] val, int[] wt, int W) {
        int n = wt.length;
        if (n <= 0 || W == 0) return 0;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }


}
