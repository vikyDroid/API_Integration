package com.vikydroid.mylib.oldIntel.practice.practice5.sorting;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        int min, minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

    }
}
