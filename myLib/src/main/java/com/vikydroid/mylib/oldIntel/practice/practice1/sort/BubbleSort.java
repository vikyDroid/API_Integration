package com.vikydroid.mylib.oldIntel.practice.practice1.sort;

import java.util.Arrays;

import static com.vikydroid.mylib.oldIntel.practice.practice1.constants.MyConstants.a;

public class BubbleSort {
    public static void main(String[] args) {
        new BubbleSort().bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) { //Logic
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
