package com.vikydroid.mylib.oldIntel.practice.practice2.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 9;
        int pos = new BinarySearch().binarySearch(A, key);
        int pos2 = new BinarySearch().binarySearch(A, 0, A.length - 1, key);
        System.out.println(pos);
        System.out.println(pos2);
    }


    public int binarySearch(int[] arr, int key) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (key == arr[m]) {
                return m;
            }
            if (key < arr[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] A, int l, int r, int key) {
        if (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == key) {
                return m;
            }
            if (A[m] < key) {
                return binarySearch(A, m + 1, r, key);
            } else {
                return binarySearch(A, l, m - 1, key);
            }
        } else return -1;
    }
}
