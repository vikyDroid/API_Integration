package com.vikydroid.mylib.oldIntel.practice.practice5.dp;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6};
        int x = 10;
        System.out.println(coinChange(arr, arr.length, x));
    }

    private static int coinChange(int[] arr, int n, int x) {
        if (x == 0) return 1;
        if (x < 0) return 0;
        if (n <= 0) return 0;
        return coinChange(arr, n, x - arr[n - 1])
                + coinChange(arr, n - 1, x);
    }
}
