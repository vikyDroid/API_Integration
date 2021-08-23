package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

import java.util.Arrays;

public class LongestPalindromicSubSequence {
    public static void main(String[] args) {
        String s = "BBABCBCAB";
        System.out.println(longestPS(s));
    }

    private static int longestPS(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return n;
        if (s.charAt(0) == s.charAt(n - 1))
            return 2 + longestPS(s.substring(1, n - 1));
        return Math.max(longestPS(s.substring(1)),
                longestPS(s.substring(0, n - 1)));
    }

    private static int longestPST(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
