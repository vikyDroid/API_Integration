package com.vikydroid.mylib.oldIntel.practice.practice6.graph.bt;

public class RatInMaze {
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int[][] sol = new int[mat.length][mat[0].length];
        sol[0][0] = 1;
        if (isSolve(mat, 0, 0, sol)) {
            printSol(sol);
        } else {
            System.out.println("rate can't reach destination");
        }
    }

    private static void printSol(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSolve(int[][] mat, int i, int j, int[][] sol) {
        if (i == mat.length - 1 && j == mat[0].length - 1 && mat[i][j] == 1) {
            sol[i][j] = 1;
            return true;
        }
        for (int k = 0; k < x.length; k++) {
            int xNew = i + x[k];
            int yNew = j + y[k];
            if (isSafe(mat, xNew, yNew)) {
                if (sol[xNew][yNew] == 1)
                    return false;
                sol[xNew][yNew] = 1;
                if (isSolve(mat, xNew, yNew, sol)) {
                    return true;
                } else {
                    sol[xNew][yNew] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] mat, int i, int j) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == 1;
    }
}
