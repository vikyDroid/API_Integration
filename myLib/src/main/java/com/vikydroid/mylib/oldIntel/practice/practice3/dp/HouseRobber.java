package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 11, 2};
        System.out.println(getMaxValueTheftDP(arr));
        System.out.println(getMaxValueTheftDP2(arr));
    }

    /**
     * Efficient O(n) time O(1) space
     */
    private static int getMaxValueTheftDP2(int[] arr) {
        int n = arr.length, left, right, maxVal;
        left = arr[0];
        right = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            maxVal = Math.max(right, left + arr[i]);
            left = right;
            right = maxVal;
        }
        return right;
    }

    //O(n) time
    private static int getMaxValueTheftDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[n - 1];
    }

}
