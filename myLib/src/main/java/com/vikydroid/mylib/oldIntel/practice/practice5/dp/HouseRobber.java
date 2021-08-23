package com.vikydroid.mylib.oldIntel.practice.practice5.dp;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 11, 2};
        System.out.println(houseRobber(arr));
    }

    private static int houseRobber(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
