package com.vikydroid.mylib.oldIntel.practice.practice2.queue;

import java.util.PriorityQueue;

public class MinCostPipes {
    public int getMinCost(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(arr[i]);
        }
        int minCost = 0;
        while (queue.size() > 1) {
            int sum = queue.remove() + queue.remove();
            minCost += sum;
            queue.add(sum);
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(new MinCostPipes().getMinCost(arr));
    }
}
