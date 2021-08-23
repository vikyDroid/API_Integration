package com.vikydroid.mylib.oldIntel.practice.practice5.dp;

public class LCS {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        System.out.println(lcsR(s1, s2, 0, 0));
        System.out.println(lcsDP(s1, s2));
    }

    private static int lcsDP(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    private static int lcsR(String s1, String s2, int x, int y) {
        if (x >= s1.length() || y >= s2.length()) return 0;
        if (s1.charAt(x) == s2.charAt(y))
            return 1 + lcsR(s1, s2, x + 1, y + 1);
        return Math.max(lcsR(s1, s2, x + 1, y), lcsR(s1, s2, x, y + 1));
    }
}
