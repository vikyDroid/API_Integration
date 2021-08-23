package com.vikydroid.mylib.oldIntel.practice.practice7.graph;

import java.util.Arrays;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] mat = {
                {2, 2, 0, 1}
        };
        System.out.println(getNum(mat));
    }

    static boolean isChanged = true;
    static int count = 0;

    private static int getNum(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        while (isChanged) {
            for (boolean[] arr : visited) {
                Arrays.fill(arr, false);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        if (isChanged) {
                            isChanged = false;
                            minTimeToRotAll(mat, visited);
                            if (isChanged) {
                                count++;
                            }
                        } else {
                            return getCount(count);
                        }
                    }
                    if (i == m - 1 && j == n - 1) return getCount(count);
                }
            }
        }
        return getCount(count);
    }

    private static int getCount(int count) {
        if (count == 0) return -1;
        return count;
    }

    private static void minTimeToRotAll(int[][] mat, boolean[][] visited) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2 && !visited[i][j]) {
                    changeData(mat, i, j, visited);
                }
            }
        }
    }

    private static void changeData(int[][] mat, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int[] X = {1, 0, -1, 0};
        int[] Y = {0, 1, 0, -1};
        for (int k = 0; k < X.length; k++) {
            int x = i + X[k];
            int y = j + Y[k];
            if (isSafe(mat, x, y, visited)) {
                if (mat[x][y] == 1) {
                    mat[x][y] = 2;
                    visited[x][y] = true;
                    isChanged = true;
                }
            }
        }
    }

    private static boolean isSafe(int[][] mat, int i, int j, boolean[][] visited) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] != 0 && !visited[i][j];
    }
}
