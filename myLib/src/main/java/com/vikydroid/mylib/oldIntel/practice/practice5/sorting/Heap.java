package com.vikydroid.mylib.oldIntel.practice.practice5.sorting;

import java.util.Arrays;

import static com.practice.practice.practice1.constants.MyConstants.swap;

public class Heap {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 20};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1; //Left Child
        int r = 2 * i + 2; //Right Child

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, n);
        }
    }
}
