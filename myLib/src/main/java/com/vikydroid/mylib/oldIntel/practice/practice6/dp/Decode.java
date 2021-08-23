package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

public class Decode {
    public static void main(String[] args) {
        String s = "1234";
        System.out.println(decode(s.toCharArray(), s.length()));
        System.out.println(decodeT(s.toCharArray(), s.length()));
    }

    private static int decode(char[] arr, int n) {
        if (n == 0 || n == 1) return 1;
        if (arr[0] == '0') return 0;
        int count = 0;
        if (arr[n - 1] > '0')
            count = decode(arr, n - 1);
        if (arr[n - 2] == '1' || (arr[n - 2] == '2' && arr[n - 1] < '7'))
            count += decode(arr, n - 2);
        return count;
    }

    private static int decodeT(char[] arr, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (arr[i - 1] > '0')
                dp[i] = dp[i - 1];
            if (arr[i - 2] == '1' || (arr[i - 2] == '2' && arr[i - 1] < '7'))
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
