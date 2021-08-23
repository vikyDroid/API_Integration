package com.vikydroid.mylib.oldIntel.practice.practice5.graph;

public class Islands {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        System.out.println(numOfIsland(mat));
    }

    private static int numOfIsland(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] x = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] y = {1, 1, 1, 0, 0, -1, -1, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }


        return -1;
    }
}
