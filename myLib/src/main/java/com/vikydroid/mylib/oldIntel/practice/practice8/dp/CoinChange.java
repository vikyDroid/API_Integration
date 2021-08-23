package com.vikydroid.mylib.oldIntel.practice.practice8.dp;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = 4;
        System.out.println(maxSol(arr, arr.length, n));
    }

    private static int maxSol(int[] arr, int len, int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (len <= 0) return 0;
        return maxSol(arr, len, n - arr[len - 1]) +
                maxSol(arr, len - 1, n);
    }
}
