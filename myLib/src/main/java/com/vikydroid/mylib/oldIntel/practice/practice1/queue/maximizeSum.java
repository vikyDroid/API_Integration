package com.vikydroid.mylib.oldIntel.practice.practice1.queue;
// A PriorityQueue based Java program to maximize array
// sum after k negations. 

import java.util.PriorityQueue;

class maximizeSum {
    public static int maxSum(int[] a, int k) {
        // Create a priority queue and insert all array elements
        // int
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : a)
            pq.add(x);

        // Do k negations by removing a minimum element k times
        while (k-- > 0) {
            // Retrieve and remove min element
            int temp = pq.poll();

            // Modify the minimum element and add back
            // to priority queue
            temp *= -1;
            pq.add(temp);
        }

        // Compute sum of all elements in priority queue.
        int sum = 0;
        for (int x : pq)
            sum += x;
        return sum;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {9, 8, 8, 5};
        int k = 3;
        System.out.println(maxSum(arr, k));
    }
} 
