package com.vikydroid.mylib.oldIntel.practice.practice5.array;

import java.util.HashMap;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {5, 40, 1, 40, 100000, 1, 5, 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) >= 2) {
                System.out.println(i);
            }
        }
    }
}
