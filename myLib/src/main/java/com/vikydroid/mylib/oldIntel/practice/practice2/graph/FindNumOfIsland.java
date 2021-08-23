package com.vikydroid.mylib.oldIntel.practice.practice2.graph;

import com.practice.practice.practice2.templateT.Queue;

public class FindNumOfIsland {
    int maxCount = 0;

    static class IslandSize {
        int size = 0;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        FindNumOfIsland obj = new FindNumOfIsland();
        System.out.println("Total Islands : " + obj.numOfIsland2(mat));
        System.out.println("Max island size : " + obj.maxCount);
    }

    //Efficient Using DFS
    public int numOfIsland(int[][] mat) {
        return util(mat, true);
    }

    public int numOfIsland2(int[][] mat) {
        return util(mat, false);
    }

    private int util(int[][] mat, boolean isDFS) {
        int row = mat.length;
        int col = mat[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && !isVisited[i][j]) {
                    count++;
                    System.out.print("Island " + count + "th : ");
                    IslandSize islandSize = new IslandSize();
                    if (isDFS)
                        DFS(mat, i, j, isVisited, islandSize);
                    else
                        BFS(mat, i, j, isVisited, islandSize);
                    maxCount = Math.max(maxCount, islandSize.size);
                    System.out.println();
                }
            }
        }
        return count;
    }

    private void DFS(int[][] mat, int row, int col, boolean[][] isVisited, IslandSize islandSize) {
        isVisited[row][col] = true;
        System.out.print(mat[row][col] + " ");
        islandSize.size++;
        int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] c = {-1, 0, 1, -1, 1, -1, 0, 1};
        int n = r.length;
        for (int i = 0; i < n; i++) {
            if (isSafe(mat, row + r[i], col + c[i], isVisited)) {
                DFS(mat, row + r[i], col + c[i], isVisited, islandSize);
            }
        }
    }

    public boolean isSafe(int[][] mat, int row, int col, boolean[][] isVisited) {
        int ROW = mat.length;
        int COL = mat[0].length;
        return row >= 0 && row < ROW && col >= 0 && col < COL
                && !isVisited[row][col] && mat[row][col] == 1;
    }

    //Using Queue
    private void BFS(int[][] mat, int row, int col, boolean[][] isVisited, IslandSize islandSize) {
        Queue<Pair> queue = new Queue<>();
        int val = mat[row][col];
        queue.add(new Pair(row, col));
        isVisited[row][col] = true;
        System.out.print(val + " ");
        islandSize.size++;
        int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] c = {-1, 0, 1, -1, 1, -1, 0, 1};
        int n = r.length;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int i = p.first;
            int j = p.second;
            for (int k = 0; k < n; k++) {
                if (isSafe(mat, i + r[k], j + c[k], isVisited)) {
                    isVisited[i + r[k]][j + c[k]] = true;
                    int data = mat[i + r[k]][j + c[k]];
                    queue.add(new Pair(i + r[k], j + c[k]));
                    System.out.print(data + " ");
                    islandSize.size++;
                }
            }
        }
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" +
                    +first +
                    "," + second +
                    ')';
        }
    }
}
