package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

public class EditDist {
    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        System.out.println(editDistR(s1, s2, s1.length(), s2.length()));
        System.out.println(editDistT(s1, s2, s1.length(), s2.length()));
    }

    private static int editDistR(String s1, String s2, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return editDistR(s1, s2, m - 1, n - 1);
        } else return 1 + min(
                editDistR(s1, s2, m, n - 1),//Insert
                editDistR(s1, s2, m - 1, n),//Remove
                editDistR(s1, s2, m - 1, n - 1) //Replace
        );
    }

    private static int editDistT(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(
                            dp[i][j - 1],
                            dp[i - 1][j],
                            dp[i - 1][j - 1]
                    );
                }

            }
        }
        return dp[m][n];
    }

    private static int min(int x, int y, int z) {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        return z;
    }
}
