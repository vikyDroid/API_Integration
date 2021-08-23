package com.vikydroid.mylib.oldIntel.practice.practice2.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

    public void calculateMedian(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> greater = new PriorityQueue<>();
        double med = arr[0];
        smaller.add(arr[0]);
        System.out.println(med);

        for (int i = 1; i < n; i++) {
            int x = arr[i];
            if (smaller.size() > greater.size()) {
                if (x < med) {
                    greater.add(smaller.remove());
                    smaller.add(x);
                } else greater.add(x);
                med = (double) (smaller.peek() + greater.peek()) / 2;
            } else if (smaller.size() == greater.size()) {
                if (x < med) {
                    smaller.add(x);
                    med = (double) smaller.peek();
                } else {
                    greater.add(x);
                    med = (double) greater.peek();
                }
            } else {
                if (x > med) {
                    smaller.add(greater.remove());
                    greater.add(x);
                } else smaller.add(x);
                med = (double) (smaller.peek() + greater.peek()) / 2;
            }
            System.out.println(med);
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 10, 20, 3};
        new MedianOfStream().calculateMedian(arr);
    }
}
