package com.vikydroid.mylib.oldIntel.practice.practice1.sort;

import java.util.Arrays;

import static com.practice.practice.practice1.constants.MyConstants.a;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        new InsertionSort().insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j > 0 && j < n; j--) { //Logic
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

}
