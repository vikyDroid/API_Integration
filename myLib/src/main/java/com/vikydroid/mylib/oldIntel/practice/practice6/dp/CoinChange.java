package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6};
        int n = 10;
        System.out.println(coinChangeR(arr, arr.length, n));
        System.out.println(coinChangeT(arr, arr.length, n));
    }

    //This is to find minimum num of coins, WRONG ANSWER
    private static int coinChangeT(int[] arr, int n, int val) {
        int[][] dp = new int[n + 1][val + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= val; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (j >= arr[i - 1] && j - arr[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][val];
    }

    private static int coinChangeR(int[] arr, int n, int val) {
        if (n <= 0) return 0;
        if (val < 0) return 0;
        if (val == 0) return 1;
        return coinChangeR(arr, n, val - arr[n - 1])
                + coinChangeR(arr, n - 1, val);
    }

    private static int coinChangeDP(int[] arr, int len, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = arr[i]; j <= n; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[n];
    }
}
