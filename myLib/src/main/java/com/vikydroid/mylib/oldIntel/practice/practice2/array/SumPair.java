package com.vikydroid.mylib.oldIntel.practice.practice2.array;

import java.util.Arrays;
import java.util.HashMap;

//Print all pairs with given sum in non-sorted array
public class SumPair {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        new SumPair().sumPairs(arr, sum);
        new SumPair().sumPairs2(arr, sum);
        new SumPair().sumPairs3(arr, sum);

    }

    //O(n) but after sorting
    public void sumPairs3(int[] arr, int sum) {
        int n = arr.length;
        Arrays.sort(arr); //Sorting
        int l = 0, r = n - 1;
        while (l < r) {
            int i = arr[l] + arr[r];
            if (i == sum) {
                System.out.print("(" + arr[l] + "," + arr[r] + ") ");
                l++;
                r--;
            } else if (i < sum) {
                l++;
            } else {
                r--;
            }
        }

    }

    //O(n^2)
    public void sumPairs(int[] A, int sum) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] + A[j] == sum) {
                    System.out.print("(" + A[i] + "," + A[j] + ") ");
                }
            }
        }
    }

    //O(n) with hashmap
    public void sumPairs2(int[] A, int sum) {
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = sum - A[i];
            if (hm.containsKey(key)) {
                System.out.print("(" + key + "," + hm.get(key) + ") ");
            } else {
                hm.put(A[i], key);
            }
        }
    }
}
