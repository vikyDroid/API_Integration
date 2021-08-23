package com.vikydroid.mylib.oldIntel.practice.practice2.array;

import java.util.HashMap;

public class SingleAppearance {

    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 4, 5, 3, 4};
        System.out.println(new SingleAppearance().checkSingleAppearance(arr));
    }

    //O(n)
    public int checkSingleAppearance(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            sum1 += key;
            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            } else {
                hm.put(key, 1);
            }
        }

        for (int i : hm.keySet()) {
            sum2 += i * 2;
        }

        return sum2 - sum1;
    }
}
