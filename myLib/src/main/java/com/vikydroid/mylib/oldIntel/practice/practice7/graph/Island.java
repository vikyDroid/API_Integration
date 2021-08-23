package com.vikydroid.mylib.oldIntel.practice.practice7.graph;

public class Island {
    public static void main(String[] args) {
        char[][] mat = {
                {0, 1},
                {1, 0},
                {1, 1},
                {1, 0}
        };
        System.out.println(numOfIslands(mat));
    }

    private static int numOfIslands(char[][] mat) {
        int m = mat.length, n = mat[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(mat, i, j, visited);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] mat, int i, int j, boolean[][] visited) {
        int[] X = {1, 0, 1, 1, 0, -1, -1, -1};
        int[] Y = {0, -1, -1, 1, 1, 0, 1, -1};
        visited[i][j] = true;
        for (int k = 0; k < X.length; k++) {
            int x = i + X[k];
            int y = j + Y[k];
            if (isSafe(mat, visited, x, y)) {
                dfs(mat, x, y, visited);
            }
        }
    }

    private static boolean isSafe(char[][] mat, boolean[][] visited, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y] == 1 && !visited[x][y];
    }
}
