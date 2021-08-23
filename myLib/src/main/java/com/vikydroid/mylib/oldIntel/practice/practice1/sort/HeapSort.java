package com.vikydroid.mylib.oldIntel.practice.practice1.sort;

import com.vikydroid.mylib.oldIntel.practice.practice1.constants.MyConstants;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int A[] = {12, 11, 13, 5, 6, 7};
        System.out.println(Arrays.toString(A));
        new HeapSort().heapSort(A);
        System.out.println(Arrays.toString(A));
    }

    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            MyConstants.swap(arr, 0, i);
            heapify(arr, i, 0);
        }

    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1; //LEFT CHILD
        int r = 2 * i + 2; //RIGHT CHILD

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            MyConstants.swap(arr, i, largest);
            heapify(arr, n, largest);
        }

    }
}
