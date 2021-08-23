package com.vikydroid.mylib.oldIntel.interviews.cisco;

public class Cisco2 {
    public static void main(String[] args) {
        int[][] a = {
                {0, 3, 5, 0, 1, 6, 9, 2, 7},
                {2, 9, 6, 0, 5, 7, 4, 3, 1},
                {0, 1, 7, 2, 9, 3, 6, 5, 8},
                {0, 6, 9, 0, 3, 0, 7, 8, 2},
                {1, 2, 3, 6, 7, 0, 5, 4, 9},
                {7, 4, 8, 0, 2, 0, 1, 6, 3},
                {6, 5, 2, 7, 8, 0, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}
        };
        // too large
        int[][] b = {
                {8, 3, 5, 4, 1, 6, 9, 2, 7},
                {2, 9, 6, 8, 5, 7, 4, 3, 1},
                {4, 1, 7, 2, 9, 3, 6, 5, 8},
                {5, 6, 9, 1, 3, 4, 7, 8, 2},
                {1, 2, 3, 6, 7, 8, 5, 4, 9},
                {7, 4, 8, 5, 2, 9, 1, 6, 3},
                {6, 5, 2, 7, 8, 1, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}
        };

        System.out.println(isValidSol(a, b));
    }

    static boolean isValidSol(int[][] set1, int[][] set2) {
        int n = set1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set1[i][j] != 0 && set1[i][j] != set2[i][j]) return false;
            }
        }

        //every column
        for (int i = 0; i < n; i++) {
            boolean[] temp = new boolean[9];
            for (int j = 0; j < n; j++) {
                if (temp[set2[i][j] - 1]) {
                    return false;
                } else {
                    temp[set2[i][j] - 1] = true;
                }
            }
        }

        //every row
        for (int i = 0; i < n; i++) {
            boolean[] temp = new boolean[9];
            for (int j = 0; j < n; j++) {
                if (temp[set2[j][i] - 1]) {
                    return false;
                } else {
                    temp[set2[j][i] - 1] = true;
                }
            }
        }

        int p = 0, q = 0;
        while (p < n) { //0
            while (q < n) {//0
                boolean[] temp = new boolean[9];
                for (int i = p; i < p + 3; i++) { // i=1
                    for (int j = q; j < q + 3; j++) {//
                        if (temp[set2[i][j] - 1]) {
                            return false;
                        } else {
                            temp[set2[i][j] - 1] = true;
                        }
                    }
                }
                q += 3;
            }
            p += 3;
        }
        return true;
    }
}
