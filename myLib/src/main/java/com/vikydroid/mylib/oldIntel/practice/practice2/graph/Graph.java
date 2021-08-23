package com.vikydroid.mylib.oldIntel.practice.practice2.graph;

import com.vikydroid.mylib.oldIntel.practice.practice2.templateT.Queue;
import com.vikydroid.mylib.oldIntel.practice.practice2.templateT.Stack;

import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer>[] arr;

    boolean isUndirected;

    Graph(int V) {
        initialise(V);
    }

    private void initialise(int V) {
        this.V = V;
        arr = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            arr[i] = new LinkedList<>();
        }
    }

    Graph(int V, boolean isUndirected) {
        initialise(V);
        this.isUndirected = isUndirected;

    }

    public void addEdge(int u, int v) {
        arr[u].add(v);
        if (isUndirected)
            arr[v].add(u);
    }


    public void DFSr() {
        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisited[i])
                DFSUtilr(i, isVisited);
        }
    }

    private void DFSUtilr(int v, boolean[] isVisited) {
        isVisited[v] = true;
        System.out.print(v + " ");
        for (int i : arr[v]) {
            if (!isVisited[i]) {
                DFSUtilr(i, isVisited);
            }
        }
    }

    public void DFS() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    private void DFSUtil(int s, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        while (!stack.isEmpty()) {
            s = stack.pop();
            if (!visited[s]) {
                System.out.print(s + " ");
                visited[s] = true;
            }
            for (int i : arr[s]) {
                if (!visited[i]) {
                    stack.add(i);
                }
            }
        }
    }

    public void BFS() {
        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisited[i])
                BFSUtil(i, isVisited);
        }
    }

    private void BFSUtil(int i, boolean[] isVisited) {
        Queue<Integer> queue = new Queue<>();
        isVisited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            i = queue.poll();
            System.out.print(i + " ");

            for (int j : arr[i]) {
                if (!isVisited[j]) {
                    isVisited[j] = true;
                    queue.add(j);
                }
            }
        }
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                topologicalSortUtil(i, stack, isVisited);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void topologicalSortUtil(int v, Stack<Integer> stack, boolean[] isVisited) {
        isVisited[v] = true;
        for (int i : arr[v]) {
            if (!isVisited[i]) {
                topologicalSortUtil(i, stack, isVisited);
            }
        }
        stack.add(v);
    }

    private void printConnected() {
        boolean[] isVisited = new boolean[V];
        int j = 0;
        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                System.out.print("Connected Component " + ++j + "th : ");
                printConnectedUtil(i, isVisited);
                System.out.println();
            }
        }
    }

    private void printConnectedUtil(int v, boolean[] isVisited) {
        isVisited[v] = true;
        System.out.print(v + " ");
        for (int i : arr[v]) {
            if (!isVisited[i])
                printConnectedUtil(i, isVisited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5, true);
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.printConnected();
    }


}
