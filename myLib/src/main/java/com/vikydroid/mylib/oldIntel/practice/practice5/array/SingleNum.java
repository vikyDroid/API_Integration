package com.vikydroid.mylib.oldIntel.practice.practice5.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNum {
    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 4, 5, 3, 4};
        singleNum2(arr);
    }

    private static void singleNum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) break;
                else if (j == arr.length - 1) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    private static void singleNum2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) System.out.println(i);
        }
    }
}
