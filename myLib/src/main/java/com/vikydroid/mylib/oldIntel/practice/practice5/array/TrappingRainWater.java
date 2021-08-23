package com.vikydroid.mylib.oldIntel.practice.practice5.array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int total = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            total += (Math.min(leftMax(arr, i), rightMax(arr, i)) - arr[i]);
        }
        System.out.println("Max val = " + total);
    }

    private static int leftMax(int[] arr, int i) {
        int max = arr[i];
        while (i > 0) {
            max = Math.max(arr[i - 1], max);
            i--;
        }
        return max;
    }

    private static int rightMax(int[] arr, int i) {
        int max = arr[i];
        while (i < arr.length - 1) {
            max = Math.max(arr[i + 1], max);
            i++;
        }
        return max;
    }
}
