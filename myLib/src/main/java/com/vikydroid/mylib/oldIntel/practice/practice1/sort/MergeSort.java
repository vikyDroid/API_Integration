package com.vikydroid.mylib.oldIntel.practice.practice1.sort;

import java.util.Arrays;

import static com.practice.practice.practice1.constants.MyConstants.a;

//Divide and Conquer
public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        new MergeSort().mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    void mergeSort(int[] A) {
        int n = A.length;
        if (n < 2) return;

        int mid = n / 2;
        int[] L = new int[mid];
        int[] R = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            L[i] = A[i];
        }
        for (int i = mid; i < n; i++) {
            R[i - mid] = A[i];
        }
        mergeSort(L);
        mergeSort(R);
        merge(A, L, R);
    }

    private void merge(int[] A, int[] L, int[] R) {
        int lLength = L.length, rLength = R.length,  i = 0, j = 0, k = 0;

        while (i < lLength && j < rLength) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < lLength) {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < rLength) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
}
