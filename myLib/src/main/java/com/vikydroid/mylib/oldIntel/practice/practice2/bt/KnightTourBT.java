package com.vikydroid.mylib.oldIntel.practice.practice2.bt;

import java.util.Arrays;

public class KnightTourBT {
    public static void main(String[] args) {
        int N = 8;
        int[][] mat = new int[N][N];
        if (new KnightTourBT().knightTourBT(mat)) {
            for (int[] a : mat) {
                Arrays.toString(a);
            }
        }
    }

    public boolean knightTourBT(int[][] mat) {
        int[] x = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] y = {-1, -2, -2, -1, 1, 2, 2, 1};
        return util(mat, 0, 0);
    }

    private boolean util(int[][] mat, int row, int col) {

        return false;
    }
}
