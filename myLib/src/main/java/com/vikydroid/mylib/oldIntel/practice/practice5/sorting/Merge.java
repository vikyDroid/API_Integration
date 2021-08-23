package com.vikydroid.mylib.oldIntel.practice.practice5.sorting;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            int[] x = new int[n / 2];
            int[] y;
            if (n % 2 == 0) {
                y = new int[n / 2];
            } else {
                y = new int[n / 2 + 1];
            }
            System.arraycopy(arr, 0, x, 0, n / 2);
            System.arraycopy(arr, n / 2, y, 0, y.length);

            mergeSort(x);
            mergeSort(y);

        } else {
//            merge();
        }
    }

    private static void merge(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {

        }
    }
}
