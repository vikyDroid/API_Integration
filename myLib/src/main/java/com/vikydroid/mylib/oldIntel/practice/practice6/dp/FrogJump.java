package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {2, 1, 0, 3};
//        int[] arr = {0, 1, 1, 1, 1};
//        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println(getJumpsT(arr));
    }

    private static int getJumpsT(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 && arr[i] == 0) return -1;
            int x = 1;
            while (x <= arr[i] && i + x < n) {
                dp[i + x] = Math.min(dp[i] + 1, dp[i + x]);
                x++;
            }
        }
        if (dp[n - 1] == Integer.MAX_VALUE) return -1;
        return dp[n - 1];
    }
}
