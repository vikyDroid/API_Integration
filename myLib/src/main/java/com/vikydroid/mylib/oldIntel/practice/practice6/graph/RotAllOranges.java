package com.vikydroid.mylib.oldIntel.practice.practice6.graph;

public class RotAllOranges {
    static boolean isChanged = true;

    public static void main(String[] args) {
        int[][] mat = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };
        System.out.println(rotOranges(mat));
    }

    private static int rotOranges(int[][] mat) {
        boolean[][] isVisited = new boolean[mat.length][mat[0].length];
        int count = 0;
        while (isAllNotRotten(mat) && isChanged) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 2) {
                        isVisited[i][j] = true;
                    }
                }
            }
            count++;
            isChanged = false;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 2 && isVisited[i][j]) {
                        bfs(mat, i, j);
                    }
                }
            }
        }
        if (isAllNotRotten(mat)) return -1;
        return count;
    }

    private static boolean isAllNotRotten(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    return true;
                }

            }
        }
        return false;
    }

    private static void bfs(int[][] mat, int i, int j) {
        int[] x = {0, 1, -1, 0};
        int[] y = {1, 0, 0, -1};
        for (int k = 0; k < x.length; k++) {
            int xNew = i + x[k];
            int yNew = j + y[k];
            if (isSafe(mat, xNew, yNew)) {
                mat[xNew][yNew] = 2;
                isChanged = true;
            }
        }
    }

    private static boolean isSafe(int[][] mat, int i, int j) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] != 0;
    }
}
