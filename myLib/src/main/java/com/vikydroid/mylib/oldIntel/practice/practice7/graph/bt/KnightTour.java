package com.vikydroid.mylib.oldIntel.practice.practice7.graph.bt;

import java.util.Arrays;

public class KnightTour {
    public static void main(String[] args) {
        int n = 8;
        printOrder(n);
    }

    private static void printOrder(int n) {
        int[][] mat = new int[n][n];
        for (int[] arr : mat) {
            Arrays.fill(arr, -1);
        }
        mat[0][0] = 0;
        if (dfs(mat, 0, 0, n, 1)) {
            printMat(mat);
        } else {
            System.out.println("Can not meet the end");
        }
    }

    private static boolean dfs(int[][] mat, int i, int j, int n, int move) {
//        int[] X = {1, 2, -1, -2, 2, 1, -2, -1};
//        int[] Y = {-2, -1, 2, 1, 1, 2, -1, -2};
        int[] X = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] Y = {1, 2, 2, 1, -1, -2, -2, -1};
        if (move == n * n)
            return true;
        for (int k = 0; k < X.length; k++) {
            int x = i + X[k];
            int y = j + Y[k];
            if (isSafe(mat, x, y, n)) {
                mat[x][y] = move;
                if (dfs(mat, x, y, n, move + 1)) {
                    return true;
                } else {
                    mat[x][y] = -1;//Backtrack
                }
            }
        }
        return false;
    }

    private static void printMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] mat, int x, int y, int n) {
        return x >= 0 && x < n && y > 0 && y < n && mat[x][y] == -1;
    }
}
