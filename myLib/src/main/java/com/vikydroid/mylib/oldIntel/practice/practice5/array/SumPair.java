package com.vikydroid.mylib.oldIntel.practice.practice5.array;

import static java.util.Arrays.sort;


public class SumPair {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        sumPair(arr, sum);
    }

    static void sumPair(int[] arr, int sum) {
        sort(arr);
        int n = arr.length;
        int l = 0, r = n - 1;
        /*while (l < r) {
            int s = arr[l] + arr[r];
            if (s == sum) {
                System.out.print("(" + arr[l] + "," + arr[r] + ")");
                l++;
                r--;
            } else if (s < sum) l++;
            else r--;
        }*/
        for (int i = 0; i < n; i++) {
            int s = arr[l] + arr[r];
            if (s == sum) {
                System.out.print("(" + arr[l] + "," + arr[r] + ")");
                l++;
                r--;
            } else if (s < sum) l++;
            else r--;
        }
    }
}
