package com.vikydroid.mylib.oldIntel.practice.practice4.dp;

import java.util.Arrays;

public class LIS {
    static int maxFinal = 0;

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        lisR(arr, arr.length);
        System.out.println(maxFinal);
        System.out.println(lisDP(arr));
    }

    private static int lisR(int[] arr, int n) {
        if (n == 1) return 1;
        int max, meh = 1;
        for (int i = 1; i < n; i++) {
            max = lisR(arr, i);
            if (arr[i - 1] < arr[n - 1])
                meh = Math.max(meh, 1 + max);
        }
        maxFinal = Math.max(maxFinal, meh);
        return meh;
    }

    //O(n^2) time, O(n) space
    private static int lisDP(int[] arr) {
        int n = arr.length;
        if (n == 0) return -1;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //TODO
    //O(nlogn) time, O(n) space
    private static int lisDP2(int[] arr) {

        return 0;
    }

    private void printElements() {
    }

}
