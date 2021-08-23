package com.vikydroid.mylib.oldIntel.practice.practice6.graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightTour {
    static int[] x = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] y = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) {
        doSomeWork();
    }

    private static void doSomeWork() {
        int n = 30;
        boolean[][] mat = new boolean[n + 1][n + 1];
        int[] startPos = {4, 5};
        int[] targetPos = {1, 1};
        Queue<Cell> queue = new LinkedList<>();
        System.out.println(bfs(mat, startPos, targetPos, queue));
    }

    static class Cell {
        int x, y, dis;

        Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    private static int bfs(boolean[][] mat, int[] startPos, int[] targetPos, Queue<Cell> queue) {
        mat[startPos[0]][startPos[1]] = true;
        queue.add(new Cell(startPos[0], startPos[1], 0));

        while (!queue.isEmpty()) {
            Cell temp = queue.peek();
            queue.remove();
            for (int i = 0; i < x.length; i++) {
                if (temp.x == targetPos[0] && temp.y == targetPos[1]) {
                    return temp.dis;
                }
                int xNew = temp.x + x[i];
                int yNew = temp.y + y[i];

                if (isValid(mat, xNew, yNew)) {
                    mat[xNew][yNew] = true;
                    queue.add(new Cell(xNew, yNew, temp.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private static boolean isValid(boolean[][] mat, int i, int j) {
        return i >= 1 && i < mat.length && j >= 1 && j < mat[0].length && !mat[i][j];
    }

}
