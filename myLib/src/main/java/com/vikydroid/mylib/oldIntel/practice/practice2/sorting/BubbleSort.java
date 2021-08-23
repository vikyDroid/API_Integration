package com.vikydroid.mylib.oldIntel.practice.practice2.sorting;

import java.util.Arrays;

import static com.practice.practice.practice1.constants.MyConstants.swap;

//Lighter bubble comes up by getting compared with its next neighbour
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        new BubbleSort().bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


    //Main program
    public void bubbleSort2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {      // n - 1 - i
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }


    public void bubbleSort3(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {   // n - 1 - i
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                } else if (j == n - i - 3) {       //Checking for the last swap to make it efficient
                    return;
                }
            }
        }
    }

    //Unknown Miracle, don't know how it is sorting
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    swap(arr, i, j);
            }
        }
    }
}
