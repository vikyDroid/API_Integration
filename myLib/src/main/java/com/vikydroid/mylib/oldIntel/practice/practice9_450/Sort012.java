package com.vikydroid.mylib.oldIntel.practice.practice9_450;

import java.util.Arrays;

import static com.practice.practice.practice1.constants.MyConstants.swap;

public class Sort012 {
    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 3, 2, 3, 3, 0};
        sort012(a);
        System.out.println(Arrays.toString(a));
    }

    static void sort012(int[] a) {
        int n = a.length, l = 0, r = n - 1;
        for (int i = 0; i < n && i <= r; i++) {
            if (a[i] == 0) {
                swap(a, i, l);
                l++;
            } else if (a[i] == 2) {
                swap(a, i, r);
                r--;
                i--;
            }
        }
    }
}
