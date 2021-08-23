package com.vikydroid.mylib.oldIntel.practice.practice4.dp;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 3, 8, 2, 4};
        System.out.println(matR(arr, 0, arr.length - 1));

        int[][] memo = new int[arr.length][arr.length];
        for (int[] A : memo) {
            Arrays.fill(A, -1);
        }
        System.out.println(matMemo(arr, 0, arr.length - 1, memo));
        System.out.println(matDP(arr));
        System.out.println(matDP2(arr));
    }

    private static int matR(int[] arr, int l, int r) {
        int diff = r - l;
        if (diff < 0) return 0;
        if (diff == 0) return arr[l];                         //Only One element
        if (diff == 1) return Math.max(arr[l], arr[r]);       //Only two elements
        return Math.max(arr[l] + matR(arr, l + 2, r),
                matR(arr, l + 1, r));
    }

    private static int matMemo(int[] arr, int l, int r, int[][] memo) {
        int diff = r - l;
        if (diff < 0) return 0;
        if (diff == 0) return arr[l];                         //Only One element
        if (diff == 1) return Math.max(arr[l], arr[r]);       //Only two elements
        if (memo[l][r] != -1)
            return memo[l][r];
        int max = Math.max(arr[l] + matMemo(arr, l + 2, r, memo),
                matMemo(arr, l + 1, r, memo));
        memo[l][r] = max;
        return max;
    }

    private static int matDP(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);
        //Main Logic
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }

    //Efficient one
    private static int matDP2(int[] arr) {
        int n = arr.length, left = 0, right = 0;
        if (n == 1) right = arr[0];
        if (n > 1) {
            left = arr[0];
            right = Math.max(arr[0], arr[1]);
        }
        for (int i = 2; i < n; i++) {
            int temp = Math.max(arr[i] + left, right);
            left = right;
            right = temp;
        }
        return right;
    }
}
