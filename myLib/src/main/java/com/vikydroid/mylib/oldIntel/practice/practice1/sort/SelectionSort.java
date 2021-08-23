package com.vikydroid.mylib.oldIntel.practice.practice1.sort;

import java.util.Arrays;

import static com.practice.practice.practice1.constants.MyConstants.a;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        new SelectionSort().selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int small = arr[i], pos = -1;
            for (int j = i + 1; j < n; j++) {
                if (small > arr[j]) {
                    small = arr[j];
                    pos = j;
                }
            }
            if (arr[i] > small) {
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
            }
        }
    }
}
