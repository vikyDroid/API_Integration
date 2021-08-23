package com.vikydroid.mylib.oldIntel.practice.practice7.array;

public class MaxDiff {
    public static void main(String[] args) {
        int[] arr = {1, 2, 90, 10, 110,0,150};
        System.out.println(maxDiff(arr));
    }

    private static int maxDiff(int[] arr) {
        int minEle = arr[0], n = arr.length;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, arr[i] - minEle);
            minEle = Math.min(minEle, arr[i]);
        }
        return maxDiff;
    }
}
