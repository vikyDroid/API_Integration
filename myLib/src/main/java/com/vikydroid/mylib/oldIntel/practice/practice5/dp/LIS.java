package com.vikydroid.mylib.oldIntel.practice.practice5.dp;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(arr));
    }

    private static int lis(int[] arr) {
        int n = arr.length;
        if (n == 0) return -1;
        if (n == 1) return arr[0];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
