package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

public class LCS {

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(lcsDP2(s1, s2));
        System.out.println(lcsR(s1, s2, 0, 0));
    }

    //Efficient using DP
    private static int lcsDP2(String s1, String s2) {
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
        int size = dp[m][n];//This the result num of LCS

        //Printing chars
        char[] lcsChars = new char[size];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcsChars[size - 1] = s1.charAt(i - 1);
                i--;
                j--;
                size--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else
                j--;
        }
        for (char lcsChar : lcsChars) {
            System.out.print(lcsChar);
        }
        System.out.println();
        return lcsChars.length;
    }

    private static int lcsR(String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcsR(s1, s2, i + 1, j + 1);
        }
        return Math.max(lcsR(s1, s2, i + 1, j), lcsR(s1, s2, i, j + 1));
    }


    //Space optimised
    public static int lcs(String X, String Y) {

        // Find lengths of two strings
        int m = X.length(), n = Y.length();

        int L[][] = new int[2][n + 1];

        // Binary index, used to index
        // current row and previous row.
        int bi = 0;

        for (int i = 0; i <= m; i++) {

            // Compute current binary index
            bi = i & 1;

            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[bi][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[bi][j] = L[1 - bi][j - 1] + 1;
                else
                    L[bi][j] = Math.max(L[1 - bi][j], L[bi][j - 1]);
            }
        }

        // Last filled entry contains length of
        // LCS for X[0..n-1] and Y[0..m-1]
        return L[bi][n];
    }
}

