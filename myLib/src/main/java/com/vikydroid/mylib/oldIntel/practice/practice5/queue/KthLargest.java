package com.vikydroid.mylib.oldIntel.practice.practice5.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for(int i: arr){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }
        System.out.println(q.poll());

    }
}
