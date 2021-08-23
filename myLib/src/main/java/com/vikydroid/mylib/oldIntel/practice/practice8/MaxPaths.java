package com.vikydroid.mylib.oldIntel.practice.practice8;

public class MaxPaths {
    static int paths = 0;

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6}
        };
        maxPaths(0, 0, mat);
        System.out.println(paths);
    }

    private static void maxPaths(int x, int y, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        if (x == m - 1 && y == n - 1) {
            paths++;
            return;
        }
        int newX = x, newY = y + 1;
        if (isSafe(x, y, mat)) {
            maxPaths(newX, newY, mat);
        }

        newX = x + 1;
        newY = y;
        if (isSafe(x, y, mat)) {
            maxPaths(newX, newY, mat);
        }
    }

    private static boolean isSafe(int x, int y, int[][] mat) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
