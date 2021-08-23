package com.vikydroid.mylib.oldIntel.practice.practice6.dp;

public class LCS {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(lcsR(s1, s1.length(), s2, s2.length()));

        System.out.println(lcsT(s1, s2));
    }

    private static int lcsT(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] mat = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    mat[i][j] = 1 + mat[i - 1][j - 1];
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        return mat[m][n];
    }

    private static int lcsR(String s1, int n1, String s2, int n2) {
        if (n1 == 0 || n2 == 0) return 0;
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return 1 + lcsR(s1, n1 - 1, s2, n2 - 1);
        } else {
            return Math.max(lcsR(s1, n1 - 1, s2, n2), lcsR(s1, n1, s2, n2 - 1));
        }
    }
}
