package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=DxhfziFFJNc
 */
public class LIS {
    public static void main(String[] args) {
        int[] arr = {3, 10, 2, 1, 20};
        System.out.println(lis(arr));
    }

    private static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
