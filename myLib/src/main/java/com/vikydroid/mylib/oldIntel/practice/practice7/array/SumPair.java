package com.vikydroid.mylib.oldIntel.practice.practice7.array;

import java.util.Collections;
import java.util.HashMap;

public class SumPair {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        System.out.println(sumPair(arr, sum));
    }

    private static int sumPair(int[] arr, int sum) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int key = sum - arr[i];
            if (map.containsKey(key)) {
                Integer count = map.get(key);
                for (int j = 0; j < count; j++) {
                    System.out.print("(" + arr[i] + "," + key + ")");
                }
            }
        }
        return 0;
    }
}
