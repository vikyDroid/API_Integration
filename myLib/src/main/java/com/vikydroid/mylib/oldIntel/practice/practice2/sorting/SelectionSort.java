package com.vikydroid.mylib.oldIntel.practice.practice2.sorting;

import java.util.Arrays;

import static com.vikydroid.mylib.oldIntel.practice.practice1.constants.MyConstants.swap;

//Selecting the min from the whole array and placing it at 0,1,2...n-1 indices
public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};
        new SelectionSort().selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = arr[i], index = -1;
            for (int j = i; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != -1)
                swap(arr, i, index);
        }
    }
}
