package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

public class KnapSack {
    public static void main(String[] args) {
        int[] val = {10, 100, 120};
        int[] wt = {10, 20, 30};
        int w = 50;
        System.out.println(knapSackR(val, wt, w, wt.length));
        System.out.println(knapSackT(val, wt, w, wt.length));
        System.out.println(knapSackT2(val, wt, w, wt.length));
    }

    private static int knapSackR(int[] val, int[] wt, int w, int n) {
        if (n == 0 || w == 0)
            return 0;
        if (wt[n - 1] > w) {
            return knapSackR(val, wt, w, n - 1);
        }
        return Math.max(val[n - 1] + knapSackR(val, wt, w - wt[n - 1], n - 1),
                knapSackR(val, wt, w, n - 1));
    }

    private static int knapSackT(int[] val, int[] wt, int w, int n) {
        int[][] dp = new int[w + 1][n + 1];
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(val[j - 1] + dp[i - wt[j - 1]][j - 1],
                            dp[i][j - 1]);
                }
            }
        }
        return dp[w][n];
    }

    private static int knapSackT2(int[] val, int[] wt, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }

            }
        }
        return dp[n][w];
    }
}
