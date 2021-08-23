package com.vikydroid.mylib.oldIntel.practice.practice4.dp;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();
        System.out.println(lcsR(s1, s2, m - 1, n - 1));
        int[][] memo = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        System.out.println(lcsMemo(s1, s2, m - 1, n - 1, memo));
        System.out.println(lcsDP(s1, s2));
    }

    private static int lcsR(String s1, String s2, int m, int n) {
        if (m < 0 || n < 0) return 0;     //Base case
        if (s1.charAt(m) == s2.charAt(n)) {
            return 1 + lcsR(s1, s2, m - 1, n - 1);
        } else
            return Math.max(lcsR(s1, s2, m, n - 1), lcsR(s1, s2, m - 1, n));
    }

    private static int lcsMemo(String s1, String s2, int m, int n, int[][] memo) {
        if (m < 0 || n < 0) return 0;         //Base case
        if (memo[m][n] != -1) return memo[m][n];
        if (s1.charAt(m) == s2.charAt(n)) {
            memo[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1, memo);
        } else {
            memo[m][n] = Math.max(lcsMemo(s1, s2, m, n - 1, memo), lcsMemo(s1, s2, m - 1, n, memo));
        }
        return memo[m][n];
    }

    private static int lcsDP(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {          //Base Case
                    dp[i][j] = 0;
                }else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
//                    System.out.print(s1.charAt(i - 1));
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    //Wrong
    private static int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length(), max = 0;
        for (int k = 0; k < m; k++) {
            int i = k;
            int maxLocal = 0;
            while (i < m) {
                int j = 0;
                while (i < m && j < n) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        maxLocal += 1;
                        i++;
                    }
                    j++;
                }
                i++;
                max = Math.max(max, maxLocal);
            }

        }
        return max;
    }
}
