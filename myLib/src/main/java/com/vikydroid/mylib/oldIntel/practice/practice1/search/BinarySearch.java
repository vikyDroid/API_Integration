package com.vikydroid.mylib.oldIntel.practice.practice1.search;

import com.practice.practice.practice1.sort.BubbleSort;

import java.util.Arrays;

import static com.practice.practice.practice1.constants.MyConstants.a;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = { 1, 3, 6, 9, 19, 36 };
        new BubbleSort().bubbleSort(a);
        System.out.println(Arrays.toString(a));
        new BinarySearch().binarySearch(a, a[7]);
    }

    public void binarySearch(int[] A, int item) {
        int start = 0, end = A.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (item == A[mid]) {
                System.out.println(mid);
                return;
            } else if (item < A[mid]) {
                end = mid - 1;
            } else if (item > A[mid]) {
                start = mid + 1;
            }
        }
    }

    public int binarySearch(int[] A, int l, int r, int key) {
        if (l > r) return -1;
        int mid = (l + r) / 2;
        if (key == A[mid])
            return mid;
        if (key < A[mid])
            return binarySearch(A, l, mid - 1, key);
        else return binarySearch(A, mid + 1, r, key);
    }
}
