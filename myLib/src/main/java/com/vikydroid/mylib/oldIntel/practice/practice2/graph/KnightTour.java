package com.vikydroid.mylib.oldIntel.practice.practice2.graph;


import com.practice.practice.practice2.templateT.LinkedList;
import com.practice.practice.practice2.templateT.Queue;

//import java.util.LinkedList;

public class KnightTour {
    private static final int N = 6;

    public static void main(String[] args) {
        int[][] mat = new int[N + 1][N + 1];
        mat[6][1] = 1;
        System.out.println("\nMinimum num of steps required : " +
                new KnightTour().stepsRequired(mat, 2, 4));
    }

    public int stepsRequired(int[][] mat, int row, int col) {
        LinkedList<Cell> list = new LinkedList<>();
        boolean[][] isVisited = new boolean[N + 1][N + 1];
        Cell cell = BFS(mat, row, col, isVisited);
        System.out.println("\nItems in list: \n");
        printAll(cell);
        return cell.dis;
    }

    private void printAll(Cell cell) {
        if (cell == null) {
            System.out.println("List is empty");
            return;
        }
        while (cell != null) {
            System.out.print(cell + "<-");
            cell = cell.prev;

        }

    }

    /**
     * Shortest Path in Unweighted graph (BFS with Queue)
     *
     * @return
     */
    private Cell BFS(int[][] mat, int row, int col, boolean[][] isVisited) {
        Queue<Cell> queue = new Queue<>();
        Cell cell = new Cell(row, col, 0);
        isVisited[row][col] = true;
        queue.add(cell);
        int[] x = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] y = {-1, -2, -2, -1, 1, 2, 2, 1};
        int n = x.length;
        while (!queue.isEmpty()) {
            Cell c = queue.poll();
            int i = c.first;
            int j = c.second;
            for (int k = 0; k < n; k++) {
                int row1 = i + x[k];
                int col1 = j + y[k];
                if (isSafe(mat, row1, col1, isVisited)) {
                    Cell data = new Cell(row1, col1, c.dis + 1);
                    data.prev = c;
                    if (mat[row1][col1] == 1) {
                        return data;
                    }
                    isVisited[row1][col1] = true;
                    queue.add(data);
                }
            }
        }
        return null;
    }

    public boolean isSafe(int[][] mat, int row, int col, boolean[][] isVisited) {
        return row >= 1 && row <= N && col >= 1 && col <= N && !isVisited[row][col];
    }

    static class Cell {
        int first, second, dis;
        Cell prev;

        Cell(int first, int second, int dis) {
            this.first = first;
            this.second = second;
            this.dis = dis;
        }

        @Override
        public String toString() {
            return "(" +
                    +first +
                    "," + second +
//                    ", dis = " + dis +
                    ')';
        }
    }

}
