package com.vikydroid.mylib.oldIntel.practice.practice3.graph;

import java.util.Arrays;

public class Island {
    static int[][] mat = new int[][]{
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0}
    };
    static int m = mat.length;
    static int n = mat[0].length;
    static int[] adjX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] adjY = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        System.out.println(numOfIslands(mat));
    }

    private static int numOfIslands(int[][] mat) {
        int res = 0, maxRes = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isValidIndex(i, j, mat, visited)) {
                    res++;
                    MaxOnes maxOnes = new MaxOnes();
                    maxOnes.max = 0;
                    dfs(i, j, mat, visited, maxOnes);
                    maxRes = Math.max(maxRes, maxOnes.max);
                }
            }
        }
        System.out.println(maxRes);
        return res;
    }

    private static void dfs(int i, int j, int[][] mat, boolean[][] visited, MaxOnes maxOnes) {
        visited[i][j] = true;
        for (int k = 0; k < adjX.length; k++) {
            int iNew = i + adjX[k];
            int jNew = i + adjY[k];
            if (isValidIndex(iNew, jNew, mat, visited)) {
                maxOnes.max++;
                dfs(iNew, jNew, mat, visited, maxOnes);
            }
        }
    }

    private static boolean isValidIndex(int i, int j, int[][] mat, boolean[][] visited) {
        return (i >= 0 && i < m && j >= 0 && j < n && mat[i][j] == 1 && !visited[i][j]);
    }

    static class MaxOnes {
        int max;
    }
}
