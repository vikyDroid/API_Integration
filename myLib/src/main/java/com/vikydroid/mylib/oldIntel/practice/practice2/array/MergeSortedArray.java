package com.vikydroid.mylib.oldIntel.practice.practice2.array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        int[] A = {5, 8, 9};
        int[] B = {4, 7, 8};
        int[] C = new MergeSortedArray().mergeSorted(A, B);
        System.out.println(Arrays.toString(C));
    }

    //Time =  O(n1 + n2) and Space =  O(n1 + n2)
    public int[] mergeSorted(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr1.length;
        int n3 = n1 + n2;
        int[] arr3 = new int[n3];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }
}
