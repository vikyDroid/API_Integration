package com.vikydroid.mylib.oldIntel.practice.practice7.array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapWater(arr));
        System.out.println(trapWater2(arr));
        System.out.println(trapWater3(arr));
    }

    private static int trapWater(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = Math.min(leftMax(arr, i), rightMax(arr, i));
            max += x - arr[i];
        }
        return max;
    }

    private static int leftMax(int[] arr, int i) {
        int max = Integer.MIN_VALUE;
        while (i >= 0) {
            max = Math.max(max, arr[i--]);
        }
        return max;
    }

    private static int rightMax(int[] arr, int i) {
        int max = Integer.MIN_VALUE;
        while (i < arr.length) {
            max = Math.max(max, arr[i++]);
        }
        return max;
    }

    static int trapWater2(int[] arr) {
        int n = arr.length;
        int[] lm = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            lm[i] = max;
        }
        int[] rm = new int[n];
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            rm[i] = max;
        }
        max = 0;
        for (int i = 0; i < n; i++) {
            max += Math.min(lm[i], rm[i]) - arr[i];
        }
        return max;
    }

    static int trapWater3(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1, lm = 0, rm = 0, res = 0;
        while (l <= r) {
            if (arr[l] < arr[r]) {
                if (arr[l] > lm) {
                    lm = arr[l];
                } else {
                    res += lm - arr[l];
                }
                l++;
            } else {
                if (arr[r] > rm) {
                    rm = arr[r];
                } else {
                    res += rm = arr[r];
                }
                r--;
            }
        }
        return res;
    }
}
