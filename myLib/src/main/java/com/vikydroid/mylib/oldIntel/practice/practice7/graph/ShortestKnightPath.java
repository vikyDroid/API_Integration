package com.vikydroid.mylib.oldIntel.practice.practice7.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestKnightPath {
    public static void main(String[] args) {
        int n = 6;
        int[] start = {4, 5};
        int[] target = {1, 1};
        System.out.println(minStepToReachTarget(start, target, n));
    }

    private static int minStepToReachTarget(int[] start, int[] target, int n) {
        boolean[][] visited = new boolean[n + 1][n + 1];
        int[] X = {1, 2, -1, -2, 2, 1, -2, -1};
        int[] Y = {-2, -1, 2, 1, 1, 2, -1, -2};
        visited[start[0]][start[1]] = true;
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            Cell temp = queue.poll();
            if (temp.x == target[0] && temp.y == target[1]) {
                return temp.dis;
            }
            for (int i = 0; i < X.length; i++) {
                int newX = temp.x + X[i];
                int newY = temp.y + Y[i];
                if (isSafe(visited, newX, newY, n)) {
                    visited[newX][newY] = true;
                    queue.add(new Cell(newX, newY, temp.dis + 1));
                }
            }
        }
        return -1;
    }

    private static boolean isSafe(boolean[][] visited, int x, int y, int n) {
        return x >= 1 && x <= n && y >= 1 && y <= n && !visited[x][y];
    }

    static class Cell {
        int x, y, dis;

        Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

    }
}
