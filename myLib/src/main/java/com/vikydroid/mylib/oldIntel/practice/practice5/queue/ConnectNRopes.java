package com.vikydroid.mylib.oldIntel.practice.practice5.queue;

import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int total = 0;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (!queue.isEmpty()) {
                int b = queue.poll();
                total += a + b;
                queue.add(a + b);
            }

        }
        System.out.println(total);
    }
}
