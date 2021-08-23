package com.vikydroid.mylib.oldIntel.practice.practice5.array;

import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 9;
        tripletSum(arr, sum);
    }

    private static void tripletSum(int[] arr, int x) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int l = i + 1, r = arr.length - 1;
            while (l < r) {
                int diff = x - arr[i];
                int sum = arr[l] + arr[r];
                if (sum == diff) {
                    System.out.println("(" + arr[i] + "," + arr[l] + "," + arr[r] + ")");
                    l++;
                    r--;
                } else if (sum < diff) {
                    l++;
                } else r--;
            }
        }
    }
}
