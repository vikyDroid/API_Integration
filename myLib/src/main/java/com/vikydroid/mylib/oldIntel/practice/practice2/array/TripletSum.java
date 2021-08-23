package com.vikydroid.mylib.oldIntel.practice.practice2.array;

import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 1, 6, 9};
        int sum = 24;
        new TripletSum().tripletSum(arr, sum);
    }

    //O(n^2)
    public void tripletSum(int[] arr, int sum) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1, diff = sum - arr[i];
            while (l < r) {
                int innerSum = arr[l] + arr[r];
                if (innerSum == diff) {
                    System.out.print("(" + arr[i] + "," + arr[l] + "," + arr[r] + ")");
                    l++;
                    r--;
                } else if (innerSum < diff) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }

}
