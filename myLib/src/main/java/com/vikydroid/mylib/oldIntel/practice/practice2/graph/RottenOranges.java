package com.vikydroid.mylib.oldIntel.practice.practice2.graph;

import com.vikydroid.mylib.oldIntel.practice.practice2.templateT.Queue;

import java.util.Arrays;

public class RottenOranges {

    static boolean isChanged = true;
    static boolean isChangedNaive = false;

    public static void main(String[] args) {
        int[][] mat = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        new RottenOranges().rotOrangesBFS(mat);
    }

    /**
     * Some error in following code
     * Please refer https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
     * or retry
     *
     * @param mat
     * @return
     */
    public int rotOrangesBFS(int[][] mat) {
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;
        Queue<Cell> queue = new Queue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2)
                    queue.add(new Cell(i, j));
            }
        }
        queue.add(new Cell(-1, -1));
        while (!queue.isEmpty()) {
            boolean flag = false;
            while (!isDelim(queue.peek())) {
                Cell cell = queue.poll();
                int[] X = {0, -1, 0, 1};
                int[] Y = {-1, 0, 1, 0};
                for (int k = 0; k < X.length; k++) {
                    int row = cell.x + X[k];
                    int col = cell.y + Y[k];
                    if (isSafe(mat, row, col) && mat[row][col] == 1) {
                        if (!flag) {
                            flag = true;
                            count++;
                        }
                        mat[row][col] = 2;
                        queue.add(new Cell(row, col));
                    }
                }
            }
            queue.poll();
            if (queue.isEmpty()) {
                queue.add(new Cell(-1, -1));
            }
        }

        return checkAll(mat) ? -1 : count;
    }

    private boolean isDelim(Cell cell) {
        return cell.x == -1 && cell.y == -1;
    }

    //Naive Approach
    public int rotOranges(int[][] mat) {
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;
        while (true) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 2) {
                        int[] X = {0, -1, 0, 1};
                        int[] Y = {-1, 0, 1, 0};
                        for (int k = 0; k < X.length; k++) {
                            int row = i + X[k];
                            int col = j + Y[k];
                            if (isSafe(mat, row, col) && mat[row][col] == 1) {
                                mat[row][col] = 2;
                                isChangedNaive = true;
                            }
                        }
                    }
                }
                if (i == m - 1) count++;
            }
            if (!isChanged) {
                break;
            }
            isChanged = false;
        }
        if (checkAll(mat)) return -1;
        System.out.println("Num of cycles in naive : " + count);
        return count;
    }

    private boolean checkAll(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    return true;
            }
        }
        return false;
    }

    //self created
    public int timeRequired(int[][] mat) {
        int count = 0;
        count = getCount(mat, count);
        int m = mat.length;
        int n = mat[0].length;
        if (checkAll(mat)) return -1;
        return count;
    }

    private int getCount(int[][] mat, int count) {
        int m = mat.length;
        int n = mat[0].length;
        while (isChanged) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 2) {
                        BFS(mat, i, j, count);
                    }
                }
                if (isChanged) {
                    count++;
                }
                if (i == m - 1) {
                    System.out.println("\nAt " + count + "th time frame:");
                    printArr(mat);
                }
            }

        }
        return count;
    }

    private void printArr(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    private void BFS(int[][] mat, int row, int col, int count) {
        isChanged = false;
        int[] X = {0, -1, 0, 1};
        int[] Y = {-1, 0, 1, 0};
        int n = X.length;
        for (int k = 0; k < n; k++) {
            int row1 = row + X[k];
            int col1 = col + Y[k];
            if (isSafe(mat, row1, col1) && mat[row1][col1] == 1) {
                mat[row1][col1] = 2;
                isChanged = true;
            }
        }
    }

    private boolean isSafe(int[][] mat, int row, int col) {
        int m = mat.length;
        int n = mat[0].length;
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    static class Cell {
        int x, y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
