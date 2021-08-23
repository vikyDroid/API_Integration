package com.vikydroid.mylib.oldIntel.practice.practice4.dp;

import java.util.Arrays;

public class FrogJump {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;
        System.out.println(minStepsR(arr, 0, n - 1));
        int[][] memo = new int[n][n];
        for (int[] A : memo) {
            Arrays.fill(A, -1);
        }
        System.out.println(minStepsMemo(arr, 0, arr.length - 1, memo));
        System.out.println(minStepsDP(arr));
    }

    private static int minStepsR(int[] arr, int l, int r) {
        if (l == r) return 0;
        if (arr[l] == 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 1 + l; i <= r && i <= l + arr[l]; i++) {
            int jumps = minStepsR(arr, i, r);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }
        return min;
    }

    private static int minStepsMemo(int[] arr, int l, int r, int[][] memo) {
        if (l == r) return 0;
        if (arr[l] == 0) return Integer.MAX_VALUE;
        if (memo[l][r] != -1) return memo[l][r];
        int min = Integer.MAX_VALUE;
        for (int i = 1 + l; i <= r && i <= l + arr[l]; i++) {
            int jumps = minStepsR(arr, i, r);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }
        memo[l][r] = min;
        return min;
    }

    private static int minStepsDP(int[] arr) {
        int n = arr.length;
        if (n == 0 || arr[0] == 0) return Integer.MAX_VALUE;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }
        return dp[n - 1];
    }

    //Wrong
    private static int minSteps(int[] arr, int l, int r) {
        int minLocal = 0;
        for (int j = arr[l]; j > 0; j--) {
            if (r <= l + j) {
                return 0;
            } else {
                minLocal = 1 + minSteps(arr, l + j, r);
                min = Math.min(min, minLocal);
            }
        }
        return minLocal;
    }
}
