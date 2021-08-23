package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

import java.util.Arrays;

//https://www.youtube.com/watch?v=nLmhmB6NzcM&t=924s
public class KnapSack01 {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        System.out.println(knapSack01R(val, wt, W, val.length));
        System.out.println(knapSack01(val, wt, W));
    }

    //f(n) = max(f(n-1)+v[n-1], f(n));
    static int knapSack01R(int[] v, int[] wt, int w, int n) {
        if (n <= 0) return 0;
        if (w < wt[n - 1]) return knapSack01R(v, wt, w, n - 1);
        return Math.max(v[n - 1] + knapSack01R(v, wt, w - wt[n - 1], n - 1)//value is considered
                , knapSack01R(v, wt, w, n - 1));//value not considered
    }

    private static int knapSack01(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }
}
