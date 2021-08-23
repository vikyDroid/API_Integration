package com.vikydroid.mylib.oldIntel.practice.practice5.array;

import java.util.Arrays;

public class MergeSorted {
    public static void main(String[] args) {
        int[] arr1 = {5, 8, 9};
        int[] arr2 = {4, 7, 8};
        int[] arr = mergeSorted(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeSorted(int[] arr1, int[] arr2) {
        int l = 0, r = 0, f = 0;
        int[] arr = new int[arr1.length + arr2.length];
        while (l < arr1.length && r < arr2.length) {
            if (arr1[l] < arr2[r]) {
                arr[f] = arr1[l];
                l++;
            } else {
                arr[f] = arr2[r];
                r++;
            }
            f++;
        }
        while (l < arr1.length) {
            arr[f] = arr1[l];
            l++;
            f++;
        }
        while (r < arr2.length) {
            arr[f] = arr2[r];
            r++;
            f++;
        }
        return arr;
    }
}
