package com.vikydroid.mylib.oldIntel.practice.practice1.sort;

import java.util.Arrays;

import static com.vikydroid.mylib.oldIntel.practice.practice1.constants.MyConstants.a;

//Divide and conquer with pivot
public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        new QuickSort().quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
//        int[] a = {10, 20};
//        System.out.println(a[0] + "   " + a[1]);
//        new QuickSort().swap(a, 0, 1);
//        System.out.println(a[0] + "   " + a[1]);
//        int a = 10, b = 20;
//        System.out.println(a + "  " + b);
//        new QuickSort().swap(a, b);
//        System.out.println(a + "  " + b);
    }

    private void quickSort(int[] A, int left, int right) {
        if (left < right) {
            int pIndex = partition(A, left, right);
            quickSort(A, left, pIndex - 1);
            quickSort(A, pIndex + 1, right);
        }
    }

    int partition(int[] A, int left, int right) {
        int pivot = A[right], pIndex = left;
        for (int i = left; i < right; i++) {
            if (A[i] <= pivot) {
                swap(A, i, pIndex);
                pIndex++;
            }
        }
        swap(A, right, pIndex);
        return pIndex;
    }

    /*int partition2(int[] A, int left, int right) {
        int pivot = A[left], pIndex = left + 1;
        for (int i = left + 1; i < right; i++) {

            if (A[i] <= pivot) {
                swap(A, i, pIndex);
                pIndex++;
            }
        }
        swap(A, left, pIndex);
        return pIndex;
    }*/

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + "   " + b);
    }
}

