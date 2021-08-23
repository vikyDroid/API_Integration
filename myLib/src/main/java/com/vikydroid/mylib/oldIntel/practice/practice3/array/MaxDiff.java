package com.vikydroid.mylib.oldIntel.practice.practice3.array;

public class MaxDiff {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 4, 8, 1, 16};
//        int[] arr = {1, 2, 90, 10, 110};
        System.out.println(maxDiff(arr));
    }

    private static int maxDiff(int[] arr) {
        int maxDiff = arr[1] - arr[0];
        int minEle = arr[0];
        for (int i = 2; i < arr.length; i++) {
            maxDiff = Math.max(maxDiff, arr[i] - minEle);
            minEle = Math.min(minEle, arr[i]);
        }
        return maxDiff;
    }
}
