package com.vikydroid.mylib.oldIntel.interviews;

public class MinCostInGraph {
    public static void main(String[] args) {
        int A = 1, B = 3, N = 4, E = 5;
        int[][] mat = {
                {1, 2, 3},
                {2, 3, 5},
                {1, 4, 2},
                {4, 3, 1},
                {1, 3, 10}
        };
        System.out.println(minCost(N, E, mat, A, B));
    }

    private static int minCost(int N, int E, int[][] mat, int A, int B) {
        int min = Integer.MAX_VALUE;
        boolean[] vis = new boolean[E];
        while (isAllNotVis(vis)) {
            int sum = 0, start = A;
            for (int i = 0; i < E; i++) {
                if (!vis[i] && mat[i][0] == start) {
                    sum += mat[i][2];
                    vis[i] = true;
                    start = mat[i][1];
                    if (start == B) {
                        break;
                    }
                }
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    private static boolean isAllNotVis(boolean[] vis) {
        for (boolean v : vis) {
            if (!v) return true;
        }
        return false;
    }
}
