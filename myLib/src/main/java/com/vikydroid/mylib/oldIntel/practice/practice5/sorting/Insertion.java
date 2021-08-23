package com.vikydroid.mylib.oldIntel.practice.practice5.sorting;

import java.util.Arrays;

import static com.vikydroid.mylib.oldIntel.practice.practice1.constants.MyConstants.swap;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 10, 12, 1, 5, 6};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

}
