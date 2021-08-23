package com.vikydroid.mylib.oldIntel.practice.practice2.sorting;

import java.util.Arrays;

import static com.vikydroid.mylib.oldIntel.practice.practice1.constants.MyConstants.swap;

//Inserting val at it's right pos
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        new InsertionSort().insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j > 0; j--) {  // j=i+1
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }
}
