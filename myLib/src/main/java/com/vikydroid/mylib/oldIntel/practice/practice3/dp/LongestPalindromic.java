package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

import com.sun.org.apache.bcel.internal.generic.I2F;

import java.util.Arrays;

public class LongestPalindromic {
    public static void main(String[] args) {
        String s = "BBABCBCAB";
        char[] chars = s.toCharArray();
        int n = chars.length;
        System.out.println(lps(chars, 0, n - 1));

        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(lpsMemoization(chars, 0, n - 1, memo));
        System.out.println(lpsDP(chars));
    }

    private static int lps(char[] chars, int l, int r) {
        if (l == r) return 1;
        if (chars[l] == chars[r] && l + 1 == r)
            return 2;
        if (chars[l] == chars[r]) {
            return 2 + lps(chars, l + 1, r - 1);
        }
        return Math.max(lps(chars, l, r - 1), lps(chars, l + 1, r));
    }

    private static int lpsMemoization(char[] chars, int l, int r, int[][] memo) {
        if (l == r) return 1;
        if (chars[l] == chars[r] && l + 1 == r)
            return 2;
        if (memo[l][r] != -1) {
            return memo[l][r];
        }
        int res;
        if (chars[l] == chars[r]) {
            res = 2 + lpsMemoization(chars, l + 1, r - 1, memo);
        } else {
            res = Math.max(lpsMemoization(chars, l, r - 1, memo),
                    lpsMemoization(chars, l + 1, r, memo));
        }
        memo[l][r] = res;
        return res;
    }

    //https://www.youtube.com/watch?v=_nCsPn7_OgI&t=260s
    //https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestPalindromicSubsequence.java
    private static int lpsDP(char[] chars) {
        int n = chars.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;                //last element
                if (len == 2 && chars[i] == chars[j]) {
                    dp[i][j] = 2;
                } else if (chars[i] == chars[j]) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
