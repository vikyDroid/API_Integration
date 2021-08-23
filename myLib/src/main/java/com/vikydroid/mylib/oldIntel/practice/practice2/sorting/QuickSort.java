package com.vikydroid.mylib.oldIntel.practice.practice2.sorting;

import java.util.Arrays;

import static com.practice.practice.practice1.constants.MyConstants.swap;

//Divide and conquer
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, r);
        }

    }

    private int partition(int[] arr, int l, int r) {
        int pi = l, last = arr[r];
        for (int i = l; i < r; i++) {
            if (arr[i] <= last) {
                swap(arr, i, pi);
                pi++;
            }
        }
        swap(arr, pi, r);
        return pi;
    }
}
