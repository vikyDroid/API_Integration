package com.vikydroid.mylib.oldIntel.practice.practice7;

public class Practice {
    public static void main(String[] args) {

        System.out.println(new Practice().numberOfPaths(3, 3));

    }

    long numberOfPaths(int m, int n) {
        int count = 0;
        while (true) {
            boolean[][] isVisited = new boolean[m][n];
            if (helper(0, 0, isVisited, m, n)) {
                count++;
            } else
                break;
        }
        return count;
    }

    private boolean helper(int x, int y, boolean[][] isVisited, int m, int n) {
        if (!isValidIndex(x, y, m, n, isVisited)) return false;
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        isVisited[x][y] = true;
//        int[] xCoordinates = {1, 0, -1, 0};
//        int[] yCoordinates = {0, 1, 0, -1};
//        boolean isFound = false;
        /*for (int i = 0; i < xCoordinates.length; i++) {
            if (helper(x + xCoordinates[i], y + yCoordinates[i], isVisited, m, n)) {
                isFound = true;
                break;
            }
        }*/
        if (helper(x + 1, y, isVisited, m, n)) {
            return true;
        }
        if (helper(x, y + 1, isVisited, m, n)) {
            return true;
        }
        return false;
    }

    private boolean isValidIndex(int x, int y, int m, int n, boolean[][] isVisited) {
        return x >= 0 && x < m && y >= 0 && y < n && !isVisited[x][y];
    }
}
