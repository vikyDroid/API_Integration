package com.vikydroid.mylib.oldIntel.practice.practice2.sorting;

import java.util.Arrays;

import static com.practice.practice.practice1.constants.MyConstants.swap;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        new HeapSort().heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void heapSort(int[] arr) {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;      //LEFT CHILD
        int r = 2 * i + 2;      //RIGHT CHILD
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) { // If right child is larger than largest so far
            largest = r;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest); // After Swap Recursively heapify the affected sub-tree
        }
    }
}