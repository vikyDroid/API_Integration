package com.vikydroid.mylib.oldIntel.practice.practice8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {
    public static void main(String[] args) {
        int n = 4;
        int e = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 0);
//        addEdge(graph, 2, 3);
        addEdge(graph, 3, 3);
//        printAll(graph);
        dfs(graph);
    }

    private static void printAll(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Adjacency List of vertex: " + i);
            System.out.print("Head");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> " + graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
//        graph.get(v).add(u);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph) {
        System.out.println("DFS from vertex 1: ");
        boolean[] vis = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!vis[i])
                dfsUtil(i, vis, graph);
        }
    }

    private static void dfsUtil(int vertex, boolean[] vis, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        stack.add(vertex);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            if (!vis[i]) {
                System.out.print(i);
                vis[i] = true;
                for (int j = 0; j < graph.get(i).size(); j++) {
                    stack.add(graph.get(i).get(j));
                }
            }
        }
    }

    private static boolean allNotVisited(boolean[] vis) {
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) return true;
        }
        return false;
    }

    //For directed graph
    private static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, adj, vis, rec))
                return true;
        }
        return false;
    }

    private static boolean isCyclicUtil(int v, ArrayList<ArrayList<Integer>> list, boolean[] vis, boolean[] rec) {
        if (rec[v]) return true;
        if (vis[v]) return false;
        rec[v] = true;
        vis[v] = true;
        for (int i = 0; i < list.get(v).size(); i++) {
            if (isCyclicUtil(list.get(v).get(i), list, vis, rec))
                return true;
        }
        rec[v] = false;
        return false;
    }
}
