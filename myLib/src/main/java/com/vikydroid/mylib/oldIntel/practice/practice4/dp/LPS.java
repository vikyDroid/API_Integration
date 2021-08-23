package com.vikydroid.mylib.oldIntel.practice.practice4.dp;

import java.util.Arrays;

public class LPS {
    public static void main(String[] args) {
        String s = "BBABCBCAB";
        int n = s.length();
        System.out.println(lpsR(s, 0, n - 1));
        int[][] memo = new int[n + 1][n + 1];
        for (int[] A : memo) {
            Arrays.fill(A, -1);
        }
        System.out.println(lpsMemo(s, 0, n - 1, memo));
        System.out.println(lpsDP(s));
    }

    private static int lpsR(String s, int l, int r) {
        if (l == r) {
            return 1;
        }
        boolean isSame = s.charAt(l) == s.charAt(r);
        if (isSame && l + 1 == r) return 2;
        if (isSame) return 2 + lpsR(s, l + 1, r - 1);
        return Math.max(lpsR(s, l, r - 1), lpsR(s, l + 1, r));
    }

    private static int lpsMemo(String s, int l, int r, int[][] memo) {
        if (l == r) {
            return 1;
        }
        if (memo[l][r] != -1) {
            return memo[l][r];
        }
        boolean isSame = s.charAt(l) == s.charAt(r);
        if (isSame && l + 1 == r) return 2;
        if (isSame) {
            int m = 2 + lpsMemo(s, l + 1, r - 1, memo);
            memo[l][r] = m;
            return m;
        }
        int max = Math.max(lpsMemo(s, l, r - 1, memo), lpsMemo(s, l + 1, r, memo));
        memo[l][r] = max;
        return max;
    }

    private static int lpsDP(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                boolean isSame = s.charAt(i) == s.charAt(j);
                if (len == 2 && isSame)
                    dp[i][j] = 2;
                else if (isSame)
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}
