package com.vikydroid.mylib.oldIntel.practice.practice9_450;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxMinInArr {
    public static void main(String[] args) {
        int[] a = {10, 43, 23, 7, 4, 56, 8, 23, 66};
        Entity entity = getMinMax(a);
        System.out.println("min: " + entity.min + " max: " + entity.max);

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    }

    static Entity getMinMax(int[] a) {
        int n = a.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : a) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        return new Entity(min, max);
    }

    static class Entity {
        int min, max;

        Entity(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
