package com.vikydroid.mylib.oldIntel.practice.practice6.graph;

public class NumOfIslands {
    static int num = 0;

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(numOfIslands(mat));
    }

    private static int numOfIslands(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isValidIndex(mat, isVisited, i, j)) {
                    num++;
                    dfs(mat, isVisited, i, j);
                }
            }
        }
        return num;
    }

    private static boolean isValidIndex(int[][] mat, boolean[][] isVisited, int i, int j) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && !isVisited[i][j] && mat[i][j] == 1;
    }

    private static void dfs(int[][] mat, boolean[][] isVisited, int i, int j) {
        isVisited[i][j] = true;
        int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int k = 0; k < x.length; k++) {
            int xNew = i + x[k];
            int yNew = j + y[k];
            if (isValidIndex(mat, isVisited, xNew, yNew)) {
                dfs(mat, isVisited, xNew, yNew);
            }
        }
    }
}
