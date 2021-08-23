package com.vikydroid.mylib.oldIntel.practice.practice4.dp;

//import sun.plugin2.ipc.windows.WindowsIPCFactory;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6};
        int sum = 10;
        int n = arr.length;
        System.out.println(ccR(arr, n, sum));
        int[][] memo = new int[n + 1][sum + 1];
        for (int[] A : memo) {
            Arrays.fill(A, -1);
        }
        System.out.println(ccMemo(arr, n, sum, memo));
        System.out.println(ccDP(arr, sum));
        System.out.println(ccDP2(arr, sum));
    }

    private static int ccR(int[] arr, int n, int sum) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        if (n <= 0) return 0;
        return ccR(arr, n - 1, sum) //Coin not included
                + ccR(arr, n, sum - arr[n - 1]); //Coin included
    }

    private static int ccMemo(int[] arr, int n, int sum, int[][] memo) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        if (n <= 0) return 0;
        if (memo[n][sum] != -1) {
            return memo[n][sum];
        }
        int val = ccR(arr, n - 1, sum) + ccR(arr, n, sum - arr[n - 1]);
        memo[n][sum] = val;
        return val;
    }

    private static int ccDP(int[] arr, int sum) {
        int n = arr.length;
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        if (n <= 0) return 0;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
            }
        }
        return dp[n][sum];
    }

    //Memory Efficient
    private static int ccDP2(int[] arr, int sum) {
        int n = arr.length;
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        if (n <= 0) return 0;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= sum; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[sum];
    }

}
