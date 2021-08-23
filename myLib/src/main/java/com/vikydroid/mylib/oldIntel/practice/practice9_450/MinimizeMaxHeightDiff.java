package com.vikydroid.mylib.oldIntel.practice.practice9_450;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=29uyA4F9t5I
 */
public class MinimizeMaxHeightDiff {
    public static void main(String[] args) {
        int[] a = {1, 10, 14, 14, 14, 15};
        int k = 6;
        System.out.println(getMinDiff(a, a.length, k));
    }

    static int getMinDiff(int[] a, int n, int k) { //O(n)
        int min, max, r;
        Arrays.sort(a);
        r = a[n - 1] - a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] >= k) {
                min = Math.min(a[0] + k, a[i] - k);
                max = Math.max(a[n - 1] - k, a[i - 1] + k);
                r = Math.min(r, max - min);
            }
        }
        return r;
    }

}
