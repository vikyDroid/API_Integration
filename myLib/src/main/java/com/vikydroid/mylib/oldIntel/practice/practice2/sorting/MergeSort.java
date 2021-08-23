package com.vikydroid.mylib.oldIntel.practice.practice2.sorting;

import java.util.Arrays;

//Divide and conquer
public class MergeSort {
    public static void main(String[] args) {
        int[] A = {12, 11, 13, 5, 6, 7};
        new MergeSort().mergeSort(A);
        System.out.println(Arrays.toString(A));

    }

    public void mergeSort(int[] A) {
        int n = A.length;
        if (n < 2) return;
        int l = 0, r = n - 1, m = (l + r) / 2;
        int[] L = new int[m];
        int[] R = new int[n - m];
        mergeSort(L);
        mergeSort(R);
        merge(A, L, R);
    }

    private void merge(int[] A, int[] L, int[] R) {
        int l = L.length, r = R.length;
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            if (L[i] < R[j]) {
                A[k++] = L[i++];
            } else {
                A[k++] = R[j++];
            }
        }
        while (i < l) {
            A[k++] = L[i++];
        }
        while (j < r) {
            A[k++] = R[j++];
        }
    }

}
