package com.vikydroid.mylib.oldIntel.practice.practice5.dp;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr, 0, arr.length - 1));
    }

    private static int minJumps(int[] arr, int start, int end) {
        if (start >= end) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[start]; i++) {
            min = Math.min(min, minJumps(arr, start + i, end));
        }
        return min;
    }
}
