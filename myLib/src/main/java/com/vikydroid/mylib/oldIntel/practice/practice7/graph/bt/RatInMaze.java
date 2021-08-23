package com.vikydroid.mylib.oldIntel.practice.practice7.graph.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        findPath(mat, 4);
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void findPath(int[][] mat, int n) {
        Queue<Point> queue = new LinkedList<>();
        if (dfs(0, 0, mat, n, queue)) {
            printPath(queue);
        } else {
            System.out.println("-1");
        }
    }

    private static void printPath(Queue<Point> queue) {
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            System.out.print("(" + temp.x + "," + temp.y + ") ");
        }
    }

    static boolean dfs(int i, int j, int[][] mat, int n, Queue<Point> queue) {
        if (i == n - 1 && j == n - 1)
            return true;
        if (isSafe(i, j - 1, mat, n)) {
            if (dfs(i, j - 1, mat, n, queue)) {
                queue.add(new Point(i, j - 1));
                return true;
            } else {
                mat[i][j + 1] = 0;//Backtrack
            }
        }
        if (isSafe(i + 1, j, mat, n)) {
            if (dfs(i + 1, j, mat, n, queue)) {
                queue.add(new Point(i, j + 1));
                return true;
            } else {
                mat[i + 1][j] = 0;//Backtrack
            }
        }
        return false;
    }

    private static boolean isSafe(int x, int y, int[][] mat, int n) {
        return x >= 0 && x < n && y >= 0 && y < n && mat[x][y] != 0;
    }
}
