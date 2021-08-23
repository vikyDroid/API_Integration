package com.vikydroid.mylib.oldIntel.practice.practice5.dp;

import java.util.Arrays;

public class LongestPalindromicSubSequence {
    public static void main(String[] args) {
        String s = "BBABCBCAB";
        System.out.println(lcs(s, 0, s.length()));
        System.out.println(lcs(s));
    }

    private static int lcs(String s, int start, int n) {
        if (start > n - 1) return 0;
        if (start == n - 1) return 1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (s.charAt(start) == s.charAt(n - 1))
            return 2 + lcs(s, start + 1, n - 1);
        return Math.max(lcs(s, start, n - 1), lcs(s, start + 1, n));
    }

    private static int lcs(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2 + dp[i - 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
            }
        }
        return dp[n][n];
    }
}
