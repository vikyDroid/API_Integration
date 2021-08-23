package com.vikydroid.mylib.oldIntel.practice.practice6.graph.bt;

import java.util.Arrays;

public class KnightTour {
    static int[] x = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] y = {1, -1, 2, -2, 2, -2, 1, -1};

//    static int[] x = {2, 1, -1, -2, -2, -1, 1, 2};
//    static int[] y = {1, 2, 2, 1, -1, -2, -2, -1};

    static int n = 8;

    public static void main(String[] args) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i], -1);
        }
        solveKT(mat);
    }

    private static boolean isSame(int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i]) return false;
        }
        return true;
    }

    private static void solveKT(int[][] mat) {
        mat[0][0] = 0;
        if (isSolveKTUtils(mat, 0, 0, 1)) {
            printSol(mat);
        } else {
            System.out.println("'No solution exists");
        }
    }

    private static boolean isSolveKTUtils(int[][] mat, int i, int j, int dist) {
        if (dist == n * n){
            return true;
        }
        for (int k = 0; k < x.length; k++) {
            int xNew = i + x[k];
            int yNew = j + y[k];
            if (isSafe(mat, xNew, yNew)) {
                mat[xNew][yNew] = dist;
                if (isSolveKTUtils(mat, xNew, yNew, dist + 1)) {
                    return true;
                } else {
                    mat[xNew][yNew] = -1;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] mat, int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n && mat[i][j] == -1;
    }

    private static void printSol(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
